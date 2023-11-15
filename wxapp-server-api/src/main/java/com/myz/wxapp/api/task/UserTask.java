package com.myz.wxapp.api.task;

import java.io.Serializable;

/**
 * @author: zhaomingyumt
 * @date: 2023/11/14 8:19 PM
 * @description:
 */
public class UserTask implements Serializable {

    private Long id;

    private Long userId;

    private String name;

    private String description;

    private Integer status;

    private Integer taskType;

    private Long createTime;

    private TaskExecution execution;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getTaskType() {
        return taskType;
    }

    public void setTaskType(Integer taskType) {
        this.taskType = taskType;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public TaskExecution getExecution() {
        return execution;
    }

    public void setExecution(TaskExecution execution) {
        this.execution = execution;
    }
}
