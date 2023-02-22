package generated;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.35.0)",
    comments = "Source: general.proto")
public final class serviceLikeGrpc {

  private serviceLikeGrpc() {}

  public static final String SERVICE_NAME = "generated.serviceLike";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<generated.General.ClientPetitionLike,
      generated.General.ServerResponseLike> getGiveResponseLikeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "giveResponseLike",
      requestType = generated.General.ClientPetitionLike.class,
      responseType = generated.General.ServerResponseLike.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<generated.General.ClientPetitionLike,
      generated.General.ServerResponseLike> getGiveResponseLikeMethod() {
    io.grpc.MethodDescriptor<generated.General.ClientPetitionLike, generated.General.ServerResponseLike> getGiveResponseLikeMethod;
    if ((getGiveResponseLikeMethod = serviceLikeGrpc.getGiveResponseLikeMethod) == null) {
      synchronized (serviceLikeGrpc.class) {
        if ((getGiveResponseLikeMethod = serviceLikeGrpc.getGiveResponseLikeMethod) == null) {
          serviceLikeGrpc.getGiveResponseLikeMethod = getGiveResponseLikeMethod =
              io.grpc.MethodDescriptor.<generated.General.ClientPetitionLike, generated.General.ServerResponseLike>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "giveResponseLike"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.General.ClientPetitionLike.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.General.ServerResponseLike.getDefaultInstance()))
              .setSchemaDescriptor(new serviceLikeMethodDescriptorSupplier("giveResponseLike"))
              .build();
        }
      }
    }
    return getGiveResponseLikeMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static serviceLikeStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<serviceLikeStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<serviceLikeStub>() {
        @java.lang.Override
        public serviceLikeStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new serviceLikeStub(channel, callOptions);
        }
      };
    return serviceLikeStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static serviceLikeBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<serviceLikeBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<serviceLikeBlockingStub>() {
        @java.lang.Override
        public serviceLikeBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new serviceLikeBlockingStub(channel, callOptions);
        }
      };
    return serviceLikeBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static serviceLikeFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<serviceLikeFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<serviceLikeFutureStub>() {
        @java.lang.Override
        public serviceLikeFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new serviceLikeFutureStub(channel, callOptions);
        }
      };
    return serviceLikeFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class serviceLikeImplBase implements io.grpc.BindableService {

    /**
     */
    public void giveResponseLike(generated.General.ClientPetitionLike request,
        io.grpc.stub.StreamObserver<generated.General.ServerResponseLike> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGiveResponseLikeMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGiveResponseLikeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                generated.General.ClientPetitionLike,
                generated.General.ServerResponseLike>(
                  this, METHODID_GIVE_RESPONSE_LIKE)))
          .build();
    }
  }

  /**
   */
  public static final class serviceLikeStub extends io.grpc.stub.AbstractAsyncStub<serviceLikeStub> {
    private serviceLikeStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected serviceLikeStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new serviceLikeStub(channel, callOptions);
    }

    /**
     */
    public void giveResponseLike(generated.General.ClientPetitionLike request,
        io.grpc.stub.StreamObserver<generated.General.ServerResponseLike> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGiveResponseLikeMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class serviceLikeBlockingStub extends io.grpc.stub.AbstractBlockingStub<serviceLikeBlockingStub> {
    private serviceLikeBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected serviceLikeBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new serviceLikeBlockingStub(channel, callOptions);
    }

    /**
     */
    public generated.General.ServerResponseLike giveResponseLike(generated.General.ClientPetitionLike request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGiveResponseLikeMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class serviceLikeFutureStub extends io.grpc.stub.AbstractFutureStub<serviceLikeFutureStub> {
    private serviceLikeFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected serviceLikeFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new serviceLikeFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<generated.General.ServerResponseLike> giveResponseLike(
        generated.General.ClientPetitionLike request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGiveResponseLikeMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GIVE_RESPONSE_LIKE = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final serviceLikeImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(serviceLikeImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GIVE_RESPONSE_LIKE:
          serviceImpl.giveResponseLike((generated.General.ClientPetitionLike) request,
              (io.grpc.stub.StreamObserver<generated.General.ServerResponseLike>) responseObserver);
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

  private static abstract class serviceLikeBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    serviceLikeBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return generated.General.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("serviceLike");
    }
  }

  private static final class serviceLikeFileDescriptorSupplier
      extends serviceLikeBaseDescriptorSupplier {
    serviceLikeFileDescriptorSupplier() {}
  }

  private static final class serviceLikeMethodDescriptorSupplier
      extends serviceLikeBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    serviceLikeMethodDescriptorSupplier(String methodName) {
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
      synchronized (serviceLikeGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new serviceLikeFileDescriptorSupplier())
              .addMethod(getGiveResponseLikeMethod())
              .build();
        }
      }
    }
    return result;
  }
}
