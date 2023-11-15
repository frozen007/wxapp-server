package com.myz.wxapp.task.dao;

import com.myz.inf.datasource.DataSource;
import com.myz.wxapp.task.entity.UserTaskExecution;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: zhaomingyumt
 * @date: 2023/11/15 12:22 PM
 * @description:
 */
@Repository
@DataSource("dbuser")
public interface UserTaskExecutionDao {

    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "taskId", column = "task_id"),
            @Result(property = "userId", column = "user_id"),
            @Result(property = "execType", column = "exec_type"),
            @Result(property = "periodType", column = "period_type"),
            @Result(property = "fireTime", column = "fire_time"),
            @Result(property = "nextFireTime", column = "next_fire_Time"),
            @Result(property = "valid", column = "valid"),
            @Result(property = "creationTime", column = "creation_time"),
            @Result(property = "updateTime", column = "update_time")
    })
    @Select("select id, task_id, user_id, exec_type, period_type, fire_time, next_fire_time, valid, creation_time, update_time " +
            "from user_task_execution " +
            "where user_id=#{user_id} and valid=1 ")
    List<UserTaskExecution> queryUserTaskExecutions(@Param("user_id") Long userId);

}
