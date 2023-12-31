// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: task.proto

package com.myz.wxapp.api.task;

public interface CreateTaskRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:task.CreateTaskRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>int64 userId = 1;</code>
   * @return The userId.
   */
  long getUserId();

  /**
   * <code>string name = 2;</code>
   * @return The name.
   */
  java.lang.String getName();
  /**
   * <code>string name = 2;</code>
   * @return The bytes for name.
   */
  com.google.protobuf.ByteString
      getNameBytes();

  /**
   * <code>string description = 3;</code>
   * @return The description.
   */
  java.lang.String getDescription();
  /**
   * <code>string description = 3;</code>
   * @return The bytes for description.
   */
  com.google.protobuf.ByteString
      getDescriptionBytes();

  /**
   * <code>int32 taskType = 4;</code>
   * @return The taskType.
   */
  int getTaskType();

  /**
   * <code>int32 execType = 5;</code>
   * @return The execType.
   */
  int getExecType();

  /**
   * <code>int32 periodType = 6;</code>
   * @return The periodType.
   */
  int getPeriodType();

  /**
   * <code>int64 fireTime = 7;</code>
   * @return The fireTime.
   */
  long getFireTime();
}
