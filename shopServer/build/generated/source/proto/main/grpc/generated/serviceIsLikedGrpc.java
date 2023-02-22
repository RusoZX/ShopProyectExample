package generated;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.35.0)",
    comments = "Source: general.proto")
public final class serviceIsLikedGrpc {

  private serviceIsLikedGrpc() {}

  public static final String SERVICE_NAME = "generated.serviceIsLiked";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<generated.General.ClientPetitionIsLiked,
      generated.General.ServerResponseIsLiked> getGiveResponseIsLikedMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "giveResponseIsLiked",
      requestType = generated.General.ClientPetitionIsLiked.class,
      responseType = generated.General.ServerResponseIsLiked.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<generated.General.ClientPetitionIsLiked,
      generated.General.ServerResponseIsLiked> getGiveResponseIsLikedMethod() {
    io.grpc.MethodDescriptor<generated.General.ClientPetitionIsLiked, generated.General.ServerResponseIsLiked> getGiveResponseIsLikedMethod;
    if ((getGiveResponseIsLikedMethod = serviceIsLikedGrpc.getGiveResponseIsLikedMethod) == null) {
      synchronized (serviceIsLikedGrpc.class) {
        if ((getGiveResponseIsLikedMethod = serviceIsLikedGrpc.getGiveResponseIsLikedMethod) == null) {
          serviceIsLikedGrpc.getGiveResponseIsLikedMethod = getGiveResponseIsLikedMethod =
              io.grpc.MethodDescriptor.<generated.General.ClientPetitionIsLiked, generated.General.ServerResponseIsLiked>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "giveResponseIsLiked"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.General.ClientPetitionIsLiked.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.General.ServerResponseIsLiked.getDefaultInstance()))
              .setSchemaDescriptor(new serviceIsLikedMethodDescriptorSupplier("giveResponseIsLiked"))
              .build();
        }
      }
    }
    return getGiveResponseIsLikedMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static serviceIsLikedStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<serviceIsLikedStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<serviceIsLikedStub>() {
        @java.lang.Override
        public serviceIsLikedStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new serviceIsLikedStub(channel, callOptions);
        }
      };
    return serviceIsLikedStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static serviceIsLikedBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<serviceIsLikedBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<serviceIsLikedBlockingStub>() {
        @java.lang.Override
        public serviceIsLikedBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new serviceIsLikedBlockingStub(channel, callOptions);
        }
      };
    return serviceIsLikedBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static serviceIsLikedFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<serviceIsLikedFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<serviceIsLikedFutureStub>() {
        @java.lang.Override
        public serviceIsLikedFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new serviceIsLikedFutureStub(channel, callOptions);
        }
      };
    return serviceIsLikedFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class serviceIsLikedImplBase implements io.grpc.BindableService {

    /**
     */
    public void giveResponseIsLiked(generated.General.ClientPetitionIsLiked request,
        io.grpc.stub.StreamObserver<generated.General.ServerResponseIsLiked> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGiveResponseIsLikedMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGiveResponseIsLikedMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                generated.General.ClientPetitionIsLiked,
                generated.General.ServerResponseIsLiked>(
                  this, METHODID_GIVE_RESPONSE_IS_LIKED)))
          .build();
    }
  }

  /**
   */
  public static final class serviceIsLikedStub extends io.grpc.stub.AbstractAsyncStub<serviceIsLikedStub> {
    private serviceIsLikedStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected serviceIsLikedStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new serviceIsLikedStub(channel, callOptions);
    }

    /**
     */
    public void giveResponseIsLiked(generated.General.ClientPetitionIsLiked request,
        io.grpc.stub.StreamObserver<generated.General.ServerResponseIsLiked> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGiveResponseIsLikedMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class serviceIsLikedBlockingStub extends io.grpc.stub.AbstractBlockingStub<serviceIsLikedBlockingStub> {
    private serviceIsLikedBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected serviceIsLikedBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new serviceIsLikedBlockingStub(channel, callOptions);
    }

    /**
     */
    public generated.General.ServerResponseIsLiked giveResponseIsLiked(generated.General.ClientPetitionIsLiked request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGiveResponseIsLikedMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class serviceIsLikedFutureStub extends io.grpc.stub.AbstractFutureStub<serviceIsLikedFutureStub> {
    private serviceIsLikedFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected serviceIsLikedFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new serviceIsLikedFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<generated.General.ServerResponseIsLiked> giveResponseIsLiked(
        generated.General.ClientPetitionIsLiked request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGiveResponseIsLikedMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GIVE_RESPONSE_IS_LIKED = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final serviceIsLikedImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(serviceIsLikedImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GIVE_RESPONSE_IS_LIKED:
          serviceImpl.giveResponseIsLiked((generated.General.ClientPetitionIsLiked) request,
              (io.grpc.stub.StreamObserver<generated.General.ServerResponseIsLiked>) responseObserver);
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

  private static abstract class serviceIsLikedBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    serviceIsLikedBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return generated.General.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("serviceIsLiked");
    }
  }

  private static final class serviceIsLikedFileDescriptorSupplier
      extends serviceIsLikedBaseDescriptorSupplier {
    serviceIsLikedFileDescriptorSupplier() {}
  }

  private static final class serviceIsLikedMethodDescriptorSupplier
      extends serviceIsLikedBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    serviceIsLikedMethodDescriptorSupplier(String methodName) {
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
      synchronized (serviceIsLikedGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new serviceIsLikedFileDescriptorSupplier())
              .addMethod(getGiveResponseIsLikedMethod())
              .build();
        }
      }
    }
    return result;
  }
}
