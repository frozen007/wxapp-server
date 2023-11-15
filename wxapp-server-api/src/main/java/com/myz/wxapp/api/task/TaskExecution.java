// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: task.proto

package com.myz.wxapp.api.task;

/**
 * Protobuf type {@code task.TaskExecution}
 */
public final class TaskExecution extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:task.TaskExecution)
    TaskExecutionOrBuilder {
private static final long serialVersionUID = 0L;
  // Use TaskExecution.newBuilder() to construct.
  private TaskExecution(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private TaskExecution() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new TaskExecution();
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.myz.wxapp.api.task.TaskProto.internal_static_task_TaskExecution_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.myz.wxapp.api.task.TaskProto.internal_static_task_TaskExecution_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.myz.wxapp.api.task.TaskExecution.class, com.myz.wxapp.api.task.TaskExecution.Builder.class);
  }

  public static final int EXECTYPE_FIELD_NUMBER = 1;
  private int execType_ = 0;
  /**
   * <code>int32 execType = 1;</code>
   * @return The execType.
   */
  @java.lang.Override
  public int getExecType() {
    return execType_;
  }

  public static final int PERIODTYPE_FIELD_NUMBER = 2;
  private int periodType_ = 0;
  /**
   * <code>int32 periodType = 2;</code>
   * @return The periodType.
   */
  @java.lang.Override
  public int getPeriodType() {
    return periodType_;
  }

  public static final int FIRETIME_FIELD_NUMBER = 3;
  private long fireTime_ = 0L;
  /**
   * <code>int64 fireTime = 3;</code>
   * @return The fireTime.
   */
  @java.lang.Override
  public long getFireTime() {
    return fireTime_;
  }

  public static final int NEXTFIRETIME_FIELD_NUMBER = 4;
  private long nextFireTime_ = 0L;
  /**
   * <code>int64 nextFireTime = 4;</code>
   * @return The nextFireTime.
   */
  @java.lang.Override
  public long getNextFireTime() {
    return nextFireTime_;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (execType_ != 0) {
      output.writeInt32(1, execType_);
    }
    if (periodType_ != 0) {
      output.writeInt32(2, periodType_);
    }
    if (fireTime_ != 0L) {
      output.writeInt64(3, fireTime_);
    }
    if (nextFireTime_ != 0L) {
      output.writeInt64(4, nextFireTime_);
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (execType_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(1, execType_);
    }
    if (periodType_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(2, periodType_);
    }
    if (fireTime_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(3, fireTime_);
    }
    if (nextFireTime_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(4, nextFireTime_);
    }
    size += getUnknownFields().getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.myz.wxapp.api.task.TaskExecution)) {
      return super.equals(obj);
    }
    com.myz.wxapp.api.task.TaskExecution other = (com.myz.wxapp.api.task.TaskExecution) obj;

    if (getExecType()
        != other.getExecType()) return false;
    if (getPeriodType()
        != other.getPeriodType()) return false;
    if (getFireTime()
        != other.getFireTime()) return false;
    if (getNextFireTime()
        != other.getNextFireTime()) return false;
    if (!getUnknownFields().equals(other.getUnknownFields())) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + EXECTYPE_FIELD_NUMBER;
    hash = (53 * hash) + getExecType();
    hash = (37 * hash) + PERIODTYPE_FIELD_NUMBER;
    hash = (53 * hash) + getPeriodType();
    hash = (37 * hash) + FIRETIME_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getFireTime());
    hash = (37 * hash) + NEXTFIRETIME_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getNextFireTime());
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.myz.wxapp.api.task.TaskExecution parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.myz.wxapp.api.task.TaskExecution parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.myz.wxapp.api.task.TaskExecution parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.myz.wxapp.api.task.TaskExecution parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.myz.wxapp.api.task.TaskExecution parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.myz.wxapp.api.task.TaskExecution parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.myz.wxapp.api.task.TaskExecution parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.myz.wxapp.api.task.TaskExecution parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.myz.wxapp.api.task.TaskExecution parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.myz.wxapp.api.task.TaskExecution parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.myz.wxapp.api.task.TaskExecution parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.myz.wxapp.api.task.TaskExecution parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.myz.wxapp.api.task.TaskExecution prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code task.TaskExecution}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:task.TaskExecution)
      com.myz.wxapp.api.task.TaskExecutionOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.myz.wxapp.api.task.TaskProto.internal_static_task_TaskExecution_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.myz.wxapp.api.task.TaskProto.internal_static_task_TaskExecution_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.myz.wxapp.api.task.TaskExecution.class, com.myz.wxapp.api.task.TaskExecution.Builder.class);
    }

    // Construct using com.myz.wxapp.api.task.TaskExecution.newBuilder()
    private Builder() {

    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);

    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      bitField0_ = 0;
      execType_ = 0;
      periodType_ = 0;
      fireTime_ = 0L;
      nextFireTime_ = 0L;
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.myz.wxapp.api.task.TaskProto.internal_static_task_TaskExecution_descriptor;
    }

    @java.lang.Override
    public com.myz.wxapp.api.task.TaskExecution getDefaultInstanceForType() {
      return com.myz.wxapp.api.task.TaskExecution.getDefaultInstance();
    }

    @java.lang.Override
    public com.myz.wxapp.api.task.TaskExecution build() {
      com.myz.wxapp.api.task.TaskExecution result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.myz.wxapp.api.task.TaskExecution buildPartial() {
      com.myz.wxapp.api.task.TaskExecution result = new com.myz.wxapp.api.task.TaskExecution(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(com.myz.wxapp.api.task.TaskExecution result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.execType_ = execType_;
      }
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.periodType_ = periodType_;
      }
      if (((from_bitField0_ & 0x00000004) != 0)) {
        result.fireTime_ = fireTime_;
      }
      if (((from_bitField0_ & 0x00000008) != 0)) {
        result.nextFireTime_ = nextFireTime_;
      }
    }

    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.myz.wxapp.api.task.TaskExecution) {
        return mergeFrom((com.myz.wxapp.api.task.TaskExecution)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.myz.wxapp.api.task.TaskExecution other) {
      if (other == com.myz.wxapp.api.task.TaskExecution.getDefaultInstance()) return this;
      if (other.getExecType() != 0) {
        setExecType(other.getExecType());
      }
      if (other.getPeriodType() != 0) {
        setPeriodType(other.getPeriodType());
      }
      if (other.getFireTime() != 0L) {
        setFireTime(other.getFireTime());
      }
      if (other.getNextFireTime() != 0L) {
        setNextFireTime(other.getNextFireTime());
      }
      this.mergeUnknownFields(other.getUnknownFields());
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 8: {
              execType_ = input.readInt32();
              bitField0_ |= 0x00000001;
              break;
            } // case 8
            case 16: {
              periodType_ = input.readInt32();
              bitField0_ |= 0x00000002;
              break;
            } // case 16
            case 24: {
              fireTime_ = input.readInt64();
              bitField0_ |= 0x00000004;
              break;
            } // case 24
            case 32: {
              nextFireTime_ = input.readInt64();
              bitField0_ |= 0x00000008;
              break;
            } // case 32
            default: {
              if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                done = true; // was an endgroup tag
              }
              break;
            } // default:
          } // switch (tag)
        } // while (!done)
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.unwrapIOException();
      } finally {
        onChanged();
      } // finally
      return this;
    }
    private int bitField0_;

    private int execType_ ;
    /**
     * <code>int32 execType = 1;</code>
     * @return The execType.
     */
    @java.lang.Override
    public int getExecType() {
      return execType_;
    }
    /**
     * <code>int32 execType = 1;</code>
     * @param value The execType to set.
     * @return This builder for chaining.
     */
    public Builder setExecType(int value) {

      execType_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>int32 execType = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearExecType() {
      bitField0_ = (bitField0_ & ~0x00000001);
      execType_ = 0;
      onChanged();
      return this;
    }

    private int periodType_ ;
    /**
     * <code>int32 periodType = 2;</code>
     * @return The periodType.
     */
    @java.lang.Override
    public int getPeriodType() {
      return periodType_;
    }
    /**
     * <code>int32 periodType = 2;</code>
     * @param value The periodType to set.
     * @return This builder for chaining.
     */
    public Builder setPeriodType(int value) {

      periodType_ = value;
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <code>int32 periodType = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearPeriodType() {
      bitField0_ = (bitField0_ & ~0x00000002);
      periodType_ = 0;
      onChanged();
      return this;
    }

    private long fireTime_ ;
    /**
     * <code>int64 fireTime = 3;</code>
     * @return The fireTime.
     */
    @java.lang.Override
    public long getFireTime() {
      return fireTime_;
    }
    /**
     * <code>int64 fireTime = 3;</code>
     * @param value The fireTime to set.
     * @return This builder for chaining.
     */
    public Builder setFireTime(long value) {

      fireTime_ = value;
      bitField0_ |= 0x00000004;
      onChanged();
      return this;
    }
    /**
     * <code>int64 fireTime = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearFireTime() {
      bitField0_ = (bitField0_ & ~0x00000004);
      fireTime_ = 0L;
      onChanged();
      return this;
    }

    private long nextFireTime_ ;
    /**
     * <code>int64 nextFireTime = 4;</code>
     * @return The nextFireTime.
     */
    @java.lang.Override
    public long getNextFireTime() {
      return nextFireTime_;
    }
    /**
     * <code>int64 nextFireTime = 4;</code>
     * @param value The nextFireTime to set.
     * @return This builder for chaining.
     */
    public Builder setNextFireTime(long value) {

      nextFireTime_ = value;
      bitField0_ |= 0x00000008;
      onChanged();
      return this;
    }
    /**
     * <code>int64 nextFireTime = 4;</code>
     * @return This builder for chaining.
     */
    public Builder clearNextFireTime() {
      bitField0_ = (bitField0_ & ~0x00000008);
      nextFireTime_ = 0L;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:task.TaskExecution)
  }

  // @@protoc_insertion_point(class_scope:task.TaskExecution)
  private static final com.myz.wxapp.api.task.TaskExecution DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.myz.wxapp.api.task.TaskExecution();
  }

  public static com.myz.wxapp.api.task.TaskExecution getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<TaskExecution>
      PARSER = new com.google.protobuf.AbstractParser<TaskExecution>() {
    @java.lang.Override
    public TaskExecution parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      Builder builder = newBuilder();
      try {
        builder.mergeFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(builder.buildPartial());
      } catch (com.google.protobuf.UninitializedMessageException e) {
        throw e.asInvalidProtocolBufferException().setUnfinishedMessage(builder.buildPartial());
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(e)
            .setUnfinishedMessage(builder.buildPartial());
      }
      return builder.buildPartial();
    }
  };

  public static com.google.protobuf.Parser<TaskExecution> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<TaskExecution> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.myz.wxapp.api.task.TaskExecution getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

