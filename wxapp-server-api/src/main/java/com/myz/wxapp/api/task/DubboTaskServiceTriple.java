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
import org.apache.dubbo.common.URL;
import org.apache.dubbo.rpc.Invoker;
import org.apache.dubbo.rpc.PathResolver;
import org.apache.dubbo.rpc.RpcException;
import org.apache.dubbo.rpc.ServerService;
import org.apache.dubbo.rpc.TriRpcStatus;
import org.apache.dubbo.rpc.model.MethodDescriptor;
import org.apache.dubbo.rpc.model.ServiceDescriptor;
import org.apache.dubbo.rpc.model.StubMethodDescriptor;
import org.apache.dubbo.rpc.model.StubServiceDescriptor;
import org.apache.dubbo.rpc.stub.BiStreamMethodHandler;
import org.apache.dubbo.rpc.stub.ServerStreamMethodHandler;
import org.apache.dubbo.rpc.stub.StubInvocationUtil;
import org.apache.dubbo.rpc.stub.StubInvoker;
import org.apache.dubbo.rpc.stub.StubMethodHandler;
import org.apache.dubbo.rpc.stub.StubSuppliers;
import org.apache.dubbo.rpc.stub.UnaryStubMethodHandler;

import com.google.protobuf.Message;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.concurrent.CompletableFuture;

public final class DubboTaskServiceTriple {

    public static final String SERVICE_NAME = TaskService.SERVICE_NAME;

    private static final StubServiceDescriptor serviceDescriptor = new StubServiceDescriptor(SERVICE_NAME,TaskService.class);

    static {
        org.apache.dubbo.rpc.protocol.tri.service.SchemaDescriptorRegistry.addSchemaDescriptor(SERVICE_NAME,TaskProto.getDescriptor());
        StubSuppliers.addSupplier(SERVICE_NAME, DubboTaskServiceTriple::newStub);
        StubSuppliers.addSupplier(TaskService.JAVA_SERVICE_NAME,  DubboTaskServiceTriple::newStub);
        StubSuppliers.addDescriptor(SERVICE_NAME, serviceDescriptor);
        StubSuppliers.addDescriptor(TaskService.JAVA_SERVICE_NAME, serviceDescriptor);
    }

    @SuppressWarnings("all")
    public static TaskService newStub(Invoker<?> invoker) {
        return new TaskServiceStub((Invoker<TaskService>)invoker);
    }

    private static final StubMethodDescriptor createTaskMethod = new StubMethodDescriptor("createTask",
    com.myz.wxapp.api.task.CreateTaskRequest.class, com.myz.wxapp.api.task.CreateTaskReply.class, serviceDescriptor, MethodDescriptor.RpcType.UNARY,
    obj -> ((Message) obj).toByteArray(), obj -> ((Message) obj).toByteArray(), com.myz.wxapp.api.task.CreateTaskRequest::parseFrom,
    com.myz.wxapp.api.task.CreateTaskReply::parseFrom);

    private static final StubMethodDescriptor createTaskAsyncMethod = new StubMethodDescriptor("createTask",
    com.myz.wxapp.api.task.CreateTaskRequest.class, java.util.concurrent.CompletableFuture.class, serviceDescriptor, MethodDescriptor.RpcType.UNARY,
    obj -> ((Message) obj).toByteArray(), obj -> ((Message) obj).toByteArray(), com.myz.wxapp.api.task.CreateTaskRequest::parseFrom,
    com.myz.wxapp.api.task.CreateTaskReply::parseFrom);

    private static final StubMethodDescriptor createTaskProxyAsyncMethod = new StubMethodDescriptor("createTaskAsync",
    com.myz.wxapp.api.task.CreateTaskRequest.class, com.myz.wxapp.api.task.CreateTaskReply.class, serviceDescriptor, MethodDescriptor.RpcType.UNARY,
    obj -> ((Message) obj).toByteArray(), obj -> ((Message) obj).toByteArray(), com.myz.wxapp.api.task.CreateTaskRequest::parseFrom,
    com.myz.wxapp.api.task.CreateTaskReply::parseFrom);

    private static final StubMethodDescriptor queryTaskMethod = new StubMethodDescriptor("queryTask",
    com.myz.wxapp.api.task.QueryTaskRequest.class, com.myz.wxapp.api.task.QueryTaskResult.class, serviceDescriptor, MethodDescriptor.RpcType.UNARY,
    obj -> ((Message) obj).toByteArray(), obj -> ((Message) obj).toByteArray(), com.myz.wxapp.api.task.QueryTaskRequest::parseFrom,
    com.myz.wxapp.api.task.QueryTaskResult::parseFrom);

    private static final StubMethodDescriptor queryTaskAsyncMethod = new StubMethodDescriptor("queryTask",
    com.myz.wxapp.api.task.QueryTaskRequest.class, java.util.concurrent.CompletableFuture.class, serviceDescriptor, MethodDescriptor.RpcType.UNARY,
    obj -> ((Message) obj).toByteArray(), obj -> ((Message) obj).toByteArray(), com.myz.wxapp.api.task.QueryTaskRequest::parseFrom,
    com.myz.wxapp.api.task.QueryTaskResult::parseFrom);

