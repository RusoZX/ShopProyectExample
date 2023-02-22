package generated;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.35.0)",
    comments = "Source: general.proto")
public final class serviceShoppingListGrpc {

  private serviceShoppingListGrpc() {}

  public static final String SERVICE_NAME = "generated.serviceShoppingList";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<generated.General.ClientPetitionShoppingList,
      generated.General.ServerResponseShoppingList> getGiveResponseShoppingListMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "giveResponseShoppingList",
      requestType = generated.General.ClientPetitionShoppingList.class,
      responseType = generated.General.ServerResponseShoppingList.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<generated.General.ClientPetitionShoppingList,
      generated.General.ServerResponseShoppingList> getGiveResponseShoppingListMethod() {
    io.grpc.MethodDescriptor<generated.General.ClientPetitionShoppingList, generated.General.ServerResponseShoppingList> getGiveResponseShoppingListMethod;
    if ((getGiveResponseShoppingListMethod = serviceShoppingListGrpc.getGiveResponseShoppingListMethod) == null) {
      synchronized (serviceShoppingListGrpc.class) {
        if ((getGiveResponseShoppingListMethod = serviceShoppingListGrpc.getGiveResponseShoppingListMethod) == null) {
          serviceShoppingListGrpc.getGiveResponseShoppingListMethod = getGiveResponseShoppingListMethod =
              io.grpc.MethodDescriptor.<generated.General.ClientPetitionShoppingList, generated.General.ServerResponseShoppingList>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "giveResponseShoppingList"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.General.ClientPetitionShoppingList.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.General.ServerResponseShoppingList.getDefaultInstance()))
              .setSchemaDescriptor(new serviceShoppingListMethodDescriptorSupplier("giveResponseShoppingList"))
              .build();
        }
      }
    }
    return getGiveResponseShoppingListMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static serviceShoppingListStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<serviceShoppingListStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<serviceShoppingListStub>() {
        @java.lang.Override
        public serviceShoppingListStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new serviceShoppingListStub(channel, callOptions);
        }
      };
    return serviceShoppingListStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static serviceShoppingListBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<serviceShoppingListBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<serviceShoppingListBlockingStub>() {
        @java.lang.Override
        public serviceShoppingListBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new serviceShoppingListBlockingStub(channel, callOptions);
        }
      };
    return serviceShoppingListBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static serviceShoppingListFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<serviceShoppingListFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<serviceShoppingListFutureStub>() {
        @java.lang.Override
        public serviceShoppingListFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new serviceShoppingListFutureStub(channel, callOptions);
        }
      };
    return serviceShoppingListFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class serviceShoppingListImplBase implements io.grpc.BindableService {

    /**
     */
    public void giveResponseShoppingList(generated.General.ClientPetitionShoppingList request,
        io.grpc.stub.StreamObserver<generated.General.ServerResponseShoppingList> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGiveResponseShoppingListMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGiveResponseShoppingListMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                generated.General.ClientPetitionShoppingList,
                generated.General.ServerResponseShoppingList>(
                  this, METHODID_GIVE_RESPONSE_SHOPPING_LIST)))
          .build();
    }
  }

  /**
   */
  public static final class serviceShoppingListStub extends io.grpc.stub.AbstractAsyncStub<serviceShoppingListStub> {
    private serviceShoppingListStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected serviceShoppingListStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new serviceShoppingListStub(channel, callOptions);
    }

    /**
     */
    public void giveResponseShoppingList(generated.General.ClientPetitionShoppingList request,
        io.grpc.stub.StreamObserver<generated.General.ServerResponseShoppingList> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGiveResponseShoppingListMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class serviceShoppingListBlockingStub extends io.grpc.stub.AbstractBlockingStub<serviceShoppingListBlockingStub> {
    private serviceShoppingListBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected serviceShoppingListBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new serviceShoppingListBlockingStub(channel, callOptions);
    }

    /**
     */
    public generated.General.ServerResponseShoppingList giveResponseShoppingList(generated.General.ClientPetitionShoppingList request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGiveResponseShoppingListMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class serviceShoppingListFutureStub extends io.grpc.stub.AbstractFutureStub<serviceShoppingListFutureStub> {
    private serviceShoppingListFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected serviceShoppingListFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new serviceShoppingListFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<generated.General.ServerResponseShoppingList> giveResponseShoppingList(
        generated.General.ClientPetitionShoppingList request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGiveResponseShoppingListMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GIVE_RESPONSE_SHOPPING_LIST = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final serviceShoppingListImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(serviceShoppingListImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GIVE_RESPONSE_SHOPPING_LIST:
          serviceImpl.giveResponseShoppingList((generated.General.ClientPetitionShoppingList) request,
              (io.grpc.stub.StreamObserver<generated.General.ServerResponseShoppingList>) responseObserver);
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

  private static abstract class serviceShoppingListBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    serviceShoppingListBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return generated.General.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("serviceShoppingList");
    }
  }

  private static final class serviceShoppingListFileDescriptorSupplier
      extends serviceShoppingListBaseDescriptorSupplier {
    serviceShoppingListFileDescriptorSupplier() {}
  }

  private static final class serviceShoppingListMethodDescriptorSupplier
      extends serviceShoppingListBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    serviceShoppingListMethodDescriptorSupplier(String methodName) {
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
      synchronized (serviceShoppingListGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new serviceShoppingListFileDescriptorSupplier())
              .addMethod(getGiveResponseShoppingListMethod())
              .build();
        }
      }
    }
    return result;
  }
}
