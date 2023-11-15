package com.myz.wxapp.task.service;

import com.myz.wxapp.api.task.CreateTaskRequest;
import com.myz.wxapp.api.task.TaskExecution;
import com.myz.wxapp.api.task.TaskService;
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
public class TaskServiceImpl implements TaskService {

    private static final Logger logger = LoggerFactory.getLogger(TaskServiceImpl.class);

    @Autowired
    private UserTaskRecordDao userTaskRecordDao;

    @Autowired
    private UserTaskExecutionDao userTaskExecutionDao;

    @Override
    public Long createTask(CreateTaskRequest request) {
        return null;
    }

    @Override
    public List<UserTask> queryTask(Long userId, Integer status) {
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
            userTasks = userTaskRecords.stream().filter(t -> status == null ? true : status == t.getStatus()).map(t ->
                    convertToUserTask(t, taskExecutionMap)
            ).collect(Collectors.toList());
        } else {
            return Collections.emptyList();
        }

        logger.info("userTasks={}", userTasks.size());
        return userTasks;
    }

    private UserTask convertToUserTask(UserTaskRecord userTaskRecord, Map<Long, UserTaskExecution> taskExecutionMap) {
        UserTask userTask = new UserTask();
        userTask.setId(userTaskRecord.getId());
        userTask.setUserId(userTaskRecord.getUserId());
        userTask.setName(userTaskRecord.getName());
        userTask.setDescription(userTaskRecord.getDescription());
        userTask.setStatus(userTaskRecord.getStatus());
        userTask.setTaskType(userTaskRecord.getTaskType());
        userTask.setCreateTime(userTaskRecord.getCreationTime());

        UserTaskExecution userTaskExecution = taskExecutionMap.get(userTask.getId());
        if (userTaskExecution != null) {
            TaskExecution taskExecution = new TaskExecution();
            taskExecution.setExecType(userTaskExecution.getExecType());
            taskExecution.setPeriodType(userTaskExecution.getPeriodType());
            taskExecution.setFireTime(userTaskExecution.getFireTime());
            taskExecution.setNextFireTime(userTaskExecution.getNextFireTime());
            userTask.setExecution(taskExecution);
        }

        return userTask;
    }
}
