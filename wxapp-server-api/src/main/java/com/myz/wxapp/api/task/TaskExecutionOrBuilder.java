// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: task.proto

package com.myz.wxapp.api.task;

public interface TaskExecutionOrBuilder extends
    // @@protoc_insertion_point(interface_extends:task.TaskExecution)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>int32 execType = 1;</code>
   * @return The execType.
   */
  int getExecType();

  /**
   * <code>int32 periodType = 2;</code>
   * @return The periodType.
   */
  int getPeriodType();

  /**
   * <code>int64 fireTime = 3;</code>
   * @return The fireTime.
   */
  long getFireTime();

  /**
   * <code>int64 nextFireTime = 4;</code>
   * @return The nextFireTime.
   */
  long getNextFireTime();
}