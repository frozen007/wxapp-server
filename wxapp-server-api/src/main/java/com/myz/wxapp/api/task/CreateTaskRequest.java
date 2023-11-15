package com.myz.wxapp.api.task;

/**
 * @author: zhaomingyumt
 * @date: 2023/11/15 11:52 AM
 * @description:
 */
public class CreateTaskRequest {
    private Long userId;

    private String name;

    private String description;

    private Integer taskType;

    private Integer execType;

    private Integer periodType;

    private Long fireTime;

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

    public Integer getTaskType() {
        return taskType;
    }

    public void setTaskType(Integer taskType) {
        this.taskType = taskType;
    }

    public Integer getExecType() {
        return execType;
    }

    public void setExecType(Integer execType) {
        this.execType = execType;
    }

    public Integer getPeriodType() {
        return periodType;
    }

    public void setPeriodType(Integer periodType) {
        this.periodType = periodType;
    }

    public Long getFireTime() {
        return fireTime;
    }

    public void setFireTime(Long fireTime) {
        this.fireTime = fireTime;
    }
}
