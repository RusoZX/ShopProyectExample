package generated;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.35.0)",
    comments = "Source: general.proto")
public final class serviceUpdateProductGrpc {

  private serviceUpdateProductGrpc() {}

  public static final String SERVICE_NAME = "generated.serviceUpdateProduct";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<generated.General.ClientPetitionUpdateProduct,
      generated.General.ServerResponseUpdateProduct> getGiveResponseUpdateProductMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "giveResponseUpdateProduct",
      requestType = generated.General.ClientPetitionUpdateProduct.class,
      responseType = generated.General.ServerResponseUpdateProduct.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<generated.General.ClientPetitionUpdateProduct,
      generated.General.ServerResponseUpdateProduct> getGiveResponseUpdateProductMethod() {
    io.grpc.MethodDescriptor<generated.General.ClientPetitionUpdateProduct, generated.General.ServerResponseUpdateProduct> getGiveResponseUpdateProductMethod;
    if ((getGiveResponseUpdateProductMethod = serviceUpdateProductGrpc.getGiveResponseUpdateProductMethod) == null) {
      synchronized (serviceUpdateProductGrpc.class) {
        if ((getGiveResponseUpdateProductMethod = serviceUpdateProductGrpc.getGiveResponseUpdateProductMethod) == null) {
          serviceUpdateProductGrpc.getGiveResponseUpdateProductMethod = getGiveResponseUpdateProductMethod =
              io.grpc.MethodDescriptor.<generated.General.ClientPetitionUpdateProduct, generated.General.ServerResponseUpdateProduct>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "giveResponseUpdateProduct"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.General.ClientPetitionUpdateProduct.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.General.ServerResponseUpdateProduct.getDefaultInstance()))
              .setSchemaDescriptor(new serviceUpdateProductMethodDescriptorSupplier("giveResponseUpdateProduct"))
              .build();
        }
      }
    }
    return getGiveResponseUpdateProductMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static serviceUpdateProductStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<serviceUpdateProductStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<serviceUpdateProductStub>() {
        @java.lang.Override
        public serviceUpdateProductStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new serviceUpdateProductStub(channel, callOptions);
        }
      };
    return serviceUpdateProductStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static serviceUpdateProductBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<serviceUpdateProductBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<serviceUpdateProductBlockingStub>() {
        @java.lang.Override
        public serviceUpdateProductBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new serviceUpdateProductBlockingStub(channel, callOptions);
        }
      };
    return serviceUpdateProductBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static serviceUpdateProductFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<serviceUpdateProductFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<serviceUpdateProductFutureStub>() {
        @java.lang.Override
        public serviceUpdateProductFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new serviceUpdateProductFutureStub(channel, callOptions);
        }
      };
    return serviceUpdateProductFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class serviceUpdateProductImplBase implements io.grpc.BindableService {

    /**
     */
    public void giveResponseUpdateProduct(generated.General.ClientPetitionUpdateProduct request,
        io.grpc.stub.StreamObserver<generated.General.ServerResponseUpdateProduct> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGiveResponseUpdateProductMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGiveResponseUpdateProductMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                generated.General.ClientPetitionUpdateProduct,
                generated.General.ServerResponseUpdateProduct>(
                  this, METHODID_GIVE_RESPONSE_UPDATE_PRODUCT)))
          .build();
    }
  }

  /**
   */
  public static final class serviceUpdateProductStub extends io.grpc.stub.AbstractAsyncStub<serviceUpdateProductStub> {
    private serviceUpdateProductStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected serviceUpdateProductStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new serviceUpdateProductStub(channel, callOptions);
    }

    /**
     */
    public void giveResponseUpdateProduct(generated.General.ClientPetitionUpdateProduct request,
        io.grpc.stub.StreamObserver<generated.General.ServerResponseUpdateProduct> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGiveResponseUpdateProductMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class serviceUpdateProductBlockingStub extends io.grpc.stub.AbstractBlockingStub<serviceUpdateProductBlockingStub> {
    private serviceUpdateProductBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected serviceUpdateProductBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new serviceUpdateProductBlockingStub(channel, callOptions);
    }

    /**
     */
    public generated.General.ServerResponseUpdateProduct giveResponseUpdateProduct(generated.General.ClientPetitionUpdateProduct request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGiveResponseUpdateProductMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class serviceUpdateProductFutureStub extends io.grpc.stub.AbstractFutureStub<serviceUpdateProductFutureStub> {
    private serviceUpdateProductFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected serviceUpdateProductFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new serviceUpdateProductFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<generated.General.ServerResponseUpdateProduct> giveResponseUpdateProduct(
        generated.General.ClientPetitionUpdateProduct request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGiveResponseUpdateProductMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GIVE_RESPONSE_UPDATE_PRODUCT = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final serviceUpdateProductImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(serviceUpdateProductImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GIVE_RESPONSE_UPDATE_PRODUCT:
          serviceImpl.giveResponseUpdateProduct((generated.General.ClientPetitionUpdateProduct) request,
              (io.grpc.stub.StreamObserver<generated.General.ServerResponseUpdateProduct>) responseObserver);
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

  private static abstract class serviceUpdateProductBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    serviceUpdateProductBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return generated.General.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("serviceUpdateProduct");
    }
  }

  private static final class serviceUpdateProductFileDescriptorSupplier
      extends serviceUpdateProductBaseDescriptorSupplier {
    serviceUpdateProductFileDescriptorSupplier() {}
  }

  private static final class serviceUpdateProductMethodDescriptorSupplier
      extends serviceUpdateProductBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    serviceUpdateProductMethodDescriptorSupplier(String methodName) {
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
      synchronized (serviceUpdateProductGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new serviceUpdateProductFileDescriptorSupplier())
              .addMethod(getGiveResponseUpdateProductMethod())
              .build();
        }
      }
    }
    return result;
  }
}
