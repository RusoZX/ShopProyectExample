package generated;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.35.0)",
    comments = "Source: general.proto")
public final class serviceAddUserGrpc {

  private serviceAddUserGrpc() {}

  public static final String SERVICE_NAME = "generated.serviceAddUser";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<generated.General.ClientPetitionAddUser,
      generated.General.ServerResponseAddUser> getGiveResponseAddUserMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "giveResponseAddUser",
      requestType = generated.General.ClientPetitionAddUser.class,
      responseType = generated.General.ServerResponseAddUser.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<generated.General.ClientPetitionAddUser,
      generated.General.ServerResponseAddUser> getGiveResponseAddUserMethod() {
    io.grpc.MethodDescriptor<generated.General.ClientPetitionAddUser, generated.General.ServerResponseAddUser> getGiveResponseAddUserMethod;
    if ((getGiveResponseAddUserMethod = serviceAddUserGrpc.getGiveResponseAddUserMethod) == null) {
      synchronized (serviceAddUserGrpc.class) {
        if ((getGiveResponseAddUserMethod = serviceAddUserGrpc.getGiveResponseAddUserMethod) == null) {
          serviceAddUserGrpc.getGiveResponseAddUserMethod = getGiveResponseAddUserMethod =
              io.grpc.MethodDescriptor.<generated.General.ClientPetitionAddUser, generated.General.ServerResponseAddUser>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "giveResponseAddUser"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.General.ClientPetitionAddUser.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.General.ServerResponseAddUser.getDefaultInstance()))
              .setSchemaDescriptor(new serviceAddUserMethodDescriptorSupplier("giveResponseAddUser"))
              .build();
        }
      }
    }
    return getGiveResponseAddUserMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static serviceAddUserStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<serviceAddUserStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<serviceAddUserStub>() {
        @java.lang.Override
        public serviceAddUserStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new serviceAddUserStub(channel, callOptions);
        }
      };
    return serviceAddUserStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static serviceAddUserBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<serviceAddUserBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<serviceAddUserBlockingStub>() {
        @java.lang.Override
        public serviceAddUserBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new serviceAddUserBlockingStub(channel, callOptions);
        }
      };
    return serviceAddUserBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static serviceAddUserFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<serviceAddUserFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<serviceAddUserFutureStub>() {
        @java.lang.Override
        public serviceAddUserFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new serviceAddUserFutureStub(channel, callOptions);
        }
      };
    return serviceAddUserFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class serviceAddUserImplBase implements io.grpc.BindableService {

    /**
     */
    public void giveResponseAddUser(generated.General.ClientPetitionAddUser request,
        io.grpc.stub.StreamObserver<generated.General.ServerResponseAddUser> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGiveResponseAddUserMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGiveResponseAddUserMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                generated.General.ClientPetitionAddUser,
                generated.General.ServerResponseAddUser>(
                  this, METHODID_GIVE_RESPONSE_ADD_USER)))
          .build();
    }
  }

  /**
   */
  public static final class serviceAddUserStub extends io.grpc.stub.AbstractAsyncStub<serviceAddUserStub> {
    private serviceAddUserStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected serviceAddUserStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new serviceAddUserStub(channel, callOptions);
    }

    /**
     */
    public void giveResponseAddUser(generated.General.ClientPetitionAddUser request,
        io.grpc.stub.StreamObserver<generated.General.ServerResponseAddUser> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGiveResponseAddUserMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class serviceAddUserBlockingStub extends io.grpc.stub.AbstractBlockingStub<serviceAddUserBlockingStub> {
    private serviceAddUserBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected serviceAddUserBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new serviceAddUserBlockingStub(channel, callOptions);
    }

    /**
     */
    public generated.General.ServerResponseAddUser giveResponseAddUser(generated.General.ClientPetitionAddUser request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGiveResponseAddUserMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class serviceAddUserFutureStub extends io.grpc.stub.AbstractFutureStub<serviceAddUserFutureStub> {
    private serviceAddUserFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected serviceAddUserFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new serviceAddUserFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<generated.General.ServerResponseAddUser> giveResponseAddUser(
        generated.General.ClientPetitionAddUser request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGiveResponseAddUserMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GIVE_RESPONSE_ADD_USER = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final serviceAddUserImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(serviceAddUserImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GIVE_RESPONSE_ADD_USER:
          serviceImpl.giveResponseAddUser((generated.General.ClientPetitionAddUser) request,
              (io.grpc.stub.StreamObserver<generated.General.ServerResponseAddUser>) responseObserver);
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

  private static abstract class serviceAddUserBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    serviceAddUserBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return generated.General.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("serviceAddUser");
    }
  }

  private static final class serviceAddUserFileDescriptorSupplier
      extends serviceAddUserBaseDescriptorSupplier {
    serviceAddUserFileDescriptorSupplier() {}
  }

  private static final class serviceAddUserMethodDescriptorSupplier
      extends serviceAddUserBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    serviceAddUserMethodDescriptorSupplier(String methodName) {
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
      synchronized (serviceAddUserGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new serviceAddUserFileDescriptorSupplier())
              .addMethod(getGiveResponseAddUserMethod())
              .build();
        }
      }
    }
    return result;
  }
}
