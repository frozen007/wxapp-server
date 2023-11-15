package com.myz.wxapp.task.service;

import com.myz.wxapp.api.task.CreateTaskReply;
import com.myz.wxapp.api.task.CreateTaskRequest;
import com.myz.wxapp.api.task.DubboTaskServiceTriple;
import com.myz.wxapp.api.task.QueryTaskRequest;
import com.myz.wxapp.api.task.QueryTaskResult;
import com.myz.wxapp.api.task.TaskExecution;
import com.myz.wxapp.api.task.UserTask;
import com.myz.wxapp.task.dao.UserTaskExecutionDao;
import com.myz.wxapp.task.dao.UserTaskRecordDao;
import com.myz.wxapp.task.entity.UserTaskExecution;
import com.myz.wxapp.task.entity.UserTaskRecord;
import org.apache.dubbo.config.annotation.DubboService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author: zhaomingyumt
 * @date: 2023/11/15 11:56 AM
 * @description:
 */
@DubboService
public class TaskServiceImpl extends DubboTaskServiceTriple.TaskServiceImplBase {

    private static final Logger logger = LoggerFactory.getLogger(TaskServiceImpl.class);

    @Autowired
    private UserTaskRecordDao userTaskRecordDao;

    @Autowired
    private UserTaskExecutionDao userTaskExecutionDao;

    @Override
    public CreateTaskReply createTask(CreateTaskRequest request) {

        return CreateTaskReply.newBuilder().setTaskId(0L).build();
    }

    @Override
    public QueryTaskResult queryTask(QueryTaskRequest request) {
        List<UserTask> userTasks = getUserTasks(request.getUserId(), request.getStatus());
        QueryTaskResult result = QueryTaskResult.newBuilder().addAllTasks(userTasks).setLength(userTasks.size()).build();
        return result;
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
