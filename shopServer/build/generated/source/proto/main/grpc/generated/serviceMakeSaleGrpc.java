package generated;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.35.0)",
    comments = "Source: general.proto")
public final class serviceMakeSaleGrpc {

  private serviceMakeSaleGrpc() {}

  public static final String SERVICE_NAME = "generated.serviceMakeSale";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<generated.General.ClientPetitionMakeSale,
      generated.General.ServerResponseMakeSale> getGiveResponseMakeSaleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "giveResponseMakeSale",
      requestType = generated.General.ClientPetitionMakeSale.class,
      responseType = generated.General.ServerResponseMakeSale.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<generated.General.ClientPetitionMakeSale,
      generated.General.ServerResponseMakeSale> getGiveResponseMakeSaleMethod() {
    io.grpc.MethodDescriptor<generated.General.ClientPetitionMakeSale, generated.General.ServerResponseMakeSale> getGiveResponseMakeSaleMethod;
    if ((getGiveResponseMakeSaleMethod = serviceMakeSaleGrpc.getGiveResponseMakeSaleMethod) == null) {
      synchronized (serviceMakeSaleGrpc.class) {
        if ((getGiveResponseMakeSaleMethod = serviceMakeSaleGrpc.getGiveResponseMakeSaleMethod) == null) {
          serviceMakeSaleGrpc.getGiveResponseMakeSaleMethod = getGiveResponseMakeSaleMethod =
              io.grpc.MethodDescriptor.<generated.General.ClientPetitionMakeSale, generated.General.ServerResponseMakeSale>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "giveResponseMakeSale"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.General.ClientPetitionMakeSale.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.General.ServerResponseMakeSale.getDefaultInstance()))
              .setSchemaDescriptor(new serviceMakeSaleMethodDescriptorSupplier("giveResponseMakeSale"))
              .build();
        }
      }
    }
    return getGiveResponseMakeSaleMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static serviceMakeSaleStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<serviceMakeSaleStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<serviceMakeSaleStub>() {
        @java.lang.Override
        public serviceMakeSaleStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new serviceMakeSaleStub(channel, callOptions);
        }
      };
    return serviceMakeSaleStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static serviceMakeSaleBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<serviceMakeSaleBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<serviceMakeSaleBlockingStub>() {
        @java.lang.Override
        public serviceMakeSaleBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new serviceMakeSaleBlockingStub(channel, callOptions);
        }
      };
    return serviceMakeSaleBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static serviceMakeSaleFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<serviceMakeSaleFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<serviceMakeSaleFutureStub>() {
        @java.lang.Override
        public serviceMakeSaleFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new serviceMakeSaleFutureStub(channel, callOptions);
        }
      };
    return serviceMakeSaleFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class serviceMakeSaleImplBase implements io.grpc.BindableService {

    /**
     */
    public void giveResponseMakeSale(generated.General.ClientPetitionMakeSale request,
        io.grpc.stub.StreamObserver<generated.General.ServerResponseMakeSale> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGiveResponseMakeSaleMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGiveResponseMakeSaleMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                generated.General.ClientPetitionMakeSale,
                generated.General.ServerResponseMakeSale>(
                  this, METHODID_GIVE_RESPONSE_MAKE_SALE)))
          .build();
    }
  }

  /**
   */
  public static final class serviceMakeSaleStub extends io.grpc.stub.AbstractAsyncStub<serviceMakeSaleStub> {
    private serviceMakeSaleStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected serviceMakeSaleStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new serviceMakeSaleStub(channel, callOptions);
    }

    /**
     */
    public void giveResponseMakeSale(generated.General.ClientPetitionMakeSale request,
        io.grpc.stub.StreamObserver<generated.General.ServerResponseMakeSale> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGiveResponseMakeSaleMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class serviceMakeSaleBlockingStub extends io.grpc.stub.AbstractBlockingStub<serviceMakeSaleBlockingStub> {
    private serviceMakeSaleBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected serviceMakeSaleBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new serviceMakeSaleBlockingStub(channel, callOptions);
    }

    /**
     */
    public generated.General.ServerResponseMakeSale giveResponseMakeSale(generated.General.ClientPetitionMakeSale request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGiveResponseMakeSaleMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class serviceMakeSaleFutureStub extends io.grpc.stub.AbstractFutureStub<serviceMakeSaleFutureStub> {
    private serviceMakeSaleFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected serviceMakeSaleFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new serviceMakeSaleFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<generated.General.ServerResponseMakeSale> giveResponseMakeSale(
        generated.General.ClientPetitionMakeSale request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGiveResponseMakeSaleMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GIVE_RESPONSE_MAKE_SALE = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final serviceMakeSaleImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(serviceMakeSaleImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GIVE_RESPONSE_MAKE_SALE:
          serviceImpl.giveResponseMakeSale((generated.General.ClientPetitionMakeSale) request,
              (io.grpc.stub.StreamObserver<generated.General.ServerResponseMakeSale>) responseObserver);
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

  private static abstract class serviceMakeSaleBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    serviceMakeSaleBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return generated.General.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("serviceMakeSale");
    }
  }

  private static final class serviceMakeSaleFileDescriptorSupplier
      extends serviceMakeSaleBaseDescriptorSupplier {
    serviceMakeSaleFileDescriptorSupplier() {}
  }

  private static final class serviceMakeSaleMethodDescriptorSupplier
      extends serviceMakeSaleBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    serviceMakeSaleMethodDescriptorSupplier(String methodName) {
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
      synchronized (serviceMakeSaleGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new serviceMakeSaleFileDescriptorSupplier())
              .addMethod(getGiveResponseMakeSaleMethod())
              .build();
        }
      }
    }
    return result;
  }
}
