package generated;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.35.0)",
    comments = "Source: general.proto")
public final class serviceAddShoppingListGrpc {

  private serviceAddShoppingListGrpc() {}

  public static final String SERVICE_NAME = "generated.serviceAddShoppingList";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<generated.General.ClientPetitionAddShoppingList,
      generated.General.ServerResponseAddShoppingList> getGiveResponseAddShoppingListMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "giveResponseAddShoppingList",
      requestType = generated.General.ClientPetitionAddShoppingList.class,
      responseType = generated.General.ServerResponseAddShoppingList.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<generated.General.ClientPetitionAddShoppingList,
      generated.General.ServerResponseAddShoppingList> getGiveResponseAddShoppingListMethod() {
    io.grpc.MethodDescriptor<generated.General.ClientPetitionAddShoppingList, generated.General.ServerResponseAddShoppingList> getGiveResponseAddShoppingListMethod;
    if ((getGiveResponseAddShoppingListMethod = serviceAddShoppingListGrpc.getGiveResponseAddShoppingListMethod) == null) {
      synchronized (serviceAddShoppingListGrpc.class) {
        if ((getGiveResponseAddShoppingListMethod = serviceAddShoppingListGrpc.getGiveResponseAddShoppingListMethod) == null) {
          serviceAddShoppingListGrpc.getGiveResponseAddShoppingListMethod = getGiveResponseAddShoppingListMethod =
              io.grpc.MethodDescriptor.<generated.General.ClientPetitionAddShoppingList, generated.General.ServerResponseAddShoppingList>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "giveResponseAddShoppingList"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.General.ClientPetitionAddShoppingList.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.General.ServerResponseAddShoppingList.getDefaultInstance()))
              .setSchemaDescriptor(new serviceAddShoppingListMethodDescriptorSupplier("giveResponseAddShoppingList"))
              .build();
        }
      }
    }
    return getGiveResponseAddShoppingListMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static serviceAddShoppingListStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<serviceAddShoppingListStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<serviceAddShoppingListStub>() {
        @java.lang.Override
        public serviceAddShoppingListStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new serviceAddShoppingListStub(channel, callOptions);
        }
      };
    return serviceAddShoppingListStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static serviceAddShoppingListBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<serviceAddShoppingListBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<serviceAddShoppingListBlockingStub>() {
        @java.lang.Override
        public serviceAddShoppingListBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new serviceAddShoppingListBlockingStub(channel, callOptions);
        }
      };
    return serviceAddShoppingListBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static serviceAddShoppingListFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<serviceAddShoppingListFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<serviceAddShoppingListFutureStub>() {
        @java.lang.Override
        public serviceAddShoppingListFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new serviceAddShoppingListFutureStub(channel, callOptions);
        }
      };
    return serviceAddShoppingListFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class serviceAddShoppingListImplBase implements io.grpc.BindableService {

    /**
     */
    public void giveResponseAddShoppingList(generated.General.ClientPetitionAddShoppingList request,
        io.grpc.stub.StreamObserver<generated.General.ServerResponseAddShoppingList> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGiveResponseAddShoppingListMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGiveResponseAddShoppingListMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                generated.General.ClientPetitionAddShoppingList,
                generated.General.ServerResponseAddShoppingList>(
                  this, METHODID_GIVE_RESPONSE_ADD_SHOPPING_LIST)))
          .build();
    }
  }

  /**
   */
  public static final class serviceAddShoppingListStub extends io.grpc.stub.AbstractAsyncStub<serviceAddShoppingListStub> {
    private serviceAddShoppingListStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected serviceAddShoppingListStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new serviceAddShoppingListStub(channel, callOptions);
    }

    /**
     */
    public void giveResponseAddShoppingList(generated.General.ClientPetitionAddShoppingList request,
        io.grpc.stub.StreamObserver<generated.General.ServerResponseAddShoppingList> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGiveResponseAddShoppingListMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class serviceAddShoppingListBlockingStub extends io.grpc.stub.AbstractBlockingStub<serviceAddShoppingListBlockingStub> {
    private serviceAddShoppingListBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected serviceAddShoppingListBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new serviceAddShoppingListBlockingStub(channel, callOptions);
    }

    /**
     */
    public generated.General.ServerResponseAddShoppingList giveResponseAddShoppingList(generated.General.ClientPetitionAddShoppingList request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGiveResponseAddShoppingListMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class serviceAddShoppingListFutureStub extends io.grpc.stub.AbstractFutureStub<serviceAddShoppingListFutureStub> {
    private serviceAddShoppingListFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected serviceAddShoppingListFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new serviceAddShoppingListFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<generated.General.ServerResponseAddShoppingList> giveResponseAddShoppingList(
        generated.General.ClientPetitionAddShoppingList request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGiveResponseAddShoppingListMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GIVE_RESPONSE_ADD_SHOPPING_LIST = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final serviceAddShoppingListImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(serviceAddShoppingListImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GIVE_RESPONSE_ADD_SHOPPING_LIST:
          serviceImpl.giveResponseAddShoppingList((generated.General.ClientPetitionAddShoppingList) request,
              (io.grpc.stub.StreamObserver<generated.General.ServerResponseAddShoppingList>) responseObserver);
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

  private static abstract class serviceAddShoppingListBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    serviceAddShoppingListBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return generated.General.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("serviceAddShoppingList");
    }
  }

  private static final class serviceAddShoppingListFileDescriptorSupplier
      extends serviceAddShoppingListBaseDescriptorSupplier {
    serviceAddShoppingListFileDescriptorSupplier() {}
  }

  private static final class serviceAddShoppingListMethodDescriptorSupplier
      extends serviceAddShoppingListBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    serviceAddShoppingListMethodDescriptorSupplier(String methodName) {
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
      synchronized (serviceAddShoppingListGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new serviceAddShoppingListFileDescriptorSupplier())
              .addMethod(getGiveResponseAddShoppingListMethod())
              .build();
        }
      }
    }
    return result;
  }
}
