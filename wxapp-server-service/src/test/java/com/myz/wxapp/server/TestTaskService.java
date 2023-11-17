package com.myz.wxapp.server;

import com.myz.wxapp.api.task.CreateTaskReply;
import com.myz.wxapp.api.task.CreateTaskRequest;
import com.myz.wxapp.api.task.QueryTaskRequest;
import com.myz.wxapp.api.task.QueryTaskResult;
import com.myz.wxapp.api.task.TaskService;
import com.myz.wxapp.api.task.UserTask;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.bootstrap.DubboBootstrap;
import org.apache.dubbo.rpc.model.FrameworkModel;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

/**
 * @author: zhaomingyumt
 * @date: 2023/11/16 3:44 PM
 * @description:
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestTaskService {

    private ReferenceConfig<TaskService> taskServiceRef;

    private TaskService taskService;

    @BeforeAll
    public void init() {
        FrameworkModel frameworkModel = FrameworkModel.defaultModel();
        taskServiceRef = new ReferenceConfig<>();
        taskServiceRef.setInterface(TaskService.class);
        taskServiceRef.setUrl("tri://127.0.0.1:5050/com.myz.wxapp.api.task.TaskService");
        taskServiceRef.setCluster("failfast");
        taskServiceRef.setRetries(0);

        ApplicationConfig applicationConfig = new ApplicationConfig("test-TaskService");
        applicationConfig.setQosEnable(false);
        DubboBootstrap bootstrap = DubboBootstrap.getInstance(frameworkModel.newApplication())
                .application(applicationConfig)
//                .registry(new RegistryConfig("zookeeper://127.0.0.1:2181/dubbo"))
                .reference(taskServiceRef)
                .start();

        taskService = taskServiceRef.get();
    }

    @Test
    public void testQueryTask() {
        QueryTaskResult queryTaskResult = taskService.queryTask(QueryTaskRequest.newBuilder().setUserId(1L).build());
        for (UserTask userTask : queryTaskResult.getTasksList()) {
            System.out.println(userTask.getName());
        }
    }

    @Test
    public void testCreateTask() {
        CreateTaskReply createTaskReply = taskService.createTask(CreateTaskRequest.newBuilder()
                .setUserId(1L)
                .setName("test-task08")
                .setDescription("task08 desc")
                .setTaskType(1)
                .setExecType(1)
                .setPeriodType(0)
                .setFireTime(System.currentTimeMillis()+60000)
                .build());

        System.out.println(createTaskReply.getTaskId());
    }
}
