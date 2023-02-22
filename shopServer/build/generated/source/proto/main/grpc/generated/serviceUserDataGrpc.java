package generated;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.35.0)",
    comments = "Source: general.proto")
public final class serviceUserDataGrpc {

  private serviceUserDataGrpc() {}

  public static final String SERVICE_NAME = "generated.serviceUserData";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<generated.General.ClientPetitionUserData,
      generated.General.ServerResponseUserData> getGiveResponseUserDataMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "giveResponseUserData",
      requestType = generated.General.ClientPetitionUserData.class,
      responseType = generated.General.ServerResponseUserData.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<generated.General.ClientPetitionUserData,
      generated.General.ServerResponseUserData> getGiveResponseUserDataMethod() {
    io.grpc.MethodDescriptor<generated.General.ClientPetitionUserData, generated.General.ServerResponseUserData> getGiveResponseUserDataMethod;
    if ((getGiveResponseUserDataMethod = serviceUserDataGrpc.getGiveResponseUserDataMethod) == null) {
      synchronized (serviceUserDataGrpc.class) {
        if ((getGiveResponseUserDataMethod = serviceUserDataGrpc.getGiveResponseUserDataMethod) == null) {
          serviceUserDataGrpc.getGiveResponseUserDataMethod = getGiveResponseUserDataMethod =
              io.grpc.MethodDescriptor.<generated.General.ClientPetitionUserData, generated.General.ServerResponseUserData>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "giveResponseUserData"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.General.ClientPetitionUserData.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.General.ServerResponseUserData.getDefaultInstance()))
              .setSchemaDescriptor(new serviceUserDataMethodDescriptorSupplier("giveResponseUserData"))
              .build();
        }
      }
    }
    return getGiveResponseUserDataMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static serviceUserDataStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<serviceUserDataStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<serviceUserDataStub>() {
        @java.lang.Override
        public serviceUserDataStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new serviceUserDataStub(channel, callOptions);
        }
      };
    return serviceUserDataStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static serviceUserDataBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<serviceUserDataBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<serviceUserDataBlockingStub>() {
        @java.lang.Override
        public serviceUserDataBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new serviceUserDataBlockingStub(channel, callOptions);
        }
      };
    return serviceUserDataBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static serviceUserDataFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<serviceUserDataFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<serviceUserDataFutureStub>() {
        @java.lang.Override
        public serviceUserDataFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new serviceUserDataFutureStub(channel, callOptions);
        }
      };
    return serviceUserDataFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class serviceUserDataImplBase implements io.grpc.BindableService {

    /**
     */
    public void giveResponseUserData(generated.General.ClientPetitionUserData request,
        io.grpc.stub.StreamObserver<generated.General.ServerResponseUserData> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGiveResponseUserDataMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGiveResponseUserDataMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                generated.General.ClientPetitionUserData,
                generated.General.ServerResponseUserData>(
                  this, METHODID_GIVE_RESPONSE_USER_DATA)))
          .build();
    }
  }

  /**
   */
  public static final class serviceUserDataStub extends io.grpc.stub.AbstractAsyncStub<serviceUserDataStub> {
    private serviceUserDataStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected serviceUserDataStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new serviceUserDataStub(channel, callOptions);
    }

    /**
     */
    public void giveResponseUserData(generated.General.ClientPetitionUserData request,
        io.grpc.stub.StreamObserver<generated.General.ServerResponseUserData> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGiveResponseUserDataMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class serviceUserDataBlockingStub extends io.grpc.stub.AbstractBlockingStub<serviceUserDataBlockingStub> {
    private serviceUserDataBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected serviceUserDataBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new serviceUserDataBlockingStub(channel, callOptions);
    }

    /**
     */
    public generated.General.ServerResponseUserData giveResponseUserData(generated.General.ClientPetitionUserData request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGiveResponseUserDataMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class serviceUserDataFutureStub extends io.grpc.stub.AbstractFutureStub<serviceUserDataFutureStub> {
    private serviceUserDataFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected serviceUserDataFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new serviceUserDataFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<generated.General.ServerResponseUserData> giveResponseUserData(
        generated.General.ClientPetitionUserData request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGiveResponseUserDataMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GIVE_RESPONSE_USER_DATA = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final serviceUserDataImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(serviceUserDataImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GIVE_RESPONSE_USER_DATA:
          serviceImpl.giveResponseUserData((generated.General.ClientPetitionUserData) request,
              (io.grpc.stub.StreamObserver<generated.General.ServerResponseUserData>) responseObserver);
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

  private static abstract class serviceUserDataBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    serviceUserDataBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return generated.General.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("serviceUserData");
    }
  }

  private static final class serviceUserDataFileDescriptorSupplier
      extends serviceUserDataBaseDescriptorSupplier {
    serviceUserDataFileDescriptorSupplier() {}
  }

  private static final class serviceUserDataMethodDescriptorSupplier
      extends serviceUserDataBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    serviceUserDataMethodDescriptorSupplier(String methodName) {
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
      synchronized (serviceUserDataGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new serviceUserDataFileDescriptorSupplier())
              .addMethod(getGiveResponseUserDataMethod())
              .build();
        }
      }
    }
    return result;
  }
}
