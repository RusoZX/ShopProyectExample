package generated;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.35.0)",
    comments = "Source: general.proto")
public final class serviceRestocksGrpc {

  private serviceRestocksGrpc() {}

  public static final String SERVICE_NAME = "generated.serviceRestocks";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<generated.General.ClientPetitionRestocks,
      generated.General.ServerResponseRestocks> getGiveResponseRestocksMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "giveResponseRestocks",
      requestType = generated.General.ClientPetitionRestocks.class,
      responseType = generated.General.ServerResponseRestocks.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<generated.General.ClientPetitionRestocks,
      generated.General.ServerResponseRestocks> getGiveResponseRestocksMethod() {
    io.grpc.MethodDescriptor<generated.General.ClientPetitionRestocks, generated.General.ServerResponseRestocks> getGiveResponseRestocksMethod;
    if ((getGiveResponseRestocksMethod = serviceRestocksGrpc.getGiveResponseRestocksMethod) == null) {
      synchronized (serviceRestocksGrpc.class) {
        if ((getGiveResponseRestocksMethod = serviceRestocksGrpc.getGiveResponseRestocksMethod) == null) {
          serviceRestocksGrpc.getGiveResponseRestocksMethod = getGiveResponseRestocksMethod =
              io.grpc.MethodDescriptor.<generated.General.ClientPetitionRestocks, generated.General.ServerResponseRestocks>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "giveResponseRestocks"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.General.ClientPetitionRestocks.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.General.ServerResponseRestocks.getDefaultInstance()))
              .setSchemaDescriptor(new serviceRestocksMethodDescriptorSupplier("giveResponseRestocks"))
              .build();
        }
      }
    }
    return getGiveResponseRestocksMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static serviceRestocksStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<serviceRestocksStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<serviceRestocksStub>() {
        @java.lang.Override
        public serviceRestocksStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new serviceRestocksStub(channel, callOptions);
        }
      };
    return serviceRestocksStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static serviceRestocksBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<serviceRestocksBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<serviceRestocksBlockingStub>() {
        @java.lang.Override
        public serviceRestocksBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new serviceRestocksBlockingStub(channel, callOptions);
        }
      };
    return serviceRestocksBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static serviceRestocksFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<serviceRestocksFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<serviceRestocksFutureStub>() {
        @java.lang.Override
        public serviceRestocksFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new serviceRestocksFutureStub(channel, callOptions);
        }
      };
    return serviceRestocksFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class serviceRestocksImplBase implements io.grpc.BindableService {

    /**
     */
    public void giveResponseRestocks(generated.General.ClientPetitionRestocks request,
        io.grpc.stub.StreamObserver<generated.General.ServerResponseRestocks> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGiveResponseRestocksMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGiveResponseRestocksMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                generated.General.ClientPetitionRestocks,
                generated.General.ServerResponseRestocks>(
                  this, METHODID_GIVE_RESPONSE_RESTOCKS)))
          .build();
    }
  }

  /**
   */
  public static final class serviceRestocksStub extends io.grpc.stub.AbstractAsyncStub<serviceRestocksStub> {
    private serviceRestocksStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected serviceRestocksStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new serviceRestocksStub(channel, callOptions);
    }

    /**
     */
    public void giveResponseRestocks(generated.General.ClientPetitionRestocks request,
        io.grpc.stub.StreamObserver<generated.General.ServerResponseRestocks> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGiveResponseRestocksMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class serviceRestocksBlockingStub extends io.grpc.stub.AbstractBlockingStub<serviceRestocksBlockingStub> {
    private serviceRestocksBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected serviceRestocksBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new serviceRestocksBlockingStub(channel, callOptions);
    }

    /**
     */
    public generated.General.ServerResponseRestocks giveResponseRestocks(generated.General.ClientPetitionRestocks request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGiveResponseRestocksMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class serviceRestocksFutureStub extends io.grpc.stub.AbstractFutureStub<serviceRestocksFutureStub> {
    private serviceRestocksFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected serviceRestocksFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new serviceRestocksFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<generated.General.ServerResponseRestocks> giveResponseRestocks(
        generated.General.ClientPetitionRestocks request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGiveResponseRestocksMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GIVE_RESPONSE_RESTOCKS = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final serviceRestocksImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(serviceRestocksImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GIVE_RESPONSE_RESTOCKS:
          serviceImpl.giveResponseRestocks((generated.General.ClientPetitionRestocks) request,
              (io.grpc.stub.StreamObserver<generated.General.ServerResponseRestocks>) responseObserver);
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

  private static abstract class serviceRestocksBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    serviceRestocksBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return generated.General.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("serviceRestocks");
    }
  }

  private static final class serviceRestocksFileDescriptorSupplier
      extends serviceRestocksBaseDescriptorSupplier {
    serviceRestocksFileDescriptorSupplier() {}
  }

  private static final class serviceRestocksMethodDescriptorSupplier
      extends serviceRestocksBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    serviceRestocksMethodDescriptorSupplier(String methodName) {
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
      synchronized (serviceRestocksGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new serviceRestocksFileDescriptorSupplier())
              .addMethod(getGiveResponseRestocksMethod())
              .build();
        }
      }
    }
    return result;
  }
}
