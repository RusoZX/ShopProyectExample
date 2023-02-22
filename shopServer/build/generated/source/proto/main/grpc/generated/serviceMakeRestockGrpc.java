package generated;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.35.0)",
    comments = "Source: general.proto")
public final class serviceMakeRestockGrpc {

  private serviceMakeRestockGrpc() {}

  public static final String SERVICE_NAME = "generated.serviceMakeRestock";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<generated.General.ClientPetitionMakeRestock,
      generated.General.ServerResponseMakeRestock> getGiveResponseMakeRestockMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "giveResponseMakeRestock",
      requestType = generated.General.ClientPetitionMakeRestock.class,
      responseType = generated.General.ServerResponseMakeRestock.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<generated.General.ClientPetitionMakeRestock,
      generated.General.ServerResponseMakeRestock> getGiveResponseMakeRestockMethod() {
    io.grpc.MethodDescriptor<generated.General.ClientPetitionMakeRestock, generated.General.ServerResponseMakeRestock> getGiveResponseMakeRestockMethod;
    if ((getGiveResponseMakeRestockMethod = serviceMakeRestockGrpc.getGiveResponseMakeRestockMethod) == null) {
      synchronized (serviceMakeRestockGrpc.class) {
        if ((getGiveResponseMakeRestockMethod = serviceMakeRestockGrpc.getGiveResponseMakeRestockMethod) == null) {
          serviceMakeRestockGrpc.getGiveResponseMakeRestockMethod = getGiveResponseMakeRestockMethod =
              io.grpc.MethodDescriptor.<generated.General.ClientPetitionMakeRestock, generated.General.ServerResponseMakeRestock>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "giveResponseMakeRestock"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.General.ClientPetitionMakeRestock.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.General.ServerResponseMakeRestock.getDefaultInstance()))
              .setSchemaDescriptor(new serviceMakeRestockMethodDescriptorSupplier("giveResponseMakeRestock"))
              .build();
        }
      }
    }
    return getGiveResponseMakeRestockMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static serviceMakeRestockStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<serviceMakeRestockStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<serviceMakeRestockStub>() {
        @java.lang.Override
        public serviceMakeRestockStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new serviceMakeRestockStub(channel, callOptions);
        }
      };
    return serviceMakeRestockStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static serviceMakeRestockBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<serviceMakeRestockBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<serviceMakeRestockBlockingStub>() {
        @java.lang.Override
        public serviceMakeRestockBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new serviceMakeRestockBlockingStub(channel, callOptions);
        }
      };
    return serviceMakeRestockBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static serviceMakeRestockFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<serviceMakeRestockFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<serviceMakeRestockFutureStub>() {
        @java.lang.Override
        public serviceMakeRestockFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new serviceMakeRestockFutureStub(channel, callOptions);
        }
      };
    return serviceMakeRestockFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class serviceMakeRestockImplBase implements io.grpc.BindableService {

    /**
     */
    public void giveResponseMakeRestock(generated.General.ClientPetitionMakeRestock request,
        io.grpc.stub.StreamObserver<generated.General.ServerResponseMakeRestock> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGiveResponseMakeRestockMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGiveResponseMakeRestockMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                generated.General.ClientPetitionMakeRestock,
                generated.General.ServerResponseMakeRestock>(
                  this, METHODID_GIVE_RESPONSE_MAKE_RESTOCK)))
          .build();
    }
  }

  /**
   */
  public static final class serviceMakeRestockStub extends io.grpc.stub.AbstractAsyncStub<serviceMakeRestockStub> {
    private serviceMakeRestockStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected serviceMakeRestockStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new serviceMakeRestockStub(channel, callOptions);
    }

    /**
     */
    public void giveResponseMakeRestock(generated.General.ClientPetitionMakeRestock request,
        io.grpc.stub.StreamObserver<generated.General.ServerResponseMakeRestock> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGiveResponseMakeRestockMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class serviceMakeRestockBlockingStub extends io.grpc.stub.AbstractBlockingStub<serviceMakeRestockBlockingStub> {
    private serviceMakeRestockBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected serviceMakeRestockBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new serviceMakeRestockBlockingStub(channel, callOptions);
    }

    /**
     */
    public generated.General.ServerResponseMakeRestock giveResponseMakeRestock(generated.General.ClientPetitionMakeRestock request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGiveResponseMakeRestockMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class serviceMakeRestockFutureStub extends io.grpc.stub.AbstractFutureStub<serviceMakeRestockFutureStub> {
    private serviceMakeRestockFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected serviceMakeRestockFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new serviceMakeRestockFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<generated.General.ServerResponseMakeRestock> giveResponseMakeRestock(
        generated.General.ClientPetitionMakeRestock request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGiveResponseMakeRestockMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GIVE_RESPONSE_MAKE_RESTOCK = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final serviceMakeRestockImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(serviceMakeRestockImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GIVE_RESPONSE_MAKE_RESTOCK:
          serviceImpl.giveResponseMakeRestock((generated.General.ClientPetitionMakeRestock) request,
              (io.grpc.stub.StreamObserver<generated.General.ServerResponseMakeRestock>) responseObserver);
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

  private static abstract class serviceMakeRestockBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    serviceMakeRestockBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return generated.General.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("serviceMakeRestock");
    }
  }

  private static final class serviceMakeRestockFileDescriptorSupplier
      extends serviceMakeRestockBaseDescriptorSupplier {
    serviceMakeRestockFileDescriptorSupplier() {}
  }

  private static final class serviceMakeRestockMethodDescriptorSupplier
      extends serviceMakeRestockBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    serviceMakeRestockMethodDescriptorSupplier(String methodName) {
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
      synchronized (serviceMakeRestockGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new serviceMakeRestockFileDescriptorSupplier())
              .addMethod(getGiveResponseMakeRestockMethod())
              .build();
        }
      }
    }
    return result;
  }
}
