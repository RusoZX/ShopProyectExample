package generated;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.35.0)",
    comments = "Source: general.proto")
public final class serviceCategoriesGrpc {

  private serviceCategoriesGrpc() {}

  public static final String SERVICE_NAME = "generated.serviceCategories";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<generated.General.ClientPetitionCategories,
      generated.General.ServerResponseCategories> getGiveResponseCategoriesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "giveResponseCategories",
      requestType = generated.General.ClientPetitionCategories.class,
      responseType = generated.General.ServerResponseCategories.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<generated.General.ClientPetitionCategories,
      generated.General.ServerResponseCategories> getGiveResponseCategoriesMethod() {
    io.grpc.MethodDescriptor<generated.General.ClientPetitionCategories, generated.General.ServerResponseCategories> getGiveResponseCategoriesMethod;
    if ((getGiveResponseCategoriesMethod = serviceCategoriesGrpc.getGiveResponseCategoriesMethod) == null) {
      synchronized (serviceCategoriesGrpc.class) {
        if ((getGiveResponseCategoriesMethod = serviceCategoriesGrpc.getGiveResponseCategoriesMethod) == null) {
          serviceCategoriesGrpc.getGiveResponseCategoriesMethod = getGiveResponseCategoriesMethod =
              io.grpc.MethodDescriptor.<generated.General.ClientPetitionCategories, generated.General.ServerResponseCategories>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "giveResponseCategories"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.General.ClientPetitionCategories.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.General.ServerResponseCategories.getDefaultInstance()))
              .setSchemaDescriptor(new serviceCategoriesMethodDescriptorSupplier("giveResponseCategories"))
              .build();
        }
      }
    }
    return getGiveResponseCategoriesMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static serviceCategoriesStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<serviceCategoriesStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<serviceCategoriesStub>() {
        @java.lang.Override
        public serviceCategoriesStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new serviceCategoriesStub(channel, callOptions);
        }
      };
    return serviceCategoriesStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static serviceCategoriesBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<serviceCategoriesBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<serviceCategoriesBlockingStub>() {
        @java.lang.Override
        public serviceCategoriesBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new serviceCategoriesBlockingStub(channel, callOptions);
        }
      };
    return serviceCategoriesBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static serviceCategoriesFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<serviceCategoriesFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<serviceCategoriesFutureStub>() {
        @java.lang.Override
        public serviceCategoriesFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new serviceCategoriesFutureStub(channel, callOptions);
        }
      };
    return serviceCategoriesFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class serviceCategoriesImplBase implements io.grpc.BindableService {

    /**
     */
    public void giveResponseCategories(generated.General.ClientPetitionCategories request,
        io.grpc.stub.StreamObserver<generated.General.ServerResponseCategories> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGiveResponseCategoriesMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGiveResponseCategoriesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                generated.General.ClientPetitionCategories,
                generated.General.ServerResponseCategories>(
                  this, METHODID_GIVE_RESPONSE_CATEGORIES)))
          .build();
    }
  }

  /**
   */
  public static final class serviceCategoriesStub extends io.grpc.stub.AbstractAsyncStub<serviceCategoriesStub> {
    private serviceCategoriesStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected serviceCategoriesStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new serviceCategoriesStub(channel, callOptions);
    }

    /**
     */
    public void giveResponseCategories(generated.General.ClientPetitionCategories request,
        io.grpc.stub.StreamObserver<generated.General.ServerResponseCategories> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGiveResponseCategoriesMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class serviceCategoriesBlockingStub extends io.grpc.stub.AbstractBlockingStub<serviceCategoriesBlockingStub> {
    private serviceCategoriesBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected serviceCategoriesBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new serviceCategoriesBlockingStub(channel, callOptions);
    }

    /**
     */
    public generated.General.ServerResponseCategories giveResponseCategories(generated.General.ClientPetitionCategories request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGiveResponseCategoriesMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class serviceCategoriesFutureStub extends io.grpc.stub.AbstractFutureStub<serviceCategoriesFutureStub> {
    private serviceCategoriesFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected serviceCategoriesFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new serviceCategoriesFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<generated.General.ServerResponseCategories> giveResponseCategories(
        generated.General.ClientPetitionCategories request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGiveResponseCategoriesMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GIVE_RESPONSE_CATEGORIES = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final serviceCategoriesImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(serviceCategoriesImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GIVE_RESPONSE_CATEGORIES:
          serviceImpl.giveResponseCategories((generated.General.ClientPetitionCategories) request,
              (io.grpc.stub.StreamObserver<generated.General.ServerResponseCategories>) responseObserver);
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

  private static abstract class serviceCategoriesBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    serviceCategoriesBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return generated.General.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("serviceCategories");
    }
  }

  private static final class serviceCategoriesFileDescriptorSupplier
      extends serviceCategoriesBaseDescriptorSupplier {
    serviceCategoriesFileDescriptorSupplier() {}
  }

  private static final class serviceCategoriesMethodDescriptorSupplier
      extends serviceCategoriesBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    serviceCategoriesMethodDescriptorSupplier(String methodName) {
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
      synchronized (serviceCategoriesGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new serviceCategoriesFileDescriptorSupplier())
              .addMethod(getGiveResponseCategoriesMethod())
              .build();
        }
      }
    }
    return result;
  }
}