    private static final StubMethodDescriptor queryTaskProxyAsyncMethod = new StubMethodDescriptor("queryTaskAsync",
    com.myz.wxapp.api.task.QueryTaskRequest.class, com.myz.wxapp.api.task.QueryTaskResult.class, serviceDescriptor, MethodDescriptor.RpcType.UNARY,
    obj -> ((Message) obj).toByteArray(), obj -> ((Message) obj).toByteArray(), com.myz.wxapp.api.task.QueryTaskRequest::parseFrom,
    com.myz.wxapp.api.task.QueryTaskResult::parseFrom);

    private static final StubMethodDescriptor cancelTaskMethod = new StubMethodDescriptor("cancelTask",
    com.myz.wxapp.api.task.CancelTaskRequest.class, com.myz.wxapp.api.task.CancelTaskReply.class, serviceDescriptor, MethodDescriptor.RpcType.UNARY,
    obj -> ((Message) obj).toByteArray(), obj -> ((Message) obj).toByteArray(), com.myz.wxapp.api.task.CancelTaskRequest::parseFrom,
    com.myz.wxapp.api.task.CancelTaskReply::parseFrom);

    private static final StubMethodDescriptor cancelTaskAsyncMethod = new StubMethodDescriptor("cancelTask",
    com.myz.wxapp.api.task.CancelTaskRequest.class, java.util.concurrent.CompletableFuture.class, serviceDescriptor, MethodDescriptor.RpcType.UNARY,
    obj -> ((Message) obj).toByteArray(), obj -> ((Message) obj).toByteArray(), com.myz.wxapp.api.task.CancelTaskRequest::parseFrom,
    com.myz.wxapp.api.task.CancelTaskReply::parseFrom);

    private static final StubMethodDescriptor cancelTaskProxyAsyncMethod = new StubMethodDescriptor("cancelTaskAsync",
    com.myz.wxapp.api.task.CancelTaskRequest.class, com.myz.wxapp.api.task.CancelTaskReply.class, serviceDescriptor, MethodDescriptor.RpcType.UNARY,
    obj -> ((Message) obj).toByteArray(), obj -> ((Message) obj).toByteArray(), com.myz.wxapp.api.task.CancelTaskRequest::parseFrom,
    com.myz.wxapp.api.task.CancelTaskReply::parseFrom);





    public static class TaskServiceStub implements TaskService{
        private final Invoker<TaskService> invoker;

        public TaskServiceStub(Invoker<TaskService> invoker) {
            this.invoker = invoker;
        }

        @Override
        public com.myz.wxapp.api.task.CreateTaskReply createTask(com.myz.wxapp.api.task.CreateTaskRequest request){
            return StubInvocationUtil.unaryCall(invoker, createTaskMethod, request);
        }

        public CompletableFuture<com.myz.wxapp.api.task.CreateTaskReply> createTaskAsync(com.myz.wxapp.api.task.CreateTaskRequest request){
            return StubInvocationUtil.unaryCall(invoker, createTaskAsyncMethod, request);
        }

        @Override
        public void createTask(com.myz.wxapp.api.task.CreateTaskRequest request, StreamObserver<com.myz.wxapp.api.task.CreateTaskReply> responseObserver){
            StubInvocationUtil.unaryCall(invoker, createTaskMethod , request, responseObserver);
        }
        @Override
        public com.myz.wxapp.api.task.QueryTaskResult queryTask(com.myz.wxapp.api.task.QueryTaskRequest request){
            return StubInvocationUtil.unaryCall(invoker, queryTaskMethod, request);
        }

        public CompletableFuture<com.myz.wxapp.api.task.QueryTaskResult> queryTaskAsync(com.myz.wxapp.api.task.QueryTaskRequest request){
            return StubInvocationUtil.unaryCall(invoker, queryTaskAsyncMethod, request);
        }

        @Override
        public void queryTask(com.myz.wxapp.api.task.QueryTaskRequest request, StreamObserver<com.myz.wxapp.api.task.QueryTaskResult> responseObserver){
            StubInvocationUtil.unaryCall(invoker, queryTaskMethod , request, responseObserver);
        }
        @Override
        public com.myz.wxapp.api.task.CancelTaskReply cancelTask(com.myz.wxapp.api.task.CancelTaskRequest request){
            return StubInvocationUtil.unaryCall(invoker, cancelTaskMethod, request);
        }

        public CompletableFuture<com.myz.wxapp.api.task.CancelTaskReply> cancelTaskAsync(com.myz.wxapp.api.task.CancelTaskRequest request){
            return StubInvocationUtil.unaryCall(invoker, cancelTaskAsyncMethod, request);
        }

