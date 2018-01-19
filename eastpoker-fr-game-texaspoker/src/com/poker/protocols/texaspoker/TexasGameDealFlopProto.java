// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: src/com/poker/protocols/texaspoker/proto/TexasGameDealFlop.proto

package com.poker.protocols.texaspoker;

public final class TexasGameDealFlopProto {
  private TexasGameDealFlopProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface TexasGameDealFlopOrBuilder extends
      // @@protoc_insertion_point(interface_extends:com.poker.protocols.texaspoker.proto.TexasGameDealFlop)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>repeated int32 cards = 2;</code>
     */
    java.util.List<java.lang.Integer> getCardsList();
    /**
     * <code>repeated int32 cards = 2;</code>
     */
    int getCardsCount();
    /**
     * <code>repeated int32 cards = 2;</code>
     */
    int getCards(int index);
  }
  /**
   * Protobuf type {@code com.poker.protocols.texaspoker.proto.TexasGameDealFlop}
   */
  public  static final class TexasGameDealFlop extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:com.poker.protocols.texaspoker.proto.TexasGameDealFlop)
      TexasGameDealFlopOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use TexasGameDealFlop.newBuilder() to construct.
    private TexasGameDealFlop(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private TexasGameDealFlop() {
      cards_ = java.util.Collections.emptyList();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private TexasGameDealFlop(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      int mutable_bitField0_ = 0;
      com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder();
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!parseUnknownFieldProto3(
                  input, unknownFields, extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
            case 16: {
              if (!((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
                cards_ = new java.util.ArrayList<java.lang.Integer>();
                mutable_bitField0_ |= 0x00000001;
              }
              cards_.add(input.readInt32());
              break;
            }
            case 18: {
              int length = input.readRawVarint32();
              int limit = input.pushLimit(length);
              if (!((mutable_bitField0_ & 0x00000001) == 0x00000001) && input.getBytesUntilLimit() > 0) {
                cards_ = new java.util.ArrayList<java.lang.Integer>();
                mutable_bitField0_ |= 0x00000001;
              }
              while (input.getBytesUntilLimit() > 0) {
                cards_.add(input.readInt32());
              }
              input.popLimit(limit);
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e).setUnfinishedMessage(this);
      } finally {
        if (((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
          cards_ = java.util.Collections.unmodifiableList(cards_);
        }
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.poker.protocols.texaspoker.TexasGameDealFlopProto.internal_static_com_poker_protocols_texaspoker_proto_TexasGameDealFlop_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.poker.protocols.texaspoker.TexasGameDealFlopProto.internal_static_com_poker_protocols_texaspoker_proto_TexasGameDealFlop_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.poker.protocols.texaspoker.TexasGameDealFlopProto.TexasGameDealFlop.class, com.poker.protocols.texaspoker.TexasGameDealFlopProto.TexasGameDealFlop.Builder.class);
    }

    public static final int CARDS_FIELD_NUMBER = 2;
    private java.util.List<java.lang.Integer> cards_;
    /**
     * <code>repeated int32 cards = 2;</code>
     */
    public java.util.List<java.lang.Integer>
        getCardsList() {
      return cards_;
    }
    /**
     * <code>repeated int32 cards = 2;</code>
     */
    public int getCardsCount() {
      return cards_.size();
    }
    /**
     * <code>repeated int32 cards = 2;</code>
     */
    public int getCards(int index) {
      return cards_.get(index);
    }
    private int cardsMemoizedSerializedSize = -1;

    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      getSerializedSize();
      if (getCardsList().size() > 0) {
        output.writeUInt32NoTag(18);
        output.writeUInt32NoTag(cardsMemoizedSerializedSize);
      }
      for (int i = 0; i < cards_.size(); i++) {
        output.writeInt32NoTag(cards_.get(i));
      }
      unknownFields.writeTo(output);
    }

    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      {
        int dataSize = 0;
        for (int i = 0; i < cards_.size(); i++) {
          dataSize += com.google.protobuf.CodedOutputStream
            .computeInt32SizeNoTag(cards_.get(i));
        }
        size += dataSize;
        if (!getCardsList().isEmpty()) {
          size += 1;
          size += com.google.protobuf.CodedOutputStream
              .computeInt32SizeNoTag(dataSize);
        }
        cardsMemoizedSerializedSize = dataSize;
      }
      size += unknownFields.getSerializedSize();
      memoizedSize = size;
      return size;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof com.poker.protocols.texaspoker.TexasGameDealFlopProto.TexasGameDealFlop)) {
        return super.equals(obj);
      }
      com.poker.protocols.texaspoker.TexasGameDealFlopProto.TexasGameDealFlop other = (com.poker.protocols.texaspoker.TexasGameDealFlopProto.TexasGameDealFlop) obj;

      boolean result = true;
      result = result && getCardsList()
          .equals(other.getCardsList());
      result = result && unknownFields.equals(other.unknownFields);
      return result;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptor().hashCode();
      if (getCardsCount() > 0) {
        hash = (37 * hash) + CARDS_FIELD_NUMBER;
        hash = (53 * hash) + getCardsList().hashCode();
      }
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.poker.protocols.texaspoker.TexasGameDealFlopProto.TexasGameDealFlop parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.poker.protocols.texaspoker.TexasGameDealFlopProto.TexasGameDealFlop parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.poker.protocols.texaspoker.TexasGameDealFlopProto.TexasGameDealFlop parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.poker.protocols.texaspoker.TexasGameDealFlopProto.TexasGameDealFlop parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.poker.protocols.texaspoker.TexasGameDealFlopProto.TexasGameDealFlop parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    //-----------------------------------------------------
    public static com.poker.protocols.texaspoker.TexasGameDealFlopProto.TexasGameDealFlop parseFrom(byte[] data,int offset ,int length)
            throws com.google.protobuf.InvalidProtocolBufferException {
          return PARSER.parseFrom(data,offset,length);
        }
    //-----------------------------------------------------
    public static com.poker.protocols.texaspoker.TexasGameDealFlopProto.TexasGameDealFlop parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
  //-----------------------------------------------------
    public static com.poker.protocols.texaspoker.TexasGameDealFlopProto.TexasGameDealFlop parseFrom(
    		byte[] data,int offset ,int length,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
          return PARSER.parseFrom(data,offset,length, extensionRegistry);
        }
   //-----------------------------------------------------
    public static com.poker.protocols.texaspoker.TexasGameDealFlopProto.TexasGameDealFlop parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static com.poker.protocols.texaspoker.TexasGameDealFlopProto.TexasGameDealFlop parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static com.poker.protocols.texaspoker.TexasGameDealFlopProto.TexasGameDealFlop parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static com.poker.protocols.texaspoker.TexasGameDealFlopProto.TexasGameDealFlop parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static com.poker.protocols.texaspoker.TexasGameDealFlopProto.TexasGameDealFlop parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static com.poker.protocols.texaspoker.TexasGameDealFlopProto.TexasGameDealFlop parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(com.poker.protocols.texaspoker.TexasGameDealFlopProto.TexasGameDealFlop prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
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
     * Protobuf type {@code com.poker.protocols.texaspoker.proto.TexasGameDealFlop}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:com.poker.protocols.texaspoker.proto.TexasGameDealFlop)
        com.poker.protocols.texaspoker.TexasGameDealFlopProto.TexasGameDealFlopOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return com.poker.protocols.texaspoker.TexasGameDealFlopProto.internal_static_com_poker_protocols_texaspoker_proto_TexasGameDealFlop_descriptor;
      }

      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.poker.protocols.texaspoker.TexasGameDealFlopProto.internal_static_com_poker_protocols_texaspoker_proto_TexasGameDealFlop_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.poker.protocols.texaspoker.TexasGameDealFlopProto.TexasGameDealFlop.class, com.poker.protocols.texaspoker.TexasGameDealFlopProto.TexasGameDealFlop.Builder.class);
      }

      // Construct using com.poker.protocols.texaspoker.TexasGameDealFlopProto.TexasGameDealFlop.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3
                .alwaysUseFieldBuilders) {
        }
      }
      public Builder clear() {
        super.clear();
        cards_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return com.poker.protocols.texaspoker.TexasGameDealFlopProto.internal_static_com_poker_protocols_texaspoker_proto_TexasGameDealFlop_descriptor;
      }

      public com.poker.protocols.texaspoker.TexasGameDealFlopProto.TexasGameDealFlop getDefaultInstanceForType() {
        return com.poker.protocols.texaspoker.TexasGameDealFlopProto.TexasGameDealFlop.getDefaultInstance();
      }

      public com.poker.protocols.texaspoker.TexasGameDealFlopProto.TexasGameDealFlop build() {
        com.poker.protocols.texaspoker.TexasGameDealFlopProto.TexasGameDealFlop result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public com.poker.protocols.texaspoker.TexasGameDealFlopProto.TexasGameDealFlop buildPartial() {
        com.poker.protocols.texaspoker.TexasGameDealFlopProto.TexasGameDealFlop result = new com.poker.protocols.texaspoker.TexasGameDealFlopProto.TexasGameDealFlop(this);
        int from_bitField0_ = bitField0_;
        if (((bitField0_ & 0x00000001) == 0x00000001)) {
          cards_ = java.util.Collections.unmodifiableList(cards_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.cards_ = cards_;
        onBuilt();
        return result;
      }

      public Builder clone() {
        return (Builder) super.clone();
      }
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return (Builder) super.setField(field, value);
      }
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return (Builder) super.clearField(field);
      }
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return (Builder) super.clearOneof(oneof);
      }
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, java.lang.Object value) {
        return (Builder) super.setRepeatedField(field, index, value);
      }
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return (Builder) super.addRepeatedField(field, value);
      }
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof com.poker.protocols.texaspoker.TexasGameDealFlopProto.TexasGameDealFlop) {
          return mergeFrom((com.poker.protocols.texaspoker.TexasGameDealFlopProto.TexasGameDealFlop)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.poker.protocols.texaspoker.TexasGameDealFlopProto.TexasGameDealFlop other) {
        if (other == com.poker.protocols.texaspoker.TexasGameDealFlopProto.TexasGameDealFlop.getDefaultInstance()) return this;
        if (!other.cards_.isEmpty()) {
          if (cards_.isEmpty()) {
            cards_ = other.cards_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureCardsIsMutable();
            cards_.addAll(other.cards_);
          }
          onChanged();
        }
        this.mergeUnknownFields(other.unknownFields);
        onChanged();
        return this;
      }

      public final boolean isInitialized() {
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        com.poker.protocols.texaspoker.TexasGameDealFlopProto.TexasGameDealFlop parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (com.poker.protocols.texaspoker.TexasGameDealFlopProto.TexasGameDealFlop) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      private java.util.List<java.lang.Integer> cards_ = java.util.Collections.emptyList();
      private void ensureCardsIsMutable() {
        if (!((bitField0_ & 0x00000001) == 0x00000001)) {
          cards_ = new java.util.ArrayList<java.lang.Integer>(cards_);
          bitField0_ |= 0x00000001;
         }
      }
      /**
       * <code>repeated int32 cards = 2;</code>
       */
      public java.util.List<java.lang.Integer>
          getCardsList() {
        return java.util.Collections.unmodifiableList(cards_);
      }
      /**
       * <code>repeated int32 cards = 2;</code>
       */
      public int getCardsCount() {
        return cards_.size();
      }
      /**
       * <code>repeated int32 cards = 2;</code>
       */
      public int getCards(int index) {
        return cards_.get(index);
      }
      /**
       * <code>repeated int32 cards = 2;</code>
       */
      public Builder setCards(
          int index, int value) {
        ensureCardsIsMutable();
        cards_.set(index, value);
        onChanged();
        return this;
      }
      /**
       * <code>repeated int32 cards = 2;</code>
       */
      public Builder addCards(int value) {
        ensureCardsIsMutable();
        cards_.add(value);
        onChanged();
        return this;
      }
      /**
       * <code>repeated int32 cards = 2;</code>
       */
      public Builder addAllCards(
          java.lang.Iterable<? extends java.lang.Integer> values) {
        ensureCardsIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, cards_);
        onChanged();
        return this;
      }
      /**
       * <code>repeated int32 cards = 2;</code>
       */
      public Builder clearCards() {
        cards_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
        return this;
      }
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.setUnknownFieldsProto3(unknownFields);
      }

      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.mergeUnknownFields(unknownFields);
      }


      // @@protoc_insertion_point(builder_scope:com.poker.protocols.texaspoker.proto.TexasGameDealFlop)
    }

    // @@protoc_insertion_point(class_scope:com.poker.protocols.texaspoker.proto.TexasGameDealFlop)
    private static final com.poker.protocols.texaspoker.TexasGameDealFlopProto.TexasGameDealFlop DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new com.poker.protocols.texaspoker.TexasGameDealFlopProto.TexasGameDealFlop();
    }

    public static com.poker.protocols.texaspoker.TexasGameDealFlopProto.TexasGameDealFlop getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<TexasGameDealFlop>
        PARSER = new com.google.protobuf.AbstractParser<TexasGameDealFlop>() {
      public TexasGameDealFlop parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new TexasGameDealFlop(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<TexasGameDealFlop> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<TexasGameDealFlop> getParserForType() {
      return PARSER;
    }

    public com.poker.protocols.texaspoker.TexasGameDealFlopProto.TexasGameDealFlop getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_poker_protocols_texaspoker_proto_TexasGameDealFlop_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_poker_protocols_texaspoker_proto_TexasGameDealFlop_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n@src/com/poker/protocols/texaspoker/pro" +
      "to/TexasGameDealFlop.proto\022$com.poker.pr" +
      "otocols.texaspoker.proto\"\"\n\021TexasGameDea" +
      "lFlop\022\r\n\005cards\030\002 \003(\005B8\n\036com.poker.protoc" +
      "ols.texaspokerB\026TexasGameDealFlopProtob\006" +
      "proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_com_poker_protocols_texaspoker_proto_TexasGameDealFlop_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_com_poker_protocols_texaspoker_proto_TexasGameDealFlop_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_poker_protocols_texaspoker_proto_TexasGameDealFlop_descriptor,
        new java.lang.String[] { "Cards", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}