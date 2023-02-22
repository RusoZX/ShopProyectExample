package generated;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.35.0)",
    comments = "Source: general.proto")
public final class serviceLoginGrpc {

  private serviceLoginGrpc() {}

  public static final String SERVICE_NAME = "generated.serviceLogin";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<generated.General.ClientPetitionLogin,
      generated.General.ServerResponseLogin> getGiveResponseLoginMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "giveResponseLogin",
      requestType = generated.General.ClientPetitionLogin.class,
      responseType = generated.General.ServerResponseLogin.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<generated.General.ClientPetitionLogin,
      generated.General.ServerResponseLogin> getGiveResponseLoginMethod() {
    io.grpc.MethodDescriptor<generated.General.ClientPetitionLogin, generated.General.ServerResponseLogin> getGiveResponseLoginMethod;
    if ((getGiveResponseLoginMethod = serviceLoginGrpc.getGiveResponseLoginMethod) == null) {
      synchronized (serviceLoginGrpc.class) {
        if ((getGiveResponseLoginMethod = serviceLoginGrpc.getGiveResponseLoginMethod) == null) {
          serviceLoginGrpc.getGiveResponseLoginMethod = getGiveResponseLoginMethod =
              io.grpc.MethodDescriptor.<generated.General.ClientPetitionLogin, generated.General.ServerResponseLogin>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "giveResponseLogin"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.General.ClientPetitionLogin.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.General.ServerResponseLogin.getDefaultInstance()))
              .setSchemaDescriptor(new serviceLoginMethodDescriptorSupplier("giveResponseLogin"))
              .build();
        }
      }
    }
    return getGiveResponseLoginMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static serviceLoginStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<serviceLoginStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<serviceLoginStub>() {
        @java.lang.Override
        public serviceLoginStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new serviceLoginStub(channel, callOptions);
        }
      };
    return serviceLoginStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static serviceLoginBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<serviceLoginBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<serviceLoginBlockingStub>() {
        @java.lang.Override
        public serviceLoginBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new serviceLoginBlockingStub(channel, callOptions);
        }
      };
    return serviceLoginBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static serviceLoginFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<serviceLoginFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<serviceLoginFutureStub>() {
        @java.lang.Override
        public serviceLoginFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new serviceLoginFutureStub(channel, callOptions);
        }
      };
    return serviceLoginFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class serviceLoginImplBase implements io.grpc.BindableService {

    /**
     */
    public void giveResponseLogin(generated.General.ClientPetitionLogin request,
        io.grpc.stub.StreamObserver<generated.General.ServerResponseLogin> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGiveResponseLoginMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGiveResponseLoginMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                generated.General.ClientPetitionLogin,
                generated.General.ServerResponseLogin>(
                  this, METHODID_GIVE_RESPONSE_LOGIN)))
          .build();
    }
  }

  /**
   */
  public static final class serviceLoginStub extends io.grpc.stub.AbstractAsyncStub<serviceLoginStub> {
    private serviceLoginStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected serviceLoginStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new serviceLoginStub(channel, callOptions);
    }

    /**
     */
    public void giveResponseLogin(generated.General.ClientPetitionLogin request,
        io.grpc.stub.StreamObserver<generated.General.ServerResponseLogin> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGiveResponseLoginMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class serviceLoginBlockingStub extends io.grpc.stub.AbstractBlockingStub<serviceLoginBlockingStub> {
    private serviceLoginBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected serviceLoginBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new serviceLoginBlockingStub(channel, callOptions);
    }

    /**
     */
    public generated.General.ServerResponseLogin giveResponseLogin(generated.General.ClientPetitionLogin request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGiveResponseLoginMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class serviceLoginFutureStub extends io.grpc.stub.AbstractFutureStub<serviceLoginFutureStub> {
    private serviceLoginFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected serviceLoginFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new serviceLoginFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<generated.General.ServerResponseLogin> giveResponseLogin(
        generated.General.ClientPetitionLogin request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGiveResponseLoginMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GIVE_RESPONSE_LOGIN = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final serviceLoginImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(serviceLoginImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GIVE_RESPONSE_LOGIN:
          serviceImpl.giveResponseLogin((generated.General.ClientPetitionLogin) request,
              (io.grpc.stub.StreamObserver<generated.General.ServerResponseLogin>) responseObserver);
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

  private static abstract class serviceLoginBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    serviceLoginBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return generated.General.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("serviceLogin");
    }
  }

  private static final class serviceLoginFileDescriptorSupplier
      extends serviceLoginBaseDescriptorSupplier {
    serviceLoginFileDescriptorSupplier() {}
  }

  private static final class serviceLoginMethodDescriptorSupplier
      extends serviceLoginBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    serviceLoginMethodDescriptorSupplier(String methodName) {
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
      synchronized (serviceLoginGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new serviceLoginFileDescriptorSupplier())
              .addMethod(getGiveResponseLoginMethod())
              .build();
        }
      }
    }
    return result;
  }
}
