package com.myz.wxapp.api.task;

import java.io.Serializable;

/**
 * @author: zhaomingyumt
 * @date: 2023/11/15 11:36 AM
 * @description:
 */
public class TaskExecution implements Serializable {

    private Integer execType;

    private Integer periodType;

    private Long fireTime;

    private Long nextFireTime;

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
}
