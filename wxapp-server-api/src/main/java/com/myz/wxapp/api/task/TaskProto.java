// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: task.proto

package com.myz.wxapp.api.task;

public final class TaskProto {
  private TaskProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_task_CreateTaskRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_task_CreateTaskRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_task_CreateTaskReply_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_task_CreateTaskReply_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_task_QueryTaskRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_task_QueryTaskRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_task_QueryTaskResult_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_task_QueryTaskResult_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_task_UserTask_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_task_UserTask_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_task_TaskExecution_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_task_TaskExecution_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\ntask.proto\022\004task\"\220\001\n\021CreateTaskRequest" +
      "\022\016\n\006userId\030\001 \001(\003\022\014\n\004name\030\002 \001(\t\022\023\n\013descri" +
      "ption\030\003 \001(\t\022\020\n\010taskType\030\004 \001(\005\022\020\n\010execTyp" +
      "e\030\005 \001(\005\022\022\n\nperiodType\030\006 \001(\005\022\020\n\010fireTime\030" +
      "\007 \001(\003\"!\n\017CreateTaskReply\022\016\n\006taskId\030\001 \001(\003" +
      "\"2\n\020QueryTaskRequest\022\016\n\006userId\030\001 \001(\003\022\016\n\006" +
      "status\030\002 \001(\005\"@\n\017QueryTaskResult\022\016\n\006lengt" +
      "h\030\001 \001(\005\022\035\n\005tasks\030\002 \003(\0132\016.task.UserTask\"\247" +
      "\001\n\010UserTask\022\n\n\002id\030\001 \001(\003\022\016\n\006userId\030\002 \001(\003\022" +
      "\014\n\004name\030\003 \001(\t\022\023\n\013description\030\004 \001(\t\022\016\n\006st" +
      "atus\030\005 \001(\005\022\020\n\010taskType\030\006 \001(\005\022\022\n\ncreateTi" +
      "me\030\007 \001(\003\022&\n\texecution\030\010 \001(\0132\023.task.TaskE" +
      "xecution\"]\n\rTaskExecution\022\020\n\010execType\030\001 " +
      "\001(\005\022\022\n\nperiodType\030\002 \001(\005\022\020\n\010fireTime\030\003 \001(" +
      "\003\022\024\n\014nextFireTime\030\004 \001(\0032\207\001\n\013TaskService\022" +
      "<\n\ncreateTask\022\027.task.CreateTaskRequest\032\025" +
      ".task.CreateTaskReply\022:\n\tqueryTask\022\026.tas" +
      "k.QueryTaskRequest\032\025.task.QueryTaskResul" +
      "tB+\n\026com.myz.wxapp.api.taskB\tTaskProtoP\001" +
      "\242\002\003HLWb\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_task_CreateTaskRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_task_CreateTaskRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_task_CreateTaskRequest_descriptor,
        new java.lang.String[] { "UserId", "Name", "Description", "TaskType", "ExecType", "PeriodType", "FireTime", });
    internal_static_task_CreateTaskReply_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_task_CreateTaskReply_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_task_CreateTaskReply_descriptor,
        new java.lang.String[] { "TaskId", });
    internal_static_task_QueryTaskRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_task_QueryTaskRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_task_QueryTaskRequest_descriptor,
        new java.lang.String[] { "UserId", "Status", });
    internal_static_task_QueryTaskResult_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_task_QueryTaskResult_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_task_QueryTaskResult_descriptor,
        new java.lang.String[] { "Length", "Tasks", });
    internal_static_task_UserTask_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_task_UserTask_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_task_UserTask_descriptor,
        new java.lang.String[] { "Id", "UserId", "Name", "Description", "Status", "TaskType", "CreateTime", "Execution", });
    internal_static_task_TaskExecution_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_task_TaskExecution_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_task_TaskExecution_descriptor,
        new java.lang.String[] { "ExecType", "PeriodType", "FireTime", "NextFireTime", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}