        @Override
        public void cancelTask(com.myz.wxapp.api.task.CancelTaskRequest request, StreamObserver<com.myz.wxapp.api.task.CancelTaskReply> responseObserver){
            StubInvocationUtil.unaryCall(invoker, cancelTaskMethod , request, responseObserver);
        }



    }

    public static abstract class TaskServiceImplBase implements TaskService, ServerService<TaskService> {

        private <T, R> BiConsumer<T, StreamObserver<R>> syncToAsync(java.util.function.Function<T, R> syncFun) {
            return new BiConsumer<T, StreamObserver<R>>() {
                @Override
                public void accept(T t, StreamObserver<R> observer) {
                    try {
                        R ret = syncFun.apply(t);
                        observer.onNext(ret);
                        observer.onCompleted();
                    } catch (Throwable e) {
                        observer.onError(e);
                    }
                }
            };
        }

        @Override
        public final Invoker<TaskService> getInvoker(URL url) {
            PathResolver pathResolver = url.getOrDefaultFrameworkModel()
            .getExtensionLoader(PathResolver.class)
            .getDefaultExtension();
            Map<String,StubMethodHandler<?, ?>> handlers = new HashMap<>();

            pathResolver.addNativeStub( "/" + SERVICE_NAME + "/createTask" );
            pathResolver.addNativeStub( "/" + SERVICE_NAME + "/createTaskAsync" );
            pathResolver.addNativeStub( "/" + SERVICE_NAME + "/queryTask" );
            pathResolver.addNativeStub( "/" + SERVICE_NAME + "/queryTaskAsync" );
            pathResolver.addNativeStub( "/" + SERVICE_NAME + "/cancelTask" );
            pathResolver.addNativeStub( "/" + SERVICE_NAME + "/cancelTaskAsync" );

            BiConsumer<com.myz.wxapp.api.task.CreateTaskRequest, StreamObserver<com.myz.wxapp.api.task.CreateTaskReply>> createTaskFunc = this::createTask;
            handlers.put(createTaskMethod.getMethodName(), new UnaryStubMethodHandler<>(createTaskFunc));
            BiConsumer<com.myz.wxapp.api.task.CreateTaskRequest, StreamObserver<com.myz.wxapp.api.task.CreateTaskReply>> createTaskAsyncFunc = syncToAsync(this::createTask);
            handlers.put(createTaskProxyAsyncMethod.getMethodName(), new UnaryStubMethodHandler<>(createTaskAsyncFunc));
            BiConsumer<com.myz.wxapp.api.task.QueryTaskRequest, StreamObserver<com.myz.wxapp.api.task.QueryTaskResult>> queryTaskFunc = this::queryTask;
            handlers.put(queryTaskMethod.getMethodName(), new UnaryStubMethodHandler<>(queryTaskFunc));
            BiConsumer<com.myz.wxapp.api.task.QueryTaskRequest, StreamObserver<com.myz.wxapp.api.task.QueryTaskResult>> queryTaskAsyncFunc = syncToAsync(this::queryTask);
            handlers.put(queryTaskProxyAsyncMethod.getMethodName(), new UnaryStubMethodHandler<>(queryTaskAsyncFunc));
            BiConsumer<com.myz.wxapp.api.task.CancelTaskRequest, StreamObserver<com.myz.wxapp.api.task.CancelTaskReply>> cancelTaskFunc = this::cancelTask;
            handlers.put(cancelTaskMethod.getMethodName(), new UnaryStubMethodHandler<>(cancelTaskFunc));
            BiConsumer<com.myz.wxapp.api.task.CancelTaskRequest, StreamObserver<com.myz.wxapp.api.task.CancelTaskReply>> cancelTaskAsyncFunc = syncToAsync(this::cancelTask);
            handlers.put(cancelTaskProxyAsyncMethod.getMethodName(), new UnaryStubMethodHandler<>(cancelTaskAsyncFunc));




            return new StubInvoker<>(this, url, TaskService.class, handlers);
        }


        @Override
        public com.myz.wxapp.api.task.CreateTaskReply createTask(com.myz.wxapp.api.task.CreateTaskRequest request){
            throw unimplementedMethodException(createTaskMethod);
        }

        @Override
        public com.myz.wxapp.api.task.QueryTaskResult queryTask(com.myz.wxapp.api.task.QueryTaskRequest request){
            throw unimplementedMethodException(queryTaskMethod);
        }

        @Override
        public com.myz.wxapp.api.task.CancelTaskReply cancelTask(com.myz.wxapp.api.task.CancelTaskRequest request){
            throw unimplementedMethodException(cancelTaskMethod);
        }





        @Override
        public final ServiceDescriptor getServiceDescriptor() {
            return serviceDescriptor;
        }
        private RpcException unimplementedMethodException(StubMethodDescriptor methodDescriptor) {
            return TriRpcStatus.UNIMPLEMENTED.withDescription(String.format("Method %s is unimplemented",
                "/" + serviceDescriptor.getInterfaceName() + "/" + methodDescriptor.getMethodName())).asException();
        }
    }

}
