package generated;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.35.0)",
    comments = "Source: general.proto")
public final class serviceProductsGrpc {

  private serviceProductsGrpc() {}

  public static final String SERVICE_NAME = "generated.serviceProducts";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<generated.General.ClientPetitionProducts,
      generated.General.ServerResponseProducts> getGiveResponseProductsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "giveResponseProducts",
      requestType = generated.General.ClientPetitionProducts.class,
      responseType = generated.General.ServerResponseProducts.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<generated.General.ClientPetitionProducts,
      generated.General.ServerResponseProducts> getGiveResponseProductsMethod() {
    io.grpc.MethodDescriptor<generated.General.ClientPetitionProducts, generated.General.ServerResponseProducts> getGiveResponseProductsMethod;
    if ((getGiveResponseProductsMethod = serviceProductsGrpc.getGiveResponseProductsMethod) == null) {
      synchronized (serviceProductsGrpc.class) {
        if ((getGiveResponseProductsMethod = serviceProductsGrpc.getGiveResponseProductsMethod) == null) {
          serviceProductsGrpc.getGiveResponseProductsMethod = getGiveResponseProductsMethod =
              io.grpc.MethodDescriptor.<generated.General.ClientPetitionProducts, generated.General.ServerResponseProducts>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "giveResponseProducts"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.General.ClientPetitionProducts.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.General.ServerResponseProducts.getDefaultInstance()))
              .setSchemaDescriptor(new serviceProductsMethodDescriptorSupplier("giveResponseProducts"))
              .build();
        }
      }
    }
    return getGiveResponseProductsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static serviceProductsStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<serviceProductsStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<serviceProductsStub>() {
        @java.lang.Override
        public serviceProductsStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new serviceProductsStub(channel, callOptions);
        }
      };
    return serviceProductsStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static serviceProductsBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<serviceProductsBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<serviceProductsBlockingStub>() {
        @java.lang.Override
        public serviceProductsBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new serviceProductsBlockingStub(channel, callOptions);
        }
      };
    return serviceProductsBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static serviceProductsFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<serviceProductsFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<serviceProductsFutureStub>() {
        @java.lang.Override
        public serviceProductsFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new serviceProductsFutureStub(channel, callOptions);
        }
      };
    return serviceProductsFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class serviceProductsImplBase implements io.grpc.BindableService {

    /**
     */
    public void giveResponseProducts(generated.General.ClientPetitionProducts request,
        io.grpc.stub.StreamObserver<generated.General.ServerResponseProducts> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGiveResponseProductsMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGiveResponseProductsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                generated.General.ClientPetitionProducts,
                generated.General.ServerResponseProducts>(
                  this, METHODID_GIVE_RESPONSE_PRODUCTS)))
          .build();
    }
  }

  /**
   */
  public static final class serviceProductsStub extends io.grpc.stub.AbstractAsyncStub<serviceProductsStub> {
    private serviceProductsStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected serviceProductsStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new serviceProductsStub(channel, callOptions);
    }

    /**
     */
    public void giveResponseProducts(generated.General.ClientPetitionProducts request,
        io.grpc.stub.StreamObserver<generated.General.ServerResponseProducts> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGiveResponseProductsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class serviceProductsBlockingStub extends io.grpc.stub.AbstractBlockingStub<serviceProductsBlockingStub> {
    private serviceProductsBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected serviceProductsBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new serviceProductsBlockingStub(channel, callOptions);
    }

    /**
     */
    public generated.General.ServerResponseProducts giveResponseProducts(generated.General.ClientPetitionProducts request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGiveResponseProductsMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class serviceProductsFutureStub extends io.grpc.stub.AbstractFutureStub<serviceProductsFutureStub> {
    private serviceProductsFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected serviceProductsFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new serviceProductsFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<generated.General.ServerResponseProducts> giveResponseProducts(
        generated.General.ClientPetitionProducts request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGiveResponseProductsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GIVE_RESPONSE_PRODUCTS = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final serviceProductsImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(serviceProductsImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GIVE_RESPONSE_PRODUCTS:
          serviceImpl.giveResponseProducts((generated.General.ClientPetitionProducts) request,
              (io.grpc.stub.StreamObserver<generated.General.ServerResponseProducts>) responseObserver);
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

  private static abstract class serviceProductsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    serviceProductsBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return generated.General.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("serviceProducts");
    }
  }

  private static final class serviceProductsFileDescriptorSupplier
      extends serviceProductsBaseDescriptorSupplier {
    serviceProductsFileDescriptorSupplier() {}
  }

  private static final class serviceProductsMethodDescriptorSupplier
      extends serviceProductsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    serviceProductsMethodDescriptorSupplier(String methodName) {
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
      synchronized (serviceProductsGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new serviceProductsFileDescriptorSupplier())
              .addMethod(getGiveResponseProductsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
