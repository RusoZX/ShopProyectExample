package generated;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.35.0)",
    comments = "Source: general.proto")
public final class serviceSalesGrpc {

  private serviceSalesGrpc() {}

  public static final String SERVICE_NAME = "generated.serviceSales";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<generated.General.ClientPetitionSales,
      generated.General.ServerResponseSales> getGiveResponseSalesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "giveResponseSales",
      requestType = generated.General.ClientPetitionSales.class,
      responseType = generated.General.ServerResponseSales.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<generated.General.ClientPetitionSales,
      generated.General.ServerResponseSales> getGiveResponseSalesMethod() {
    io.grpc.MethodDescriptor<generated.General.ClientPetitionSales, generated.General.ServerResponseSales> getGiveResponseSalesMethod;
    if ((getGiveResponseSalesMethod = serviceSalesGrpc.getGiveResponseSalesMethod) == null) {
      synchronized (serviceSalesGrpc.class) {
        if ((getGiveResponseSalesMethod = serviceSalesGrpc.getGiveResponseSalesMethod) == null) {
          serviceSalesGrpc.getGiveResponseSalesMethod = getGiveResponseSalesMethod =
              io.grpc.MethodDescriptor.<generated.General.ClientPetitionSales, generated.General.ServerResponseSales>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "giveResponseSales"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.General.ClientPetitionSales.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.General.ServerResponseSales.getDefaultInstance()))
              .setSchemaDescriptor(new serviceSalesMethodDescriptorSupplier("giveResponseSales"))
              .build();
        }
      }
    }
    return getGiveResponseSalesMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static serviceSalesStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<serviceSalesStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<serviceSalesStub>() {
        @java.lang.Override
        public serviceSalesStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new serviceSalesStub(channel, callOptions);
        }
      };
    return serviceSalesStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static serviceSalesBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<serviceSalesBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<serviceSalesBlockingStub>() {
        @java.lang.Override
        public serviceSalesBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new serviceSalesBlockingStub(channel, callOptions);
        }
      };
    return serviceSalesBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static serviceSalesFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<serviceSalesFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<serviceSalesFutureStub>() {
        @java.lang.Override
        public serviceSalesFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new serviceSalesFutureStub(channel, callOptions);
        }
      };
    return serviceSalesFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class serviceSalesImplBase implements io.grpc.BindableService {

    /**
     */
    public void giveResponseSales(generated.General.ClientPetitionSales request,
        io.grpc.stub.StreamObserver<generated.General.ServerResponseSales> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGiveResponseSalesMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGiveResponseSalesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                generated.General.ClientPetitionSales,
                generated.General.ServerResponseSales>(
                  this, METHODID_GIVE_RESPONSE_SALES)))
          .build();
    }
  }

  /**
   */
  public static final class serviceSalesStub extends io.grpc.stub.AbstractAsyncStub<serviceSalesStub> {
    private serviceSalesStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected serviceSalesStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new serviceSalesStub(channel, callOptions);
    }

    /**
     */
    public void giveResponseSales(generated.General.ClientPetitionSales request,
        io.grpc.stub.StreamObserver<generated.General.ServerResponseSales> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGiveResponseSalesMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class serviceSalesBlockingStub extends io.grpc.stub.AbstractBlockingStub<serviceSalesBlockingStub> {
    private serviceSalesBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected serviceSalesBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new serviceSalesBlockingStub(channel, callOptions);
    }

    /**
     */
    public generated.General.ServerResponseSales giveResponseSales(generated.General.ClientPetitionSales request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGiveResponseSalesMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class serviceSalesFutureStub extends io.grpc.stub.AbstractFutureStub<serviceSalesFutureStub> {
    private serviceSalesFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected serviceSalesFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new serviceSalesFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<generated.General.ServerResponseSales> giveResponseSales(
        generated.General.ClientPetitionSales request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGiveResponseSalesMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GIVE_RESPONSE_SALES = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final serviceSalesImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(serviceSalesImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GIVE_RESPONSE_SALES:
          serviceImpl.giveResponseSales((generated.General.ClientPetitionSales) request,
              (io.grpc.stub.StreamObserver<generated.General.ServerResponseSales>) responseObserver);
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

  private static abstract class serviceSalesBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    serviceSalesBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return generated.General.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("serviceSales");
    }
  }

  private static final class serviceSalesFileDescriptorSupplier
      extends serviceSalesBaseDescriptorSupplier {
    serviceSalesFileDescriptorSupplier() {}
  }

  private static final class serviceSalesMethodDescriptorSupplier
      extends serviceSalesBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    serviceSalesMethodDescriptorSupplier(String methodName) {
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
      synchronized (serviceSalesGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new serviceSalesFileDescriptorSupplier())
              .addMethod(getGiveResponseSalesMethod())
              .build();
        }
      }
    }
    return result;
  }
}
