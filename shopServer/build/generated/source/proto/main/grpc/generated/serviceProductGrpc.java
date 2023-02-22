package generated;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.35.0)",
    comments = "Source: general.proto")
public final class serviceProductGrpc {

  private serviceProductGrpc() {}

  public static final String SERVICE_NAME = "generated.serviceProduct";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<generated.General.ClientPetitionProduct,
      generated.General.ServerResponseProduct> getGiveResponseProductMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "giveResponseProduct",
      requestType = generated.General.ClientPetitionProduct.class,
      responseType = generated.General.ServerResponseProduct.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<generated.General.ClientPetitionProduct,
      generated.General.ServerResponseProduct> getGiveResponseProductMethod() {
    io.grpc.MethodDescriptor<generated.General.ClientPetitionProduct, generated.General.ServerResponseProduct> getGiveResponseProductMethod;
    if ((getGiveResponseProductMethod = serviceProductGrpc.getGiveResponseProductMethod) == null) {
      synchronized (serviceProductGrpc.class) {
        if ((getGiveResponseProductMethod = serviceProductGrpc.getGiveResponseProductMethod) == null) {
          serviceProductGrpc.getGiveResponseProductMethod = getGiveResponseProductMethod =
              io.grpc.MethodDescriptor.<generated.General.ClientPetitionProduct, generated.General.ServerResponseProduct>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "giveResponseProduct"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.General.ClientPetitionProduct.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.General.ServerResponseProduct.getDefaultInstance()))
              .setSchemaDescriptor(new serviceProductMethodDescriptorSupplier("giveResponseProduct"))
              .build();
        }
      }
    }
    return getGiveResponseProductMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static serviceProductStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<serviceProductStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<serviceProductStub>() {
        @java.lang.Override
        public serviceProductStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new serviceProductStub(channel, callOptions);
        }
      };
    return serviceProductStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static serviceProductBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<serviceProductBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<serviceProductBlockingStub>() {
        @java.lang.Override
        public serviceProductBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new serviceProductBlockingStub(channel, callOptions);
        }
      };
    return serviceProductBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static serviceProductFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<serviceProductFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<serviceProductFutureStub>() {
        @java.lang.Override
        public serviceProductFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new serviceProductFutureStub(channel, callOptions);
        }
      };
    return serviceProductFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class serviceProductImplBase implements io.grpc.BindableService {

    /**
     */
    public void giveResponseProduct(generated.General.ClientPetitionProduct request,
        io.grpc.stub.StreamObserver<generated.General.ServerResponseProduct> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGiveResponseProductMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGiveResponseProductMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                generated.General.ClientPetitionProduct,
                generated.General.ServerResponseProduct>(
                  this, METHODID_GIVE_RESPONSE_PRODUCT)))
          .build();
    }
  }

  /**
   */
  public static final class serviceProductStub extends io.grpc.stub.AbstractAsyncStub<serviceProductStub> {
    private serviceProductStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected serviceProductStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new serviceProductStub(channel, callOptions);
    }

    /**
     */
    public void giveResponseProduct(generated.General.ClientPetitionProduct request,
        io.grpc.stub.StreamObserver<generated.General.ServerResponseProduct> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGiveResponseProductMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class serviceProductBlockingStub extends io.grpc.stub.AbstractBlockingStub<serviceProductBlockingStub> {
    private serviceProductBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected serviceProductBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new serviceProductBlockingStub(channel, callOptions);
    }

    /**
     */
    public generated.General.ServerResponseProduct giveResponseProduct(generated.General.ClientPetitionProduct request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGiveResponseProductMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class serviceProductFutureStub extends io.grpc.stub.AbstractFutureStub<serviceProductFutureStub> {
    private serviceProductFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected serviceProductFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new serviceProductFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<generated.General.ServerResponseProduct> giveResponseProduct(
        generated.General.ClientPetitionProduct request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGiveResponseProductMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GIVE_RESPONSE_PRODUCT = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final serviceProductImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(serviceProductImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GIVE_RESPONSE_PRODUCT:
          serviceImpl.giveResponseProduct((generated.General.ClientPetitionProduct) request,
              (io.grpc.stub.StreamObserver<generated.General.ServerResponseProduct>) responseObserver);
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

  private static abstract class serviceProductBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    serviceProductBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return generated.General.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("serviceProduct");
    }
  }

  private static final class serviceProductFileDescriptorSupplier
      extends serviceProductBaseDescriptorSupplier {
    serviceProductFileDescriptorSupplier() {}
  }

  private static final class serviceProductMethodDescriptorSupplier
      extends serviceProductBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    serviceProductMethodDescriptorSupplier(String methodName) {
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
      synchronized (serviceProductGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new serviceProductFileDescriptorSupplier())
              .addMethod(getGiveResponseProductMethod())
              .build();
        }
      }
    }
    return result;
  }
}
