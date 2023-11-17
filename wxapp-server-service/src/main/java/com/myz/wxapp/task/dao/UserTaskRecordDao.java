package com.myz.wxapp.task.dao;

import com.myz.inf.datasource.DataSource;
import com.myz.wxapp.task.entity.UserTaskRecord;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: zhaomingyumt
 * @date: 2023/11/15 12:22 PM
 * @description:
 */
@Repository
@DataSource("dbuser")
public interface UserTaskRecordDao {

    long insertUserTaskRecord(UserTaskRecord userTaskRecord);

    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "userId", column = "user_id"),
            @Result(property = "name", column = "name"),
            @Result(property = "description", column = "description"),
            @Result(property = "status", column = "status"),
            @Result(property = "taskType", column = "task_type"),
            @Result(property = "payLoad", column = "pay_load"),
            @Result(property = "valid", column = "valid"),
            @Result(property = "creationTime", column = "creation_time"),
            @Result(property = "updateTime", column = "update_time")
    })
    @Select("""
            select id, user_id, name, description, status, task_type, pay_load, valid, creation_time, update_time
            from user_task_record
            where user_id=#{user_id} and valid=1
            order by creation_time desc
            """)
    List<UserTaskRecord> queryUserTaskRecords(@Param("user_id") long userId);

    @Update("""
            update user_task_record 
            set status=#{status}
            where id=#{task_id}
            """)
    int updateUserTaskRecord(@Param("user_id") long userId, @Param("task_id") long taskId, @Param("status") int status);

}
