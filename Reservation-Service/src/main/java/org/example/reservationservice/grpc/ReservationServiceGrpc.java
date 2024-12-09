package org.example.reservationservice.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: reservation.proto")
public final class ReservationServiceGrpc {

  private ReservationServiceGrpc() {}

  public static final String SERVICE_NAME = "ReservationService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<org.example.reservationservice.grpc.ReservationServiceProto.CreateReservationRequest,
      org.example.reservationservice.grpc.ReservationServiceProto.MessageResponse> getCreateReservationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateReservation",
      requestType = org.example.reservationservice.grpc.ReservationServiceProto.CreateReservationRequest.class,
      responseType = org.example.reservationservice.grpc.ReservationServiceProto.MessageResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.example.reservationservice.grpc.ReservationServiceProto.CreateReservationRequest,
      org.example.reservationservice.grpc.ReservationServiceProto.MessageResponse> getCreateReservationMethod() {
    io.grpc.MethodDescriptor<org.example.reservationservice.grpc.ReservationServiceProto.CreateReservationRequest, org.example.reservationservice.grpc.ReservationServiceProto.MessageResponse> getCreateReservationMethod;
    if ((getCreateReservationMethod = ReservationServiceGrpc.getCreateReservationMethod) == null) {
      synchronized (ReservationServiceGrpc.class) {
        if ((getCreateReservationMethod = ReservationServiceGrpc.getCreateReservationMethod) == null) {
          ReservationServiceGrpc.getCreateReservationMethod = getCreateReservationMethod = 
              io.grpc.MethodDescriptor.<org.example.reservationservice.grpc.ReservationServiceProto.CreateReservationRequest, org.example.reservationservice.grpc.ReservationServiceProto.MessageResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "ReservationService", "CreateReservation"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.reservationservice.grpc.ReservationServiceProto.CreateReservationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.reservationservice.grpc.ReservationServiceProto.MessageResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ReservationServiceMethodDescriptorSupplier("CreateReservation"))
                  .build();
          }
        }
     }
     return getCreateReservationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.example.reservationservice.grpc.ReservationServiceProto.UpdateReservationRequest,
      org.example.reservationservice.grpc.ReservationServiceProto.MessageResponse> getUpdateReservationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateReservation",
      requestType = org.example.reservationservice.grpc.ReservationServiceProto.UpdateReservationRequest.class,
      responseType = org.example.reservationservice.grpc.ReservationServiceProto.MessageResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.example.reservationservice.grpc.ReservationServiceProto.UpdateReservationRequest,
      org.example.reservationservice.grpc.ReservationServiceProto.MessageResponse> getUpdateReservationMethod() {
    io.grpc.MethodDescriptor<org.example.reservationservice.grpc.ReservationServiceProto.UpdateReservationRequest, org.example.reservationservice.grpc.ReservationServiceProto.MessageResponse> getUpdateReservationMethod;
    if ((getUpdateReservationMethod = ReservationServiceGrpc.getUpdateReservationMethod) == null) {
      synchronized (ReservationServiceGrpc.class) {
        if ((getUpdateReservationMethod = ReservationServiceGrpc.getUpdateReservationMethod) == null) {
          ReservationServiceGrpc.getUpdateReservationMethod = getUpdateReservationMethod = 
              io.grpc.MethodDescriptor.<org.example.reservationservice.grpc.ReservationServiceProto.UpdateReservationRequest, org.example.reservationservice.grpc.ReservationServiceProto.MessageResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "ReservationService", "UpdateReservation"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.reservationservice.grpc.ReservationServiceProto.UpdateReservationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.reservationservice.grpc.ReservationServiceProto.MessageResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ReservationServiceMethodDescriptorSupplier("UpdateReservation"))
                  .build();
          }
        }
     }
     return getUpdateReservationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.example.reservationservice.grpc.ReservationServiceProto.DeleteReservationRequest,
      org.example.reservationservice.grpc.ReservationServiceProto.MessageResponse> getDeleteReservationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteReservation",
      requestType = org.example.reservationservice.grpc.ReservationServiceProto.DeleteReservationRequest.class,
      responseType = org.example.reservationservice.grpc.ReservationServiceProto.MessageResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.example.reservationservice.grpc.ReservationServiceProto.DeleteReservationRequest,
      org.example.reservationservice.grpc.ReservationServiceProto.MessageResponse> getDeleteReservationMethod() {
    io.grpc.MethodDescriptor<org.example.reservationservice.grpc.ReservationServiceProto.DeleteReservationRequest, org.example.reservationservice.grpc.ReservationServiceProto.MessageResponse> getDeleteReservationMethod;
    if ((getDeleteReservationMethod = ReservationServiceGrpc.getDeleteReservationMethod) == null) {
      synchronized (ReservationServiceGrpc.class) {
        if ((getDeleteReservationMethod = ReservationServiceGrpc.getDeleteReservationMethod) == null) {
          ReservationServiceGrpc.getDeleteReservationMethod = getDeleteReservationMethod = 
              io.grpc.MethodDescriptor.<org.example.reservationservice.grpc.ReservationServiceProto.DeleteReservationRequest, org.example.reservationservice.grpc.ReservationServiceProto.MessageResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "ReservationService", "DeleteReservation"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.reservationservice.grpc.ReservationServiceProto.DeleteReservationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.reservationservice.grpc.ReservationServiceProto.MessageResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ReservationServiceMethodDescriptorSupplier("DeleteReservation"))
                  .build();
          }
        }
     }
     return getDeleteReservationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.example.reservationservice.grpc.ReservationServiceProto.ReservationByIdRequest,
      org.example.reservationservice.grpc.ReservationServiceProto.ReservationResponse> getGetReservationByIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetReservationById",
      requestType = org.example.reservationservice.grpc.ReservationServiceProto.ReservationByIdRequest.class,
      responseType = org.example.reservationservice.grpc.ReservationServiceProto.ReservationResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.example.reservationservice.grpc.ReservationServiceProto.ReservationByIdRequest,
      org.example.reservationservice.grpc.ReservationServiceProto.ReservationResponse> getGetReservationByIdMethod() {
    io.grpc.MethodDescriptor<org.example.reservationservice.grpc.ReservationServiceProto.ReservationByIdRequest, org.example.reservationservice.grpc.ReservationServiceProto.ReservationResponse> getGetReservationByIdMethod;
    if ((getGetReservationByIdMethod = ReservationServiceGrpc.getGetReservationByIdMethod) == null) {
      synchronized (ReservationServiceGrpc.class) {
        if ((getGetReservationByIdMethod = ReservationServiceGrpc.getGetReservationByIdMethod) == null) {
          ReservationServiceGrpc.getGetReservationByIdMethod = getGetReservationByIdMethod = 
              io.grpc.MethodDescriptor.<org.example.reservationservice.grpc.ReservationServiceProto.ReservationByIdRequest, org.example.reservationservice.grpc.ReservationServiceProto.ReservationResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "ReservationService", "GetReservationById"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.reservationservice.grpc.ReservationServiceProto.ReservationByIdRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.reservationservice.grpc.ReservationServiceProto.ReservationResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ReservationServiceMethodDescriptorSupplier("GetReservationById"))
                  .build();
          }
        }
     }
     return getGetReservationByIdMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.example.reservationservice.grpc.ReservationServiceProto.ReservationByUserIdRequest,
      org.example.reservationservice.grpc.ReservationServiceProto.ReservationResponse> getGetReservationByUserIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetReservationByUserId",
      requestType = org.example.reservationservice.grpc.ReservationServiceProto.ReservationByUserIdRequest.class,
      responseType = org.example.reservationservice.grpc.ReservationServiceProto.ReservationResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.example.reservationservice.grpc.ReservationServiceProto.ReservationByUserIdRequest,
      org.example.reservationservice.grpc.ReservationServiceProto.ReservationResponse> getGetReservationByUserIdMethod() {
    io.grpc.MethodDescriptor<org.example.reservationservice.grpc.ReservationServiceProto.ReservationByUserIdRequest, org.example.reservationservice.grpc.ReservationServiceProto.ReservationResponse> getGetReservationByUserIdMethod;
    if ((getGetReservationByUserIdMethod = ReservationServiceGrpc.getGetReservationByUserIdMethod) == null) {
      synchronized (ReservationServiceGrpc.class) {
        if ((getGetReservationByUserIdMethod = ReservationServiceGrpc.getGetReservationByUserIdMethod) == null) {
          ReservationServiceGrpc.getGetReservationByUserIdMethod = getGetReservationByUserIdMethod = 
              io.grpc.MethodDescriptor.<org.example.reservationservice.grpc.ReservationServiceProto.ReservationByUserIdRequest, org.example.reservationservice.grpc.ReservationServiceProto.ReservationResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "ReservationService", "GetReservationByUserId"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.reservationservice.grpc.ReservationServiceProto.ReservationByUserIdRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.reservationservice.grpc.ReservationServiceProto.ReservationResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ReservationServiceMethodDescriptorSupplier("GetReservationByUserId"))
                  .build();
          }
        }
     }
     return getGetReservationByUserIdMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.example.reservationservice.grpc.ReservationServiceProto.ReservationByChambreIdRequest,
      org.example.reservationservice.grpc.ReservationServiceProto.ReservationResponse> getGetReservationByChambreIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetReservationByChambreId",
      requestType = org.example.reservationservice.grpc.ReservationServiceProto.ReservationByChambreIdRequest.class,
      responseType = org.example.reservationservice.grpc.ReservationServiceProto.ReservationResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.example.reservationservice.grpc.ReservationServiceProto.ReservationByChambreIdRequest,
      org.example.reservationservice.grpc.ReservationServiceProto.ReservationResponse> getGetReservationByChambreIdMethod() {
    io.grpc.MethodDescriptor<org.example.reservationservice.grpc.ReservationServiceProto.ReservationByChambreIdRequest, org.example.reservationservice.grpc.ReservationServiceProto.ReservationResponse> getGetReservationByChambreIdMethod;
    if ((getGetReservationByChambreIdMethod = ReservationServiceGrpc.getGetReservationByChambreIdMethod) == null) {
      synchronized (ReservationServiceGrpc.class) {
        if ((getGetReservationByChambreIdMethod = ReservationServiceGrpc.getGetReservationByChambreIdMethod) == null) {
          ReservationServiceGrpc.getGetReservationByChambreIdMethod = getGetReservationByChambreIdMethod = 
              io.grpc.MethodDescriptor.<org.example.reservationservice.grpc.ReservationServiceProto.ReservationByChambreIdRequest, org.example.reservationservice.grpc.ReservationServiceProto.ReservationResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "ReservationService", "GetReservationByChambreId"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.reservationservice.grpc.ReservationServiceProto.ReservationByChambreIdRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.reservationservice.grpc.ReservationServiceProto.ReservationResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ReservationServiceMethodDescriptorSupplier("GetReservationByChambreId"))
                  .build();
          }
        }
     }
     return getGetReservationByChambreIdMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.example.reservationservice.grpc.ReservationServiceProto.ReservationByDate_DebutRequest,
      org.example.reservationservice.grpc.ReservationServiceProto.ReservationsResponse> getGetReservationByDateDebutMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetReservationByDate_Debut",
      requestType = org.example.reservationservice.grpc.ReservationServiceProto.ReservationByDate_DebutRequest.class,
      responseType = org.example.reservationservice.grpc.ReservationServiceProto.ReservationsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.example.reservationservice.grpc.ReservationServiceProto.ReservationByDate_DebutRequest,
      org.example.reservationservice.grpc.ReservationServiceProto.ReservationsResponse> getGetReservationByDateDebutMethod() {
    io.grpc.MethodDescriptor<org.example.reservationservice.grpc.ReservationServiceProto.ReservationByDate_DebutRequest, org.example.reservationservice.grpc.ReservationServiceProto.ReservationsResponse> getGetReservationByDateDebutMethod;
    if ((getGetReservationByDateDebutMethod = ReservationServiceGrpc.getGetReservationByDateDebutMethod) == null) {
      synchronized (ReservationServiceGrpc.class) {
        if ((getGetReservationByDateDebutMethod = ReservationServiceGrpc.getGetReservationByDateDebutMethod) == null) {
          ReservationServiceGrpc.getGetReservationByDateDebutMethod = getGetReservationByDateDebutMethod = 
              io.grpc.MethodDescriptor.<org.example.reservationservice.grpc.ReservationServiceProto.ReservationByDate_DebutRequest, org.example.reservationservice.grpc.ReservationServiceProto.ReservationsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "ReservationService", "GetReservationByDate_Debut"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.reservationservice.grpc.ReservationServiceProto.ReservationByDate_DebutRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.reservationservice.grpc.ReservationServiceProto.ReservationsResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ReservationServiceMethodDescriptorSupplier("GetReservationByDate_Debut"))
                  .build();
          }
        }
     }
     return getGetReservationByDateDebutMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.example.reservationservice.grpc.ReservationServiceProto.Empty,
      org.example.reservationservice.grpc.ReservationServiceProto.ReservationsResponse> getGetAllReservationsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAllReservations",
      requestType = org.example.reservationservice.grpc.ReservationServiceProto.Empty.class,
      responseType = org.example.reservationservice.grpc.ReservationServiceProto.ReservationsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.example.reservationservice.grpc.ReservationServiceProto.Empty,
      org.example.reservationservice.grpc.ReservationServiceProto.ReservationsResponse> getGetAllReservationsMethod() {
    io.grpc.MethodDescriptor<org.example.reservationservice.grpc.ReservationServiceProto.Empty, org.example.reservationservice.grpc.ReservationServiceProto.ReservationsResponse> getGetAllReservationsMethod;
    if ((getGetAllReservationsMethod = ReservationServiceGrpc.getGetAllReservationsMethod) == null) {
      synchronized (ReservationServiceGrpc.class) {
        if ((getGetAllReservationsMethod = ReservationServiceGrpc.getGetAllReservationsMethod) == null) {
          ReservationServiceGrpc.getGetAllReservationsMethod = getGetAllReservationsMethod = 
              io.grpc.MethodDescriptor.<org.example.reservationservice.grpc.ReservationServiceProto.Empty, org.example.reservationservice.grpc.ReservationServiceProto.ReservationsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "ReservationService", "GetAllReservations"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.reservationservice.grpc.ReservationServiceProto.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.reservationservice.grpc.ReservationServiceProto.ReservationsResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ReservationServiceMethodDescriptorSupplier("GetAllReservations"))
                  .build();
          }
        }
     }
     return getGetAllReservationsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ReservationServiceStub newStub(io.grpc.Channel channel) {
    return new ReservationServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ReservationServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ReservationServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ReservationServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ReservationServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class ReservationServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void createReservation(org.example.reservationservice.grpc.ReservationServiceProto.CreateReservationRequest request,
        io.grpc.stub.StreamObserver<org.example.reservationservice.grpc.ReservationServiceProto.MessageResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateReservationMethod(), responseObserver);
    }

