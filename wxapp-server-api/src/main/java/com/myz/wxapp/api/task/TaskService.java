/*
* Licensed to the Apache Software Foundation (ASF) under one or more
* contributor license agreements.  See the NOTICE file distributed with
* this work for additional information regarding copyright ownership.
* The ASF licenses this file to You under the Apache License, Version 2.0
* (the "License"); you may not use this file except in compliance with
* the License.  You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

    package com.myz.wxapp.api.task;

import org.apache.dubbo.common.stream.StreamObserver;
import com.google.protobuf.Message;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.concurrent.CompletableFuture;

public interface TaskService extends org.apache.dubbo.rpc.model.DubboStub {

    String JAVA_SERVICE_NAME = "com.myz.wxapp.api.task.TaskService";
    String SERVICE_NAME = "task.TaskService";

    com.myz.wxapp.api.task.CreateTaskReply createTask(com.myz.wxapp.api.task.CreateTaskRequest request);

    default CompletableFuture<com.myz.wxapp.api.task.CreateTaskReply> createTaskAsync(com.myz.wxapp.api.task.CreateTaskRequest request){
        return CompletableFuture.completedFuture(createTask(request));
    }

    /**
    * This server stream type unary method is <b>only</b> used for generated stub to support async unary method.
    * It will not be called if you are NOT using Dubbo3 generated triple stub and <b>DO NOT</b> implement this method.
    */
    default void createTask(com.myz.wxapp.api.task.CreateTaskRequest request, StreamObserver<com.myz.wxapp.api.task.CreateTaskReply> responseObserver){
        createTaskAsync(request).whenComplete((r, t) -> {
            if (t != null) {
                responseObserver.onError(t);
            } else {
                responseObserver.onNext(r);
                responseObserver.onCompleted();
            }
        });
    }

    com.myz.wxapp.api.task.QueryTaskResult queryTask(com.myz.wxapp.api.task.QueryTaskRequest request);

    default CompletableFuture<com.myz.wxapp.api.task.QueryTaskResult> queryTaskAsync(com.myz.wxapp.api.task.QueryTaskRequest request){
        return CompletableFuture.completedFuture(queryTask(request));
    }

    /**
    * This server stream type unary method is <b>only</b> used for generated stub to support async unary method.
    * It will not be called if you are NOT using Dubbo3 generated triple stub and <b>DO NOT</b> implement this method.
    */
    default void queryTask(com.myz.wxapp.api.task.QueryTaskRequest request, StreamObserver<com.myz.wxapp.api.task.QueryTaskResult> responseObserver){
        queryTaskAsync(request).whenComplete((r, t) -> {
            if (t != null) {
                responseObserver.onError(t);
            } else {
                responseObserver.onNext(r);
                responseObserver.onCompleted();
            }
        });
    }






}
