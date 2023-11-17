package com.myz.wxapp.task.service;

import com.myz.wxapp.api.task.CancelTaskReply;
import com.myz.wxapp.api.task.CancelTaskRequest;
import com.myz.wxapp.api.task.CreateTaskReply;
import com.myz.wxapp.api.task.CreateTaskRequest;
import com.myz.wxapp.api.task.QueryTaskRequest;
import com.myz.wxapp.api.task.QueryTaskResult;
import com.myz.wxapp.api.task.TaskExecution;
import com.myz.wxapp.api.task.TaskService;
import com.myz.wxapp.api.task.UserTask;
import com.myz.wxapp.task.dao.UserTaskExecutionDao;
import com.myz.wxapp.task.dao.UserTaskRecordDao;
import com.myz.wxapp.task.entity.UserTaskExecution;
import com.myz.wxapp.task.entity.UserTaskRecord;
import org.apache.dubbo.common.timer.HashedWheelTimer;
import org.apache.dubbo.common.timer.Timeout;
import org.apache.dubbo.common.timer.TimerTask;
import org.apache.dubbo.config.annotation.DubboService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author: zhaomingyumt
 * @date: 2023/11/15 11:56 AM
 * @description:
 */
@DubboService
public class TaskServiceImpl implements TaskService {

    private static final Logger logger = LoggerFactory.getLogger(TaskServiceImpl.class);

    @Autowired
    private UserTaskRecordDao userTaskRecordDao;

    @Autowired
    private UserTaskExecutionDao userTaskExecutionDao;

    @Qualifier("taskWheelTime")
    @Autowired
    private HashedWheelTimer taskWheelTimer;

    @Override
    public CreateTaskReply createTask(CreateTaskRequest request) {

        long userId = request.getUserId();

        UserTaskRecord userTaskRecord = new UserTaskRecord();
        userTaskRecord.setUserId(userId);
        userTaskRecord.setName(request.getName());
        userTaskRecord.setDescription(request.getDescription());
        userTaskRecord.setStatus(0);
        userTaskRecord.setTaskType(request.getTaskType());
        userTaskRecord.setPayLoad("{}");
        userTaskRecord.setValid(1);
        long currentTimeMillis = System.currentTimeMillis();
        userTaskRecord.setCreationTime(currentTimeMillis);
        userTaskRecord.setUpdateTime(currentTimeMillis);

        userTaskRecordDao.insertUserTaskRecord(userTaskRecord);
        long newTaskId = userTaskRecord.getId();

        UserTaskExecution userTaskExecution = new UserTaskExecution();
        userTaskExecution.setUserId(userId);
        userTaskExecution.setTaskId(newTaskId);
        userTaskExecution.setExecType(request.getExecType());
        userTaskExecution.setPeriodType(request.getPeriodType());
        userTaskExecution.setFireTime(request.getFireTime());

        //todo: only support OneTime task currently
        userTaskExecution.setNextFireTime(request.getFireTime());

        userTaskExecution.setValid(1);
        userTaskExecution.setCreationTime(currentTimeMillis);
        userTaskExecution.setUpdateTime(currentTimeMillis);
        userTaskExecutionDao.insertUserTaskExecution(userTaskExecution);

        //todo: send to delay-server
        /**
         * data to send
         *  taskId
         *  delay time
         *  todo: 
         */
        long delay = request.getFireTime() - currentTimeMillis;

        logger.info("new task:{} delay={}", request.getName(), delay);
        taskWheelTimer.newTimeout(new TimerTask() {
            @Override
            public void run(Timeout timeout) throws Exception {
                long time = System.currentTimeMillis();
                logger.info("task:{}, {}, fired!  current:{}, task scheduled:{}", request.getName(),
                        request.getDescription(), time, request.getFireTime());
                finishTask(userId, newTaskId);
            }
        }, delay, TimeUnit.MILLISECONDS);

        //update task status
        userTaskRecordDao.updateUserTaskRecord(userId, newTaskId, 1);

        return CreateTaskReply.newBuilder().setTaskId(newTaskId).build();
    }

    @Override
    public QueryTaskResult queryTask(QueryTaskRequest request) {
        List<UserTask> userTasks = getUserTasks(request.getUserId(), request.getStatus());
        QueryTaskResult result = QueryTaskResult.newBuilder().addAllTasks(userTasks).setLength(userTasks.size()).build();
        return result;
    }

    @Override
    public CancelTaskReply cancelTask(CancelTaskRequest request) {
        userTaskRecordDao.updateUserTaskRecord(request.getUserId(), request.getTaskId(), 3);

        //todo: execute cancel task process

        return null;
    }

    private List<UserTask> getUserTasks(long userId, int status) {
        logger.info("userId={}, status={}", userId, status);
        List<UserTaskExecution> userTaskExecutions = userTaskExecutionDao.queryUserTaskExecutions(userId);

        Map<Long, UserTaskExecution> taskExecutionMap;
        if (userTaskExecutions != null && !userTaskExecutions.isEmpty()) {
            taskExecutionMap = userTaskExecutions.stream().collect(
                    Collectors.toMap(UserTaskExecution::getTaskId, Function.identity()));
        } else {
            return Collections.emptyList();
        }

        List<UserTask> userTasks;
        List<UserTaskRecord> userTaskRecords = userTaskRecordDao.queryUserTaskRecords(userId);
        if (userTaskRecords != null && !userTaskRecords.isEmpty()) {
            userTasks = userTaskRecords.stream().filter(t -> status == 0 ? true : status == t.getStatus()).map(t ->
                    convertToUserTask(t, taskExecutionMap)
            ).collect(Collectors.toList());
        } else {
            return Collections.emptyList();
        }

        logger.info("userTasks={}", userTasks.size());
        return userTasks;
    }

    private void finishTask(long userId, long taskId) {
        userTaskRecordDao.updateUserTaskRecord(userId, taskId, 2);
    }

    private UserTask convertToUserTask(UserTaskRecord userTaskRecord, Map<Long, UserTaskExecution> taskExecutionMap) {
        UserTaskExecution userTaskExecution = taskExecutionMap.get(userTaskRecord.getId());
        UserTask.Builder builder = UserTask.newBuilder()
                .setId(userTaskRecord.getId())
                .setUserId(userTaskRecord.getUserId())
                .setName(userTaskRecord.getName())
                .setDescription(userTaskRecord.getDescription())
                .setStatus(userTaskRecord.getStatus())
                .setTaskType(userTaskRecord.getTaskType())
                .setCreateTime(userTaskRecord.getCreationTime());

        if (userTaskExecution != null) {
            TaskExecution taskExecution = TaskExecution.newBuilder()
                    .setExecType(userTaskExecution.getExecType())
                    .setPeriodType(userTaskExecution.getPeriodType())
                    .setFireTime(userTaskExecution.getFireTime())
                    .setNextFireTime(userTaskExecution.getNextFireTime()).build();
            builder.setExecution(taskExecution);
        }

        return builder.build();
    }
}
