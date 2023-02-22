package generated;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.35.0)",
    comments = "Source: general.proto")
public final class serviceAddProductGrpc {

  private serviceAddProductGrpc() {}

  public static final String SERVICE_NAME = "generated.serviceAddProduct";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<generated.General.ClientPetitionAddProduct,
      generated.General.ServerResponseAddProduct> getGiveResponseAddProductMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "giveResponseAddProduct",
      requestType = generated.General.ClientPetitionAddProduct.class,
      responseType = generated.General.ServerResponseAddProduct.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<generated.General.ClientPetitionAddProduct,
      generated.General.ServerResponseAddProduct> getGiveResponseAddProductMethod() {
    io.grpc.MethodDescriptor<generated.General.ClientPetitionAddProduct, generated.General.ServerResponseAddProduct> getGiveResponseAddProductMethod;
    if ((getGiveResponseAddProductMethod = serviceAddProductGrpc.getGiveResponseAddProductMethod) == null) {
      synchronized (serviceAddProductGrpc.class) {
        if ((getGiveResponseAddProductMethod = serviceAddProductGrpc.getGiveResponseAddProductMethod) == null) {
          serviceAddProductGrpc.getGiveResponseAddProductMethod = getGiveResponseAddProductMethod =
              io.grpc.MethodDescriptor.<generated.General.ClientPetitionAddProduct, generated.General.ServerResponseAddProduct>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "giveResponseAddProduct"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.General.ClientPetitionAddProduct.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.General.ServerResponseAddProduct.getDefaultInstance()))
              .setSchemaDescriptor(new serviceAddProductMethodDescriptorSupplier("giveResponseAddProduct"))
              .build();
        }
      }
    }
    return getGiveResponseAddProductMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static serviceAddProductStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<serviceAddProductStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<serviceAddProductStub>() {
        @java.lang.Override
        public serviceAddProductStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new serviceAddProductStub(channel, callOptions);
        }
      };
    return serviceAddProductStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static serviceAddProductBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<serviceAddProductBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<serviceAddProductBlockingStub>() {
        @java.lang.Override
        public serviceAddProductBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new serviceAddProductBlockingStub(channel, callOptions);
        }
      };
    return serviceAddProductBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static serviceAddProductFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<serviceAddProductFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<serviceAddProductFutureStub>() {
        @java.lang.Override
        public serviceAddProductFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new serviceAddProductFutureStub(channel, callOptions);
        }
      };
    return serviceAddProductFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class serviceAddProductImplBase implements io.grpc.BindableService {

    /**
     */
    public void giveResponseAddProduct(generated.General.ClientPetitionAddProduct request,
        io.grpc.stub.StreamObserver<generated.General.ServerResponseAddProduct> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGiveResponseAddProductMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGiveResponseAddProductMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                generated.General.ClientPetitionAddProduct,
                generated.General.ServerResponseAddProduct>(
                  this, METHODID_GIVE_RESPONSE_ADD_PRODUCT)))
          .build();
    }
  }

  /**
   */
  public static final class serviceAddProductStub extends io.grpc.stub.AbstractAsyncStub<serviceAddProductStub> {
    private serviceAddProductStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected serviceAddProductStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new serviceAddProductStub(channel, callOptions);
    }

    /**
     */
    public void giveResponseAddProduct(generated.General.ClientPetitionAddProduct request,
        io.grpc.stub.StreamObserver<generated.General.ServerResponseAddProduct> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGiveResponseAddProductMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class serviceAddProductBlockingStub extends io.grpc.stub.AbstractBlockingStub<serviceAddProductBlockingStub> {
    private serviceAddProductBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected serviceAddProductBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new serviceAddProductBlockingStub(channel, callOptions);
    }

    /**
     */
    public generated.General.ServerResponseAddProduct giveResponseAddProduct(generated.General.ClientPetitionAddProduct request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGiveResponseAddProductMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class serviceAddProductFutureStub extends io.grpc.stub.AbstractFutureStub<serviceAddProductFutureStub> {
    private serviceAddProductFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected serviceAddProductFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new serviceAddProductFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<generated.General.ServerResponseAddProduct> giveResponseAddProduct(
        generated.General.ClientPetitionAddProduct request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGiveResponseAddProductMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GIVE_RESPONSE_ADD_PRODUCT = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final serviceAddProductImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(serviceAddProductImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GIVE_RESPONSE_ADD_PRODUCT:
          serviceImpl.giveResponseAddProduct((generated.General.ClientPetitionAddProduct) request,
              (io.grpc.stub.StreamObserver<generated.General.ServerResponseAddProduct>) responseObserver);
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

  private static abstract class serviceAddProductBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    serviceAddProductBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return generated.General.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("serviceAddProduct");
    }
  }

  private static final class serviceAddProductFileDescriptorSupplier
      extends serviceAddProductBaseDescriptorSupplier {
    serviceAddProductFileDescriptorSupplier() {}
  }

  private static final class serviceAddProductMethodDescriptorSupplier
      extends serviceAddProductBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    serviceAddProductMethodDescriptorSupplier(String methodName) {
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
      synchronized (serviceAddProductGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new serviceAddProductFileDescriptorSupplier())
              .addMethod(getGiveResponseAddProductMethod())
              .build();
        }
      }
    }
    return result;
  }
}
