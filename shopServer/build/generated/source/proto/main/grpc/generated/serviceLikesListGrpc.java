package generated;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.35.0)",
    comments = "Source: general.proto")
public final class serviceLikesListGrpc {

  private serviceLikesListGrpc() {}

  public static final String SERVICE_NAME = "generated.serviceLikesList";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<generated.General.ClientPetitionLikesList,
      generated.General.ServerResponseLikesList> getGiveResponseLikesListMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "giveResponseLikesList",
      requestType = generated.General.ClientPetitionLikesList.class,
      responseType = generated.General.ServerResponseLikesList.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<generated.General.ClientPetitionLikesList,
      generated.General.ServerResponseLikesList> getGiveResponseLikesListMethod() {
    io.grpc.MethodDescriptor<generated.General.ClientPetitionLikesList, generated.General.ServerResponseLikesList> getGiveResponseLikesListMethod;
    if ((getGiveResponseLikesListMethod = serviceLikesListGrpc.getGiveResponseLikesListMethod) == null) {
      synchronized (serviceLikesListGrpc.class) {
        if ((getGiveResponseLikesListMethod = serviceLikesListGrpc.getGiveResponseLikesListMethod) == null) {
          serviceLikesListGrpc.getGiveResponseLikesListMethod = getGiveResponseLikesListMethod =
              io.grpc.MethodDescriptor.<generated.General.ClientPetitionLikesList, generated.General.ServerResponseLikesList>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "giveResponseLikesList"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.General.ClientPetitionLikesList.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.General.ServerResponseLikesList.getDefaultInstance()))
              .setSchemaDescriptor(new serviceLikesListMethodDescriptorSupplier("giveResponseLikesList"))
              .build();
        }
      }
    }
    return getGiveResponseLikesListMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static serviceLikesListStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<serviceLikesListStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<serviceLikesListStub>() {
        @java.lang.Override
        public serviceLikesListStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new serviceLikesListStub(channel, callOptions);
        }
      };
    return serviceLikesListStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static serviceLikesListBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<serviceLikesListBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<serviceLikesListBlockingStub>() {
        @java.lang.Override
        public serviceLikesListBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new serviceLikesListBlockingStub(channel, callOptions);
        }
      };
    return serviceLikesListBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static serviceLikesListFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<serviceLikesListFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<serviceLikesListFutureStub>() {
        @java.lang.Override
        public serviceLikesListFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new serviceLikesListFutureStub(channel, callOptions);
        }
      };
    return serviceLikesListFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class serviceLikesListImplBase implements io.grpc.BindableService {

    /**
     */
    public void giveResponseLikesList(generated.General.ClientPetitionLikesList request,
        io.grpc.stub.StreamObserver<generated.General.ServerResponseLikesList> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGiveResponseLikesListMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGiveResponseLikesListMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                generated.General.ClientPetitionLikesList,
                generated.General.ServerResponseLikesList>(
                  this, METHODID_GIVE_RESPONSE_LIKES_LIST)))
          .build();
    }
  }

  /**
   */
  public static final class serviceLikesListStub extends io.grpc.stub.AbstractAsyncStub<serviceLikesListStub> {
    private serviceLikesListStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected serviceLikesListStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new serviceLikesListStub(channel, callOptions);
    }

    /**
     */
    public void giveResponseLikesList(generated.General.ClientPetitionLikesList request,
        io.grpc.stub.StreamObserver<generated.General.ServerResponseLikesList> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGiveResponseLikesListMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class serviceLikesListBlockingStub extends io.grpc.stub.AbstractBlockingStub<serviceLikesListBlockingStub> {
    private serviceLikesListBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected serviceLikesListBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new serviceLikesListBlockingStub(channel, callOptions);
    }

    /**
     */
    public generated.General.ServerResponseLikesList giveResponseLikesList(generated.General.ClientPetitionLikesList request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGiveResponseLikesListMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class serviceLikesListFutureStub extends io.grpc.stub.AbstractFutureStub<serviceLikesListFutureStub> {
    private serviceLikesListFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected serviceLikesListFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new serviceLikesListFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<generated.General.ServerResponseLikesList> giveResponseLikesList(
        generated.General.ClientPetitionLikesList request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGiveResponseLikesListMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GIVE_RESPONSE_LIKES_LIST = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final serviceLikesListImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(serviceLikesListImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GIVE_RESPONSE_LIKES_LIST:
          serviceImpl.giveResponseLikesList((generated.General.ClientPetitionLikesList) request,
              (io.grpc.stub.StreamObserver<generated.General.ServerResponseLikesList>) responseObserver);
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

  private static abstract class serviceLikesListBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    serviceLikesListBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return generated.General.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("serviceLikesList");
    }
  }

  private static final class serviceLikesListFileDescriptorSupplier
      extends serviceLikesListBaseDescriptorSupplier {
    serviceLikesListFileDescriptorSupplier() {}
  }

  private static final class serviceLikesListMethodDescriptorSupplier
      extends serviceLikesListBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    serviceLikesListMethodDescriptorSupplier(String methodName) {
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
      synchronized (serviceLikesListGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new serviceLikesListFileDescriptorSupplier())
              .addMethod(getGiveResponseLikesListMethod())
              .build();
        }
      }
    }
    return result;
  }
}
