package generated;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.35.0)",
    comments = "Source: general.proto")
public final class serviceUpdateUserDataGrpc {

  private serviceUpdateUserDataGrpc() {}

  public static final String SERVICE_NAME = "generated.serviceUpdateUserData";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<generated.General.ClientPetitionUpdateUserData,
      generated.General.ServerResponseUpdateUserData> getGiveResponseUpdateUserDataMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "giveResponseUpdateUserData",
      requestType = generated.General.ClientPetitionUpdateUserData.class,
      responseType = generated.General.ServerResponseUpdateUserData.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<generated.General.ClientPetitionUpdateUserData,
      generated.General.ServerResponseUpdateUserData> getGiveResponseUpdateUserDataMethod() {
    io.grpc.MethodDescriptor<generated.General.ClientPetitionUpdateUserData, generated.General.ServerResponseUpdateUserData> getGiveResponseUpdateUserDataMethod;
    if ((getGiveResponseUpdateUserDataMethod = serviceUpdateUserDataGrpc.getGiveResponseUpdateUserDataMethod) == null) {
      synchronized (serviceUpdateUserDataGrpc.class) {
        if ((getGiveResponseUpdateUserDataMethod = serviceUpdateUserDataGrpc.getGiveResponseUpdateUserDataMethod) == null) {
          serviceUpdateUserDataGrpc.getGiveResponseUpdateUserDataMethod = getGiveResponseUpdateUserDataMethod =
              io.grpc.MethodDescriptor.<generated.General.ClientPetitionUpdateUserData, generated.General.ServerResponseUpdateUserData>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "giveResponseUpdateUserData"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.General.ClientPetitionUpdateUserData.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.General.ServerResponseUpdateUserData.getDefaultInstance()))
              .setSchemaDescriptor(new serviceUpdateUserDataMethodDescriptorSupplier("giveResponseUpdateUserData"))
              .build();
        }
      }
    }
    return getGiveResponseUpdateUserDataMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static serviceUpdateUserDataStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<serviceUpdateUserDataStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<serviceUpdateUserDataStub>() {
        @java.lang.Override
        public serviceUpdateUserDataStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new serviceUpdateUserDataStub(channel, callOptions);
        }
      };
    return serviceUpdateUserDataStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static serviceUpdateUserDataBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<serviceUpdateUserDataBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<serviceUpdateUserDataBlockingStub>() {
        @java.lang.Override
        public serviceUpdateUserDataBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new serviceUpdateUserDataBlockingStub(channel, callOptions);
        }
      };
    return serviceUpdateUserDataBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static serviceUpdateUserDataFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<serviceUpdateUserDataFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<serviceUpdateUserDataFutureStub>() {
        @java.lang.Override
        public serviceUpdateUserDataFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new serviceUpdateUserDataFutureStub(channel, callOptions);
        }
      };
    return serviceUpdateUserDataFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class serviceUpdateUserDataImplBase implements io.grpc.BindableService {

    /**
     */
    public void giveResponseUpdateUserData(generated.General.ClientPetitionUpdateUserData request,
        io.grpc.stub.StreamObserver<generated.General.ServerResponseUpdateUserData> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGiveResponseUpdateUserDataMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGiveResponseUpdateUserDataMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                generated.General.ClientPetitionUpdateUserData,
                generated.General.ServerResponseUpdateUserData>(
                  this, METHODID_GIVE_RESPONSE_UPDATE_USER_DATA)))
          .build();
    }
  }

  /**
   */
  public static final class serviceUpdateUserDataStub extends io.grpc.stub.AbstractAsyncStub<serviceUpdateUserDataStub> {
    private serviceUpdateUserDataStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected serviceUpdateUserDataStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new serviceUpdateUserDataStub(channel, callOptions);
    }

    /**
     */
    public void giveResponseUpdateUserData(generated.General.ClientPetitionUpdateUserData request,
        io.grpc.stub.StreamObserver<generated.General.ServerResponseUpdateUserData> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGiveResponseUpdateUserDataMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class serviceUpdateUserDataBlockingStub extends io.grpc.stub.AbstractBlockingStub<serviceUpdateUserDataBlockingStub> {
    private serviceUpdateUserDataBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected serviceUpdateUserDataBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new serviceUpdateUserDataBlockingStub(channel, callOptions);
    }

    /**
     */
    public generated.General.ServerResponseUpdateUserData giveResponseUpdateUserData(generated.General.ClientPetitionUpdateUserData request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGiveResponseUpdateUserDataMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class serviceUpdateUserDataFutureStub extends io.grpc.stub.AbstractFutureStub<serviceUpdateUserDataFutureStub> {
    private serviceUpdateUserDataFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected serviceUpdateUserDataFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new serviceUpdateUserDataFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<generated.General.ServerResponseUpdateUserData> giveResponseUpdateUserData(
        generated.General.ClientPetitionUpdateUserData request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGiveResponseUpdateUserDataMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GIVE_RESPONSE_UPDATE_USER_DATA = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final serviceUpdateUserDataImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(serviceUpdateUserDataImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GIVE_RESPONSE_UPDATE_USER_DATA:
          serviceImpl.giveResponseUpdateUserData((generated.General.ClientPetitionUpdateUserData) request,
              (io.grpc.stub.StreamObserver<generated.General.ServerResponseUpdateUserData>) responseObserver);
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

  private static abstract class serviceUpdateUserDataBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    serviceUpdateUserDataBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return generated.General.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("serviceUpdateUserData");
    }
  }

  private static final class serviceUpdateUserDataFileDescriptorSupplier
      extends serviceUpdateUserDataBaseDescriptorSupplier {
    serviceUpdateUserDataFileDescriptorSupplier() {}
  }

  private static final class serviceUpdateUserDataMethodDescriptorSupplier
      extends serviceUpdateUserDataBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    serviceUpdateUserDataMethodDescriptorSupplier(String methodName) {
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
      synchronized (serviceUpdateUserDataGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new serviceUpdateUserDataFileDescriptorSupplier())
              .addMethod(getGiveResponseUpdateUserDataMethod())
              .build();
        }
      }
    }
    return result;
  }
}
