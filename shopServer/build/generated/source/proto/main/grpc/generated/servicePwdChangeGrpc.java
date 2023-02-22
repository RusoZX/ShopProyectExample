package generated;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.35.0)",
    comments = "Source: general.proto")
public final class servicePwdChangeGrpc {

  private servicePwdChangeGrpc() {}

  public static final String SERVICE_NAME = "generated.servicePwdChange";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<generated.General.ClientPetitionPwdChange,
      generated.General.ServerResponsePwdChange> getGiveResponsePwdChangeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "giveResponsePwdChange",
      requestType = generated.General.ClientPetitionPwdChange.class,
      responseType = generated.General.ServerResponsePwdChange.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<generated.General.ClientPetitionPwdChange,
      generated.General.ServerResponsePwdChange> getGiveResponsePwdChangeMethod() {
    io.grpc.MethodDescriptor<generated.General.ClientPetitionPwdChange, generated.General.ServerResponsePwdChange> getGiveResponsePwdChangeMethod;
    if ((getGiveResponsePwdChangeMethod = servicePwdChangeGrpc.getGiveResponsePwdChangeMethod) == null) {
      synchronized (servicePwdChangeGrpc.class) {
        if ((getGiveResponsePwdChangeMethod = servicePwdChangeGrpc.getGiveResponsePwdChangeMethod) == null) {
          servicePwdChangeGrpc.getGiveResponsePwdChangeMethod = getGiveResponsePwdChangeMethod =
              io.grpc.MethodDescriptor.<generated.General.ClientPetitionPwdChange, generated.General.ServerResponsePwdChange>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "giveResponsePwdChange"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.General.ClientPetitionPwdChange.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.General.ServerResponsePwdChange.getDefaultInstance()))
              .setSchemaDescriptor(new servicePwdChangeMethodDescriptorSupplier("giveResponsePwdChange"))
              .build();
        }
      }
    }
    return getGiveResponsePwdChangeMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static servicePwdChangeStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<servicePwdChangeStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<servicePwdChangeStub>() {
        @java.lang.Override
        public servicePwdChangeStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new servicePwdChangeStub(channel, callOptions);
        }
      };
    return servicePwdChangeStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static servicePwdChangeBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<servicePwdChangeBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<servicePwdChangeBlockingStub>() {
        @java.lang.Override
        public servicePwdChangeBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new servicePwdChangeBlockingStub(channel, callOptions);
        }
      };
    return servicePwdChangeBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static servicePwdChangeFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<servicePwdChangeFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<servicePwdChangeFutureStub>() {
        @java.lang.Override
        public servicePwdChangeFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new servicePwdChangeFutureStub(channel, callOptions);
        }
      };
    return servicePwdChangeFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class servicePwdChangeImplBase implements io.grpc.BindableService {

    /**
     */
    public void giveResponsePwdChange(generated.General.ClientPetitionPwdChange request,
        io.grpc.stub.StreamObserver<generated.General.ServerResponsePwdChange> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGiveResponsePwdChangeMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGiveResponsePwdChangeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                generated.General.ClientPetitionPwdChange,
                generated.General.ServerResponsePwdChange>(
                  this, METHODID_GIVE_RESPONSE_PWD_CHANGE)))
          .build();
    }
  }

  /**
   */
  public static final class servicePwdChangeStub extends io.grpc.stub.AbstractAsyncStub<servicePwdChangeStub> {
    private servicePwdChangeStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected servicePwdChangeStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new servicePwdChangeStub(channel, callOptions);
    }

    /**
     */
    public void giveResponsePwdChange(generated.General.ClientPetitionPwdChange request,
        io.grpc.stub.StreamObserver<generated.General.ServerResponsePwdChange> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGiveResponsePwdChangeMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class servicePwdChangeBlockingStub extends io.grpc.stub.AbstractBlockingStub<servicePwdChangeBlockingStub> {
    private servicePwdChangeBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected servicePwdChangeBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new servicePwdChangeBlockingStub(channel, callOptions);
    }

    /**
     */
    public generated.General.ServerResponsePwdChange giveResponsePwdChange(generated.General.ClientPetitionPwdChange request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGiveResponsePwdChangeMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class servicePwdChangeFutureStub extends io.grpc.stub.AbstractFutureStub<servicePwdChangeFutureStub> {
    private servicePwdChangeFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected servicePwdChangeFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new servicePwdChangeFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<generated.General.ServerResponsePwdChange> giveResponsePwdChange(
        generated.General.ClientPetitionPwdChange request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGiveResponsePwdChangeMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GIVE_RESPONSE_PWD_CHANGE = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final servicePwdChangeImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(servicePwdChangeImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GIVE_RESPONSE_PWD_CHANGE:
          serviceImpl.giveResponsePwdChange((generated.General.ClientPetitionPwdChange) request,
              (io.grpc.stub.StreamObserver<generated.General.ServerResponsePwdChange>) responseObserver);
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

  private static abstract class servicePwdChangeBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    servicePwdChangeBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return generated.General.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("servicePwdChange");
    }
  }

  private static final class servicePwdChangeFileDescriptorSupplier
      extends servicePwdChangeBaseDescriptorSupplier {
    servicePwdChangeFileDescriptorSupplier() {}
  }

  private static final class servicePwdChangeMethodDescriptorSupplier
      extends servicePwdChangeBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    servicePwdChangeMethodDescriptorSupplier(String methodName) {
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
      synchronized (servicePwdChangeGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new servicePwdChangeFileDescriptorSupplier())
              .addMethod(getGiveResponsePwdChangeMethod())
              .build();
        }
      }
    }
    return result;
  }
}