    /**
     */
    public void updateReservation(org.example.reservationservice.grpc.ReservationServiceProto.UpdateReservationRequest request,
        io.grpc.stub.StreamObserver<org.example.reservationservice.grpc.ReservationServiceProto.MessageResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateReservationMethod(), responseObserver);
    }

    /**
     */
    public void deleteReservation(org.example.reservationservice.grpc.ReservationServiceProto.DeleteReservationRequest request,
        io.grpc.stub.StreamObserver<org.example.reservationservice.grpc.ReservationServiceProto.MessageResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteReservationMethod(), responseObserver);
    }

    /**
     */
    public void getReservationById(org.example.reservationservice.grpc.ReservationServiceProto.ReservationByIdRequest request,
        io.grpc.stub.StreamObserver<org.example.reservationservice.grpc.ReservationServiceProto.ReservationResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetReservationByIdMethod(), responseObserver);
    }

    /**
     */
    public void getReservationByUserId(org.example.reservationservice.grpc.ReservationServiceProto.ReservationByUserIdRequest request,
        io.grpc.stub.StreamObserver<org.example.reservationservice.grpc.ReservationServiceProto.ReservationResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetReservationByUserIdMethod(), responseObserver);
    }

    /**
     */
    public void getReservationByChambreId(org.example.reservationservice.grpc.ReservationServiceProto.ReservationByChambreIdRequest request,
        io.grpc.stub.StreamObserver<org.example.reservationservice.grpc.ReservationServiceProto.ReservationResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetReservationByChambreIdMethod(), responseObserver);
    }

    /**
     */
    public void getReservationByDateDebut(org.example.reservationservice.grpc.ReservationServiceProto.ReservationByDate_DebutRequest request,
        io.grpc.stub.StreamObserver<org.example.reservationservice.grpc.ReservationServiceProto.ReservationsResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetReservationByDateDebutMethod(), responseObserver);
    }

    /**
     */
    public void getAllReservations(org.example.reservationservice.grpc.ReservationServiceProto.Empty request,
        io.grpc.stub.StreamObserver<org.example.reservationservice.grpc.ReservationServiceProto.ReservationsResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetAllReservationsMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateReservationMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.example.reservationservice.grpc.ReservationServiceProto.CreateReservationRequest,
                org.example.reservationservice.grpc.ReservationServiceProto.MessageResponse>(
                  this, METHODID_CREATE_RESERVATION)))
          .addMethod(
            getUpdateReservationMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.example.reservationservice.grpc.ReservationServiceProto.UpdateReservationRequest,
                org.example.reservationservice.grpc.ReservationServiceProto.MessageResponse>(
                  this, METHODID_UPDATE_RESERVATION)))
          .addMethod(
            getDeleteReservationMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.example.reservationservice.grpc.ReservationServiceProto.DeleteReservationRequest,
                org.example.reservationservice.grpc.ReservationServiceProto.MessageResponse>(
                  this, METHODID_DELETE_RESERVATION)))
          .addMethod(
            getGetReservationByIdMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.example.reservationservice.grpc.ReservationServiceProto.ReservationByIdRequest,
                org.example.reservationservice.grpc.ReservationServiceProto.ReservationResponse>(
                  this, METHODID_GET_RESERVATION_BY_ID)))
          .addMethod(
            getGetReservationByUserIdMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.example.reservationservice.grpc.ReservationServiceProto.ReservationByUserIdRequest,
                org.example.reservationservice.grpc.ReservationServiceProto.ReservationResponse>(
                  this, METHODID_GET_RESERVATION_BY_USER_ID)))
          .addMethod(
            getGetReservationByChambreIdMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.example.reservationservice.grpc.ReservationServiceProto.ReservationByChambreIdRequest,
                org.example.reservationservice.grpc.ReservationServiceProto.ReservationResponse>(
                  this, METHODID_GET_RESERVATION_BY_CHAMBRE_ID)))
          .addMethod(
            getGetReservationByDateDebutMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.example.reservationservice.grpc.ReservationServiceProto.ReservationByDate_DebutRequest,
                org.example.reservationservice.grpc.ReservationServiceProto.ReservationsResponse>(
                  this, METHODID_GET_RESERVATION_BY_DATE_DEBUT)))
          .addMethod(
            getGetAllReservationsMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.example.reservationservice.grpc.ReservationServiceProto.Empty,
                org.example.reservationservice.grpc.ReservationServiceProto.ReservationsResponse>(
                  this, METHODID_GET_ALL_RESERVATIONS)))
          .build();
    }
  }

  /**
   */
  public static final class ReservationServiceStub extends io.grpc.stub.AbstractStub<ReservationServiceStub> {
    private ReservationServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ReservationServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ReservationServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ReservationServiceStub(channel, callOptions);
    }

    /**
     */
    public void createReservation(org.example.reservationservice.grpc.ReservationServiceProto.CreateReservationRequest request,
        io.grpc.stub.StreamObserver<org.example.reservationservice.grpc.ReservationServiceProto.MessageResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateReservationMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateReservation(org.example.reservationservice.grpc.ReservationServiceProto.UpdateReservationRequest request,
        io.grpc.stub.StreamObserver<org.example.reservationservice.grpc.ReservationServiceProto.MessageResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateReservationMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteReservation(org.example.reservationservice.grpc.ReservationServiceProto.DeleteReservationRequest request,
        io.grpc.stub.StreamObserver<org.example.reservationservice.grpc.ReservationServiceProto.MessageResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteReservationMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getReservationById(org.example.reservationservice.grpc.ReservationServiceProto.ReservationByIdRequest request,
        io.grpc.stub.StreamObserver<org.example.reservationservice.grpc.ReservationServiceProto.ReservationResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetReservationByIdMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getReservationByUserId(org.example.reservationservice.grpc.ReservationServiceProto.ReservationByUserIdRequest request,
        io.grpc.stub.StreamObserver<org.example.reservationservice.grpc.ReservationServiceProto.ReservationResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetReservationByUserIdMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getReservationByChambreId(org.example.reservationservice.grpc.ReservationServiceProto.ReservationByChambreIdRequest request,
        io.grpc.stub.StreamObserver<org.example.reservationservice.grpc.ReservationServiceProto.ReservationResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetReservationByChambreIdMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getReservationByDateDebut(org.example.reservationservice.grpc.ReservationServiceProto.ReservationByDate_DebutRequest request,
        io.grpc.stub.StreamObserver<org.example.reservationservice.grpc.ReservationServiceProto.ReservationsResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetReservationByDateDebutMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAllReservations(org.example.reservationservice.grpc.ReservationServiceProto.Empty request,
        io.grpc.stub.StreamObserver<org.example.reservationservice.grpc.ReservationServiceProto.ReservationsResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetAllReservationsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ReservationServiceBlockingStub extends io.grpc.stub.AbstractStub<ReservationServiceBlockingStub> {
    private ReservationServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ReservationServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ReservationServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ReservationServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public org.example.reservationservice.grpc.ReservationServiceProto.MessageResponse createReservation(org.example.reservationservice.grpc.ReservationServiceProto.CreateReservationRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateReservationMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.example.reservationservice.grpc.ReservationServiceProto.MessageResponse updateReservation(org.example.reservationservice.grpc.ReservationServiceProto.UpdateReservationRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateReservationMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.example.reservationservice.grpc.ReservationServiceProto.MessageResponse deleteReservation(org.example.reservationservice.grpc.ReservationServiceProto.DeleteReservationRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteReservationMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.example.reservationservice.grpc.ReservationServiceProto.ReservationResponse getReservationById(org.example.reservationservice.grpc.ReservationServiceProto.ReservationByIdRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetReservationByIdMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.example.reservationservice.grpc.ReservationServiceProto.ReservationResponse getReservationByUserId(org.example.reservationservice.grpc.ReservationServiceProto.ReservationByUserIdRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetReservationByUserIdMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.example.reservationservice.grpc.ReservationServiceProto.ReservationResponse getReservationByChambreId(org.example.reservationservice.grpc.ReservationServiceProto.ReservationByChambreIdRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetReservationByChambreIdMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.example.reservationservice.grpc.ReservationServiceProto.ReservationsResponse getReservationByDateDebut(org.example.reservationservice.grpc.ReservationServiceProto.ReservationByDate_DebutRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetReservationByDateDebutMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.example.reservationservice.grpc.ReservationServiceProto.ReservationsResponse getAllReservations(org.example.reservationservice.grpc.ReservationServiceProto.Empty request) {
      return blockingUnaryCall(
          getChannel(), getGetAllReservationsMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ReservationServiceFutureStub extends io.grpc.stub.AbstractStub<ReservationServiceFutureStub> {
    private ReservationServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ReservationServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ReservationServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ReservationServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.example.reservationservice.grpc.ReservationServiceProto.MessageResponse> createReservation(
        org.example.reservationservice.grpc.ReservationServiceProto.CreateReservationRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateReservationMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.example.reservationservice.grpc.ReservationServiceProto.MessageResponse> updateReservation(
        org.example.reservationservice.grpc.ReservationServiceProto.UpdateReservationRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateReservationMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.example.reservationservice.grpc.ReservationServiceProto.MessageResponse> deleteReservation(
        org.example.reservationservice.grpc.ReservationServiceProto.DeleteReservationRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteReservationMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.example.reservationservice.grpc.ReservationServiceProto.ReservationResponse> getReservationById(
        org.example.reservationservice.grpc.ReservationServiceProto.ReservationByIdRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetReservationByIdMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.example.reservationservice.grpc.ReservationServiceProto.ReservationResponse> getReservationByUserId(
        org.example.reservationservice.grpc.ReservationServiceProto.ReservationByUserIdRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetReservationByUserIdMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.example.reservationservice.grpc.ReservationServiceProto.ReservationResponse> getReservationByChambreId(
        org.example.reservationservice.grpc.ReservationServiceProto.ReservationByChambreIdRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetReservationByChambreIdMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.example.reservationservice.grpc.ReservationServiceProto.ReservationsResponse> getReservationByDateDebut(
        org.example.reservationservice.grpc.ReservationServiceProto.ReservationByDate_DebutRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetReservationByDateDebutMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.example.reservationservice.grpc.ReservationServiceProto.ReservationsResponse> getAllReservations(
        org.example.reservationservice.grpc.ReservationServiceProto.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(getGetAllReservationsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_RESERVATION = 0;
  private static final int METHODID_UPDATE_RESERVATION = 1;
  private static final int METHODID_DELETE_RESERVATION = 2;
  private static final int METHODID_GET_RESERVATION_BY_ID = 3;
  private static final int METHODID_GET_RESERVATION_BY_USER_ID = 4;
  private static final int METHODID_GET_RESERVATION_BY_CHAMBRE_ID = 5;
  private static final int METHODID_GET_RESERVATION_BY_DATE_DEBUT = 6;
  private static final int METHODID_GET_ALL_RESERVATIONS = 7;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ReservationServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ReservationServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_RESERVATION:
          serviceImpl.createReservation((org.example.reservationservice.grpc.ReservationServiceProto.CreateReservationRequest) request,
              (io.grpc.stub.StreamObserver<org.example.reservationservice.grpc.ReservationServiceProto.MessageResponse>) responseObserver);
          break;
        case METHODID_UPDATE_RESERVATION:
          serviceImpl.updateReservation((org.example.reservationservice.grpc.ReservationServiceProto.UpdateReservationRequest) request,
              (io.grpc.stub.StreamObserver<org.example.reservationservice.grpc.ReservationServiceProto.MessageResponse>) responseObserver);
          break;
        case METHODID_DELETE_RESERVATION:
          serviceImpl.deleteReservation((org.example.reservationservice.grpc.ReservationServiceProto.DeleteReservationRequest) request,
              (io.grpc.stub.StreamObserver<org.example.reservationservice.grpc.ReservationServiceProto.MessageResponse>) responseObserver);
          break;
        case METHODID_GET_RESERVATION_BY_ID:
          serviceImpl.getReservationById((org.example.reservationservice.grpc.ReservationServiceProto.ReservationByIdRequest) request,
              (io.grpc.stub.StreamObserver<org.example.reservationservice.grpc.ReservationServiceProto.ReservationResponse>) responseObserver);
          break;
        case METHODID_GET_RESERVATION_BY_USER_ID:
          serviceImpl.getReservationByUserId((org.example.reservationservice.grpc.ReservationServiceProto.ReservationByUserIdRequest) request,
              (io.grpc.stub.StreamObserver<org.example.reservationservice.grpc.ReservationServiceProto.ReservationResponse>) responseObserver);
          break;
        case METHODID_GET_RESERVATION_BY_CHAMBRE_ID:
          serviceImpl.getReservationByChambreId((org.example.reservationservice.grpc.ReservationServiceProto.ReservationByChambreIdRequest) request,
              (io.grpc.stub.StreamObserver<org.example.reservationservice.grpc.ReservationServiceProto.ReservationResponse>) responseObserver);
          break;
        case METHODID_GET_RESERVATION_BY_DATE_DEBUT:
          serviceImpl.getReservationByDateDebut((org.example.reservationservice.grpc.ReservationServiceProto.ReservationByDate_DebutRequest) request,
              (io.grpc.stub.StreamObserver<org.example.reservationservice.grpc.ReservationServiceProto.ReservationsResponse>) responseObserver);
          break;
        case METHODID_GET_ALL_RESERVATIONS:
          serviceImpl.getAllReservations((org.example.reservationservice.grpc.ReservationServiceProto.Empty) request,
              (io.grpc.stub.StreamObserver<org.example.reservationservice.grpc.ReservationServiceProto.ReservationsResponse>) responseObserver);
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

  private static abstract class ReservationServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ReservationServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return org.example.reservationservice.grpc.ReservationServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ReservationService");
    }
  }

  private static final class ReservationServiceFileDescriptorSupplier
      extends ReservationServiceBaseDescriptorSupplier {
    ReservationServiceFileDescriptorSupplier() {}
  }

  private static final class ReservationServiceMethodDescriptorSupplier
      extends ReservationServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ReservationServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (ReservationServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ReservationServiceFileDescriptorSupplier())
              .addMethod(getCreateReservationMethod())
              .addMethod(getUpdateReservationMethod())
              .addMethod(getDeleteReservationMethod())
              .addMethod(getGetReservationByIdMethod())
              .addMethod(getGetReservationByUserIdMethod())
              .addMethod(getGetReservationByChambreIdMethod())
              .addMethod(getGetReservationByDateDebutMethod())
              .addMethod(getGetAllReservationsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
