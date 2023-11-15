package com.myz.wxapp.task.entity;

/**
 * @author: zhaomingyumt
 * @date: 2023/11/15 12:23 PM
 * @description:
 */
public class UserTaskExecution {
    private Long id;

    private Long userId;

    private Long taskId;

    private Integer execType;

    private Integer periodType;

    private Long fireTime;

    private Long nextFireTime;

    private Integer valid;

    private Long creationTime;

    private Long updateTime;

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

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
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

    public Long getNextFireTime() {
        return nextFireTime;
    }

    public void setNextFireTime(Long nextFireTime) {
        this.nextFireTime = nextFireTime;
    }

    public Integer getValid() {
        return valid;
    }

    public void setValid(Integer valid) {
        this.valid = valid;
    }

    public Long getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Long creationTime) {
        this.creationTime = creationTime;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }
}
