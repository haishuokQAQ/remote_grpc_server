package com.ulyssesk.remote_grpc.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 * <pre>
 *声明grpc服务
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.29.0)",
    comments = "Source: danmu.proto")
public final class DanmuConsumerGrpc {

  private DanmuConsumerGrpc() {}

  public static final String SERVICE_NAME = "com.ulyssesk.remote_grpc.grpc.DanmuConsumer";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.ulyssesk.remote_grpc.grpc.Danmu.DanmuRequest,
      com.ulyssesk.remote_grpc.grpc.Danmu.DanmuResponse> getSetDanmuMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SetDanmu",
      requestType = com.ulyssesk.remote_grpc.grpc.Danmu.DanmuRequest.class,
      responseType = com.ulyssesk.remote_grpc.grpc.Danmu.DanmuResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.ulyssesk.remote_grpc.grpc.Danmu.DanmuRequest,
      com.ulyssesk.remote_grpc.grpc.Danmu.DanmuResponse> getSetDanmuMethod() {
    io.grpc.MethodDescriptor<com.ulyssesk.remote_grpc.grpc.Danmu.DanmuRequest, com.ulyssesk.remote_grpc.grpc.Danmu.DanmuResponse> getSetDanmuMethod;
    if ((getSetDanmuMethod = DanmuConsumerGrpc.getSetDanmuMethod) == null) {
      synchronized (DanmuConsumerGrpc.class) {
        if ((getSetDanmuMethod = DanmuConsumerGrpc.getSetDanmuMethod) == null) {
          DanmuConsumerGrpc.getSetDanmuMethod = getSetDanmuMethod =
              io.grpc.MethodDescriptor.<com.ulyssesk.remote_grpc.grpc.Danmu.DanmuRequest, com.ulyssesk.remote_grpc.grpc.Danmu.DanmuResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SetDanmu"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ulyssesk.remote_grpc.grpc.Danmu.DanmuRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ulyssesk.remote_grpc.grpc.Danmu.DanmuResponse.getDefaultInstance()))
              .setSchemaDescriptor(new DanmuConsumerMethodDescriptorSupplier("SetDanmu"))
              .build();
        }
      }
    }
    return getSetDanmuMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static DanmuConsumerStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DanmuConsumerStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DanmuConsumerStub>() {
        @java.lang.Override
        public DanmuConsumerStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DanmuConsumerStub(channel, callOptions);
        }
      };
    return DanmuConsumerStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DanmuConsumerBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DanmuConsumerBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DanmuConsumerBlockingStub>() {
        @java.lang.Override
        public DanmuConsumerBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DanmuConsumerBlockingStub(channel, callOptions);
        }
      };
    return DanmuConsumerBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static DanmuConsumerFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DanmuConsumerFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DanmuConsumerFutureStub>() {
        @java.lang.Override
        public DanmuConsumerFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DanmuConsumerFutureStub(channel, callOptions);
        }
      };
    return DanmuConsumerFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   *声明grpc服务
   * </pre>
   */
  public static abstract class DanmuConsumerImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     *以下 分别是 服务端 推送流， 客户端 推送流 ，双向流。
     * </pre>
     */
    public void setDanmu(com.ulyssesk.remote_grpc.grpc.Danmu.DanmuRequest request,
        io.grpc.stub.StreamObserver<com.ulyssesk.remote_grpc.grpc.Danmu.DanmuResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSetDanmuMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSetDanmuMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                com.ulyssesk.remote_grpc.grpc.Danmu.DanmuRequest,
                com.ulyssesk.remote_grpc.grpc.Danmu.DanmuResponse>(
                  this, METHODID_SET_DANMU)))
          .build();
    }
  }

  /**
   * <pre>
   *声明grpc服务
   * </pre>
   */
  public static final class DanmuConsumerStub extends io.grpc.stub.AbstractAsyncStub<DanmuConsumerStub> {
    private DanmuConsumerStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DanmuConsumerStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DanmuConsumerStub(channel, callOptions);
    }

    /**
     * <pre>
     *以下 分别是 服务端 推送流， 客户端 推送流 ，双向流。
     * </pre>
     */
    public void setDanmu(com.ulyssesk.remote_grpc.grpc.Danmu.DanmuRequest request,
        io.grpc.stub.StreamObserver<com.ulyssesk.remote_grpc.grpc.Danmu.DanmuResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getSetDanmuMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   *声明grpc服务
   * </pre>
   */
  public static final class DanmuConsumerBlockingStub extends io.grpc.stub.AbstractBlockingStub<DanmuConsumerBlockingStub> {
    private DanmuConsumerBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DanmuConsumerBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DanmuConsumerBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     *以下 分别是 服务端 推送流， 客户端 推送流 ，双向流。
     * </pre>
     */
    public java.util.Iterator<com.ulyssesk.remote_grpc.grpc.Danmu.DanmuResponse> setDanmu(
        com.ulyssesk.remote_grpc.grpc.Danmu.DanmuRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getSetDanmuMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   *声明grpc服务
   * </pre>
   */
  public static final class DanmuConsumerFutureStub extends io.grpc.stub.AbstractFutureStub<DanmuConsumerFutureStub> {
    private DanmuConsumerFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DanmuConsumerFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DanmuConsumerFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_SET_DANMU = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final DanmuConsumerImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(DanmuConsumerImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SET_DANMU:
          serviceImpl.setDanmu((com.ulyssesk.remote_grpc.grpc.Danmu.DanmuRequest) request,
              (io.grpc.stub.StreamObserver<com.ulyssesk.remote_grpc.grpc.Danmu.DanmuResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class DanmuConsumerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DanmuConsumerBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.ulyssesk.remote_grpc.grpc.Danmu.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("DanmuConsumer");
    }
  }

  private static final class DanmuConsumerFileDescriptorSupplier
      extends DanmuConsumerBaseDescriptorSupplier {
    DanmuConsumerFileDescriptorSupplier() {}
  }

  private static final class DanmuConsumerMethodDescriptorSupplier
      extends DanmuConsumerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    DanmuConsumerMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (DanmuConsumerGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new DanmuConsumerFileDescriptorSupplier())
              .addMethod(getSetDanmuMethod())
              .build();
        }
      }
    }
    return result;
  }
}
