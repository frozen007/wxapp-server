package com.myz.wxapp.api.task;

import java.util.List;

/**
 * @author: zhaomingyumt
 * @date: 2023/11/14 4:13 PM
 * @description:
 */
public interface TaskService {

    Long createTask(CreateTaskRequest request);

    List<UserTask> queryTask(Long userId, Integer status);
}
