// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: task.proto

package com.myz.wxapp.api.task;

public interface CancelTaskReplyOrBuilder extends
    // @@protoc_insertion_point(interface_extends:task.CancelTaskReply)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>int64 userId = 1;</code>
   * @return The userId.
   */
  long getUserId();

  /**
   * <code>int64 taskId = 2;</code>
   * @return The taskId.
   */
  long getTaskId();

  /**
   * <code>int32 status = 3;</code>
   * @return The status.
   */
  int getStatus();
}
