package com.sparrowwallet.sparrow.mweb.proto;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class RpcGrpc {

  private RpcGrpc() {}

  public static final java.lang.String SERVICE_NAME = "Rpc";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.sparrowwallet.sparrow.mweb.proto.StatusRequest,
      com.sparrowwallet.sparrow.mweb.proto.StatusResponse> getStatusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Status",
      requestType = com.sparrowwallet.sparrow.mweb.proto.StatusRequest.class,
      responseType = com.sparrowwallet.sparrow.mweb.proto.StatusResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.sparrowwallet.sparrow.mweb.proto.StatusRequest,
      com.sparrowwallet.sparrow.mweb.proto.StatusResponse> getStatusMethod() {
    io.grpc.MethodDescriptor<com.sparrowwallet.sparrow.mweb.proto.StatusRequest, com.sparrowwallet.sparrow.mweb.proto.StatusResponse> getStatusMethod;
    if ((getStatusMethod = RpcGrpc.getStatusMethod) == null) {
      synchronized (RpcGrpc.class) {
        if ((getStatusMethod = RpcGrpc.getStatusMethod) == null) {
          RpcGrpc.getStatusMethod = getStatusMethod =
              io.grpc.MethodDescriptor.<com.sparrowwallet.sparrow.mweb.proto.StatusRequest, com.sparrowwallet.sparrow.mweb.proto.StatusResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Status"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.sparrowwallet.sparrow.mweb.proto.StatusRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.sparrowwallet.sparrow.mweb.proto.StatusResponse.getDefaultInstance()))
              .setSchemaDescriptor(new RpcMethodDescriptorSupplier("Status"))
              .build();
        }
      }
    }
    return getStatusMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.sparrowwallet.sparrow.mweb.proto.UtxosRequest,
      com.sparrowwallet.sparrow.mweb.proto.Utxo> getUtxosMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Utxos",
      requestType = com.sparrowwallet.sparrow.mweb.proto.UtxosRequest.class,
      responseType = com.sparrowwallet.sparrow.mweb.proto.Utxo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.sparrowwallet.sparrow.mweb.proto.UtxosRequest,
      com.sparrowwallet.sparrow.mweb.proto.Utxo> getUtxosMethod() {
    io.grpc.MethodDescriptor<com.sparrowwallet.sparrow.mweb.proto.UtxosRequest, com.sparrowwallet.sparrow.mweb.proto.Utxo> getUtxosMethod;
    if ((getUtxosMethod = RpcGrpc.getUtxosMethod) == null) {
      synchronized (RpcGrpc.class) {
        if ((getUtxosMethod = RpcGrpc.getUtxosMethod) == null) {
          RpcGrpc.getUtxosMethod = getUtxosMethod =
              io.grpc.MethodDescriptor.<com.sparrowwallet.sparrow.mweb.proto.UtxosRequest, com.sparrowwallet.sparrow.mweb.proto.Utxo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Utxos"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.sparrowwallet.sparrow.mweb.proto.UtxosRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.sparrowwallet.sparrow.mweb.proto.Utxo.getDefaultInstance()))
              .setSchemaDescriptor(new RpcMethodDescriptorSupplier("Utxos"))
              .build();
        }
      }
    }
    return getUtxosMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.sparrowwallet.sparrow.mweb.proto.AddressRequest,
      com.sparrowwallet.sparrow.mweb.proto.AddressResponse> getAddressesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Addresses",
      requestType = com.sparrowwallet.sparrow.mweb.proto.AddressRequest.class,
      responseType = com.sparrowwallet.sparrow.mweb.proto.AddressResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.sparrowwallet.sparrow.mweb.proto.AddressRequest,
      com.sparrowwallet.sparrow.mweb.proto.AddressResponse> getAddressesMethod() {
    io.grpc.MethodDescriptor<com.sparrowwallet.sparrow.mweb.proto.AddressRequest, com.sparrowwallet.sparrow.mweb.proto.AddressResponse> getAddressesMethod;
    if ((getAddressesMethod = RpcGrpc.getAddressesMethod) == null) {
      synchronized (RpcGrpc.class) {
        if ((getAddressesMethod = RpcGrpc.getAddressesMethod) == null) {
          RpcGrpc.getAddressesMethod = getAddressesMethod =
              io.grpc.MethodDescriptor.<com.sparrowwallet.sparrow.mweb.proto.AddressRequest, com.sparrowwallet.sparrow.mweb.proto.AddressResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Addresses"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.sparrowwallet.sparrow.mweb.proto.AddressRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.sparrowwallet.sparrow.mweb.proto.AddressResponse.getDefaultInstance()))
              .setSchemaDescriptor(new RpcMethodDescriptorSupplier("Addresses"))
              .build();
        }
      }
    }
    return getAddressesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.sparrowwallet.sparrow.mweb.proto.SpentRequest,
      com.sparrowwallet.sparrow.mweb.proto.SpentResponse> getSpentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Spent",
      requestType = com.sparrowwallet.sparrow.mweb.proto.SpentRequest.class,
      responseType = com.sparrowwallet.sparrow.mweb.proto.SpentResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.sparrowwallet.sparrow.mweb.proto.SpentRequest,
      com.sparrowwallet.sparrow.mweb.proto.SpentResponse> getSpentMethod() {
    io.grpc.MethodDescriptor<com.sparrowwallet.sparrow.mweb.proto.SpentRequest, com.sparrowwallet.sparrow.mweb.proto.SpentResponse> getSpentMethod;
    if ((getSpentMethod = RpcGrpc.getSpentMethod) == null) {
      synchronized (RpcGrpc.class) {
        if ((getSpentMethod = RpcGrpc.getSpentMethod) == null) {
          RpcGrpc.getSpentMethod = getSpentMethod =
              io.grpc.MethodDescriptor.<com.sparrowwallet.sparrow.mweb.proto.SpentRequest, com.sparrowwallet.sparrow.mweb.proto.SpentResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Spent"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.sparrowwallet.sparrow.mweb.proto.SpentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.sparrowwallet.sparrow.mweb.proto.SpentResponse.getDefaultInstance()))
              .setSchemaDescriptor(new RpcMethodDescriptorSupplier("Spent"))
              .build();
        }
      }
    }
    return getSpentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.sparrowwallet.sparrow.mweb.proto.CreateRequest,
      com.sparrowwallet.sparrow.mweb.proto.CreateResponse> getCreateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Create",
      requestType = com.sparrowwallet.sparrow.mweb.proto.CreateRequest.class,
      responseType = com.sparrowwallet.sparrow.mweb.proto.CreateResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.sparrowwallet.sparrow.mweb.proto.CreateRequest,
      com.sparrowwallet.sparrow.mweb.proto.CreateResponse> getCreateMethod() {
    io.grpc.MethodDescriptor<com.sparrowwallet.sparrow.mweb.proto.CreateRequest, com.sparrowwallet.sparrow.mweb.proto.CreateResponse> getCreateMethod;
    if ((getCreateMethod = RpcGrpc.getCreateMethod) == null) {
      synchronized (RpcGrpc.class) {
        if ((getCreateMethod = RpcGrpc.getCreateMethod) == null) {
          RpcGrpc.getCreateMethod = getCreateMethod =
              io.grpc.MethodDescriptor.<com.sparrowwallet.sparrow.mweb.proto.CreateRequest, com.sparrowwallet.sparrow.mweb.proto.CreateResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Create"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.sparrowwallet.sparrow.mweb.proto.CreateRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.sparrowwallet.sparrow.mweb.proto.CreateResponse.getDefaultInstance()))
              .setSchemaDescriptor(new RpcMethodDescriptorSupplier("Create"))
              .build();
        }
      }
    }
    return getCreateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.sparrowwallet.sparrow.mweb.proto.PsbtCreateRequest,
      com.sparrowwallet.sparrow.mweb.proto.PsbtResponse> getPsbtCreateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "PsbtCreate",
      requestType = com.sparrowwallet.sparrow.mweb.proto.PsbtCreateRequest.class,
      responseType = com.sparrowwallet.sparrow.mweb.proto.PsbtResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.sparrowwallet.sparrow.mweb.proto.PsbtCreateRequest,
      com.sparrowwallet.sparrow.mweb.proto.PsbtResponse> getPsbtCreateMethod() {
    io.grpc.MethodDescriptor<com.sparrowwallet.sparrow.mweb.proto.PsbtCreateRequest, com.sparrowwallet.sparrow.mweb.proto.PsbtResponse> getPsbtCreateMethod;
    if ((getPsbtCreateMethod = RpcGrpc.getPsbtCreateMethod) == null) {
      synchronized (RpcGrpc.class) {
        if ((getPsbtCreateMethod = RpcGrpc.getPsbtCreateMethod) == null) {
          RpcGrpc.getPsbtCreateMethod = getPsbtCreateMethod =
              io.grpc.MethodDescriptor.<com.sparrowwallet.sparrow.mweb.proto.PsbtCreateRequest, com.sparrowwallet.sparrow.mweb.proto.PsbtResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "PsbtCreate"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.sparrowwallet.sparrow.mweb.proto.PsbtCreateRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.sparrowwallet.sparrow.mweb.proto.PsbtResponse.getDefaultInstance()))
              .setSchemaDescriptor(new RpcMethodDescriptorSupplier("PsbtCreate"))
              .build();
        }
      }
    }
    return getPsbtCreateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.sparrowwallet.sparrow.mweb.proto.PsbtAddInputRequest,
      com.sparrowwallet.sparrow.mweb.proto.PsbtResponse> getPsbtAddInputMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "PsbtAddInput",
      requestType = com.sparrowwallet.sparrow.mweb.proto.PsbtAddInputRequest.class,
      responseType = com.sparrowwallet.sparrow.mweb.proto.PsbtResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.sparrowwallet.sparrow.mweb.proto.PsbtAddInputRequest,
      com.sparrowwallet.sparrow.mweb.proto.PsbtResponse> getPsbtAddInputMethod() {
    io.grpc.MethodDescriptor<com.sparrowwallet.sparrow.mweb.proto.PsbtAddInputRequest, com.sparrowwallet.sparrow.mweb.proto.PsbtResponse> getPsbtAddInputMethod;
    if ((getPsbtAddInputMethod = RpcGrpc.getPsbtAddInputMethod) == null) {
      synchronized (RpcGrpc.class) {
        if ((getPsbtAddInputMethod = RpcGrpc.getPsbtAddInputMethod) == null) {
          RpcGrpc.getPsbtAddInputMethod = getPsbtAddInputMethod =
              io.grpc.MethodDescriptor.<com.sparrowwallet.sparrow.mweb.proto.PsbtAddInputRequest, com.sparrowwallet.sparrow.mweb.proto.PsbtResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "PsbtAddInput"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.sparrowwallet.sparrow.mweb.proto.PsbtAddInputRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.sparrowwallet.sparrow.mweb.proto.PsbtResponse.getDefaultInstance()))
              .setSchemaDescriptor(new RpcMethodDescriptorSupplier("PsbtAddInput"))
              .build();
        }
      }
    }
    return getPsbtAddInputMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.sparrowwallet.sparrow.mweb.proto.PsbtAddRecipientRequest,
      com.sparrowwallet.sparrow.mweb.proto.PsbtResponse> getPsbtAddRecipientMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "PsbtAddRecipient",
      requestType = com.sparrowwallet.sparrow.mweb.proto.PsbtAddRecipientRequest.class,
      responseType = com.sparrowwallet.sparrow.mweb.proto.PsbtResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.sparrowwallet.sparrow.mweb.proto.PsbtAddRecipientRequest,
      com.sparrowwallet.sparrow.mweb.proto.PsbtResponse> getPsbtAddRecipientMethod() {
    io.grpc.MethodDescriptor<com.sparrowwallet.sparrow.mweb.proto.PsbtAddRecipientRequest, com.sparrowwallet.sparrow.mweb.proto.PsbtResponse> getPsbtAddRecipientMethod;
    if ((getPsbtAddRecipientMethod = RpcGrpc.getPsbtAddRecipientMethod) == null) {
      synchronized (RpcGrpc.class) {
        if ((getPsbtAddRecipientMethod = RpcGrpc.getPsbtAddRecipientMethod) == null) {
          RpcGrpc.getPsbtAddRecipientMethod = getPsbtAddRecipientMethod =
              io.grpc.MethodDescriptor.<com.sparrowwallet.sparrow.mweb.proto.PsbtAddRecipientRequest, com.sparrowwallet.sparrow.mweb.proto.PsbtResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "PsbtAddRecipient"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.sparrowwallet.sparrow.mweb.proto.PsbtAddRecipientRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.sparrowwallet.sparrow.mweb.proto.PsbtResponse.getDefaultInstance()))
              .setSchemaDescriptor(new RpcMethodDescriptorSupplier("PsbtAddRecipient"))
              .build();
        }
      }
    }
    return getPsbtAddRecipientMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.sparrowwallet.sparrow.mweb.proto.PsbtGetRecipientsRequest,
      com.sparrowwallet.sparrow.mweb.proto.PsbtGetRecipientsResponse> getPsbtGetRecipientsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "PsbtGetRecipients",
      requestType = com.sparrowwallet.sparrow.mweb.proto.PsbtGetRecipientsRequest.class,
      responseType = com.sparrowwallet.sparrow.mweb.proto.PsbtGetRecipientsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.sparrowwallet.sparrow.mweb.proto.PsbtGetRecipientsRequest,
      com.sparrowwallet.sparrow.mweb.proto.PsbtGetRecipientsResponse> getPsbtGetRecipientsMethod() {
    io.grpc.MethodDescriptor<com.sparrowwallet.sparrow.mweb.proto.PsbtGetRecipientsRequest, com.sparrowwallet.sparrow.mweb.proto.PsbtGetRecipientsResponse> getPsbtGetRecipientsMethod;
    if ((getPsbtGetRecipientsMethod = RpcGrpc.getPsbtGetRecipientsMethod) == null) {
      synchronized (RpcGrpc.class) {
        if ((getPsbtGetRecipientsMethod = RpcGrpc.getPsbtGetRecipientsMethod) == null) {
          RpcGrpc.getPsbtGetRecipientsMethod = getPsbtGetRecipientsMethod =
              io.grpc.MethodDescriptor.<com.sparrowwallet.sparrow.mweb.proto.PsbtGetRecipientsRequest, com.sparrowwallet.sparrow.mweb.proto.PsbtGetRecipientsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "PsbtGetRecipients"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.sparrowwallet.sparrow.mweb.proto.PsbtGetRecipientsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.sparrowwallet.sparrow.mweb.proto.PsbtGetRecipientsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new RpcMethodDescriptorSupplier("PsbtGetRecipients"))
              .build();
        }
      }
    }
    return getPsbtGetRecipientsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.sparrowwallet.sparrow.mweb.proto.PsbtSignRequest,
      com.sparrowwallet.sparrow.mweb.proto.PsbtResponse> getPsbtSignMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "PsbtSign",
      requestType = com.sparrowwallet.sparrow.mweb.proto.PsbtSignRequest.class,
      responseType = com.sparrowwallet.sparrow.mweb.proto.PsbtResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.sparrowwallet.sparrow.mweb.proto.PsbtSignRequest,
      com.sparrowwallet.sparrow.mweb.proto.PsbtResponse> getPsbtSignMethod() {
    io.grpc.MethodDescriptor<com.sparrowwallet.sparrow.mweb.proto.PsbtSignRequest, com.sparrowwallet.sparrow.mweb.proto.PsbtResponse> getPsbtSignMethod;
    if ((getPsbtSignMethod = RpcGrpc.getPsbtSignMethod) == null) {
      synchronized (RpcGrpc.class) {
        if ((getPsbtSignMethod = RpcGrpc.getPsbtSignMethod) == null) {
          RpcGrpc.getPsbtSignMethod = getPsbtSignMethod =
              io.grpc.MethodDescriptor.<com.sparrowwallet.sparrow.mweb.proto.PsbtSignRequest, com.sparrowwallet.sparrow.mweb.proto.PsbtResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "PsbtSign"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.sparrowwallet.sparrow.mweb.proto.PsbtSignRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.sparrowwallet.sparrow.mweb.proto.PsbtResponse.getDefaultInstance()))
              .setSchemaDescriptor(new RpcMethodDescriptorSupplier("PsbtSign"))
              .build();
        }
      }
    }
    return getPsbtSignMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.sparrowwallet.sparrow.mweb.proto.PsbtSignNonMwebRequest,
      com.sparrowwallet.sparrow.mweb.proto.PsbtResponse> getPsbtSignNonMwebMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "PsbtSignNonMweb",
      requestType = com.sparrowwallet.sparrow.mweb.proto.PsbtSignNonMwebRequest.class,
      responseType = com.sparrowwallet.sparrow.mweb.proto.PsbtResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.sparrowwallet.sparrow.mweb.proto.PsbtSignNonMwebRequest,
      com.sparrowwallet.sparrow.mweb.proto.PsbtResponse> getPsbtSignNonMwebMethod() {
    io.grpc.MethodDescriptor<com.sparrowwallet.sparrow.mweb.proto.PsbtSignNonMwebRequest, com.sparrowwallet.sparrow.mweb.proto.PsbtResponse> getPsbtSignNonMwebMethod;
    if ((getPsbtSignNonMwebMethod = RpcGrpc.getPsbtSignNonMwebMethod) == null) {
      synchronized (RpcGrpc.class) {
        if ((getPsbtSignNonMwebMethod = RpcGrpc.getPsbtSignNonMwebMethod) == null) {
          RpcGrpc.getPsbtSignNonMwebMethod = getPsbtSignNonMwebMethod =
              io.grpc.MethodDescriptor.<com.sparrowwallet.sparrow.mweb.proto.PsbtSignNonMwebRequest, com.sparrowwallet.sparrow.mweb.proto.PsbtResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "PsbtSignNonMweb"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.sparrowwallet.sparrow.mweb.proto.PsbtSignNonMwebRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.sparrowwallet.sparrow.mweb.proto.PsbtResponse.getDefaultInstance()))
              .setSchemaDescriptor(new RpcMethodDescriptorSupplier("PsbtSignNonMweb"))
              .build();
        }
      }
    }
    return getPsbtSignNonMwebMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.sparrowwallet.sparrow.mweb.proto.PsbtExtractRequest,
      com.sparrowwallet.sparrow.mweb.proto.CreateResponse> getPsbtExtractMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "PsbtExtract",
      requestType = com.sparrowwallet.sparrow.mweb.proto.PsbtExtractRequest.class,
      responseType = com.sparrowwallet.sparrow.mweb.proto.CreateResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.sparrowwallet.sparrow.mweb.proto.PsbtExtractRequest,
      com.sparrowwallet.sparrow.mweb.proto.CreateResponse> getPsbtExtractMethod() {
    io.grpc.MethodDescriptor<com.sparrowwallet.sparrow.mweb.proto.PsbtExtractRequest, com.sparrowwallet.sparrow.mweb.proto.CreateResponse> getPsbtExtractMethod;
    if ((getPsbtExtractMethod = RpcGrpc.getPsbtExtractMethod) == null) {
      synchronized (RpcGrpc.class) {
        if ((getPsbtExtractMethod = RpcGrpc.getPsbtExtractMethod) == null) {
          RpcGrpc.getPsbtExtractMethod = getPsbtExtractMethod =
              io.grpc.MethodDescriptor.<com.sparrowwallet.sparrow.mweb.proto.PsbtExtractRequest, com.sparrowwallet.sparrow.mweb.proto.CreateResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "PsbtExtract"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.sparrowwallet.sparrow.mweb.proto.PsbtExtractRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.sparrowwallet.sparrow.mweb.proto.CreateResponse.getDefaultInstance()))
              .setSchemaDescriptor(new RpcMethodDescriptorSupplier("PsbtExtract"))
              .build();
        }
      }
    }
    return getPsbtExtractMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.sparrowwallet.sparrow.mweb.proto.LedgerApdu,
      com.sparrowwallet.sparrow.mweb.proto.LedgerApdu> getLedgerExchangeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "LedgerExchange",
      requestType = com.sparrowwallet.sparrow.mweb.proto.LedgerApdu.class,
      responseType = com.sparrowwallet.sparrow.mweb.proto.LedgerApdu.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.sparrowwallet.sparrow.mweb.proto.LedgerApdu,
      com.sparrowwallet.sparrow.mweb.proto.LedgerApdu> getLedgerExchangeMethod() {
    io.grpc.MethodDescriptor<com.sparrowwallet.sparrow.mweb.proto.LedgerApdu, com.sparrowwallet.sparrow.mweb.proto.LedgerApdu> getLedgerExchangeMethod;
    if ((getLedgerExchangeMethod = RpcGrpc.getLedgerExchangeMethod) == null) {
      synchronized (RpcGrpc.class) {
        if ((getLedgerExchangeMethod = RpcGrpc.getLedgerExchangeMethod) == null) {
          RpcGrpc.getLedgerExchangeMethod = getLedgerExchangeMethod =
              io.grpc.MethodDescriptor.<com.sparrowwallet.sparrow.mweb.proto.LedgerApdu, com.sparrowwallet.sparrow.mweb.proto.LedgerApdu>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "LedgerExchange"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.sparrowwallet.sparrow.mweb.proto.LedgerApdu.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.sparrowwallet.sparrow.mweb.proto.LedgerApdu.getDefaultInstance()))
              .setSchemaDescriptor(new RpcMethodDescriptorSupplier("LedgerExchange"))
              .build();
        }
      }
    }
    return getLedgerExchangeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.sparrowwallet.sparrow.mweb.proto.BroadcastRequest,
      com.sparrowwallet.sparrow.mweb.proto.BroadcastResponse> getBroadcastMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Broadcast",
      requestType = com.sparrowwallet.sparrow.mweb.proto.BroadcastRequest.class,
      responseType = com.sparrowwallet.sparrow.mweb.proto.BroadcastResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.sparrowwallet.sparrow.mweb.proto.BroadcastRequest,
      com.sparrowwallet.sparrow.mweb.proto.BroadcastResponse> getBroadcastMethod() {
    io.grpc.MethodDescriptor<com.sparrowwallet.sparrow.mweb.proto.BroadcastRequest, com.sparrowwallet.sparrow.mweb.proto.BroadcastResponse> getBroadcastMethod;
    if ((getBroadcastMethod = RpcGrpc.getBroadcastMethod) == null) {
      synchronized (RpcGrpc.class) {
        if ((getBroadcastMethod = RpcGrpc.getBroadcastMethod) == null) {
          RpcGrpc.getBroadcastMethod = getBroadcastMethod =
              io.grpc.MethodDescriptor.<com.sparrowwallet.sparrow.mweb.proto.BroadcastRequest, com.sparrowwallet.sparrow.mweb.proto.BroadcastResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Broadcast"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.sparrowwallet.sparrow.mweb.proto.BroadcastRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.sparrowwallet.sparrow.mweb.proto.BroadcastResponse.getDefaultInstance()))
              .setSchemaDescriptor(new RpcMethodDescriptorSupplier("Broadcast"))
              .build();
        }
      }
    }
    return getBroadcastMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.sparrowwallet.sparrow.mweb.proto.CoinswapRequest,
      com.sparrowwallet.sparrow.mweb.proto.CoinswapResponse> getCoinswapMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Coinswap",
      requestType = com.sparrowwallet.sparrow.mweb.proto.CoinswapRequest.class,
      responseType = com.sparrowwallet.sparrow.mweb.proto.CoinswapResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.sparrowwallet.sparrow.mweb.proto.CoinswapRequest,
      com.sparrowwallet.sparrow.mweb.proto.CoinswapResponse> getCoinswapMethod() {
    io.grpc.MethodDescriptor<com.sparrowwallet.sparrow.mweb.proto.CoinswapRequest, com.sparrowwallet.sparrow.mweb.proto.CoinswapResponse> getCoinswapMethod;
    if ((getCoinswapMethod = RpcGrpc.getCoinswapMethod) == null) {
      synchronized (RpcGrpc.class) {
        if ((getCoinswapMethod = RpcGrpc.getCoinswapMethod) == null) {
          RpcGrpc.getCoinswapMethod = getCoinswapMethod =
              io.grpc.MethodDescriptor.<com.sparrowwallet.sparrow.mweb.proto.CoinswapRequest, com.sparrowwallet.sparrow.mweb.proto.CoinswapResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Coinswap"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.sparrowwallet.sparrow.mweb.proto.CoinswapRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.sparrowwallet.sparrow.mweb.proto.CoinswapResponse.getDefaultInstance()))
              .setSchemaDescriptor(new RpcMethodDescriptorSupplier("Coinswap"))
              .build();
        }
      }
    }
    return getCoinswapMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static RpcStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RpcStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RpcStub>() {
        @java.lang.Override
        public RpcStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RpcStub(channel, callOptions);
        }
      };
    return RpcStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports all types of calls on the service
   */
  public static RpcBlockingV2Stub newBlockingV2Stub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RpcBlockingV2Stub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RpcBlockingV2Stub>() {
        @java.lang.Override
        public RpcBlockingV2Stub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RpcBlockingV2Stub(channel, callOptions);
        }
      };
    return RpcBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RpcBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RpcBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RpcBlockingStub>() {
        @java.lang.Override
        public RpcBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RpcBlockingStub(channel, callOptions);
        }
      };
    return RpcBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static RpcFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RpcFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RpcFutureStub>() {
        @java.lang.Override
        public RpcFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RpcFutureStub(channel, callOptions);
        }
      };
    return RpcFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     * <pre>
     * Get the sync status of the daemon. The block headers are
     * synced first, followed by a subset of MWEB headers, and
     * finally the MWEB utxo set.
     * </pre>
     */
    default void status(com.sparrowwallet.sparrow.mweb.proto.StatusRequest request,
        io.grpc.stub.StreamObserver<com.sparrowwallet.sparrow.mweb.proto.StatusResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getStatusMethod(), responseObserver);
    }

    /**
     * <pre>
     * Get a continuous stream of unspent MWEB outputs (utxos)
     * for an account.
     * </pre>
     */
    default void utxos(com.sparrowwallet.sparrow.mweb.proto.UtxosRequest request,
        io.grpc.stub.StreamObserver<com.sparrowwallet.sparrow.mweb.proto.Utxo> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUtxosMethod(), responseObserver);
    }

    /**
     * <pre>
     * Get a batch of MWEB addresses for an account.
     * </pre>
     */
    default void addresses(com.sparrowwallet.sparrow.mweb.proto.AddressRequest request,
        io.grpc.stub.StreamObserver<com.sparrowwallet.sparrow.mweb.proto.AddressResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAddressesMethod(), responseObserver);
    }

    /**
     * <pre>
     * Check whether MWEB outputs are in the unspent set or not.
     * This is used to determine when outputs have been spent by
     * either this or another wallet using the same seed, and to
     * determine when MWEB transactions have confirmed by checking
     * the output IDs of the MWEB inputs and outputs.
     * </pre>
     */
    default void spent(com.sparrowwallet.sparrow.mweb.proto.SpentRequest request,
        io.grpc.stub.StreamObserver<com.sparrowwallet.sparrow.mweb.proto.SpentResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSpentMethod(), responseObserver);
    }

    /**
     * <pre>
     * Create the MWEB portion of a transaction.
     * </pre>
     */
    default void create(com.sparrowwallet.sparrow.mweb.proto.CreateRequest request,
        io.grpc.stub.StreamObserver<com.sparrowwallet.sparrow.mweb.proto.CreateResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateMethod(), responseObserver);
    }

    /**
     * <pre>
     * Create a PSBT from a raw transaction.
     * </pre>
     */
    default void psbtCreate(com.sparrowwallet.sparrow.mweb.proto.PsbtCreateRequest request,
        io.grpc.stub.StreamObserver<com.sparrowwallet.sparrow.mweb.proto.PsbtResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getPsbtCreateMethod(), responseObserver);
    }

    /**
     * <pre>
     * Add a MWEB input to a PSBT.
     * </pre>
     */
    default void psbtAddInput(com.sparrowwallet.sparrow.mweb.proto.PsbtAddInputRequest request,
        io.grpc.stub.StreamObserver<com.sparrowwallet.sparrow.mweb.proto.PsbtResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getPsbtAddInputMethod(), responseObserver);
    }

    /**
     * <pre>
     * Add a recipient to a PSBT.
     * </pre>
     */
    default void psbtAddRecipient(com.sparrowwallet.sparrow.mweb.proto.PsbtAddRecipientRequest request,
        io.grpc.stub.StreamObserver<com.sparrowwallet.sparrow.mweb.proto.PsbtResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getPsbtAddRecipientMethod(), responseObserver);
    }

    /**
     * <pre>
     * Get the recipients of a PSBT.
     * </pre>
     */
    default void psbtGetRecipients(com.sparrowwallet.sparrow.mweb.proto.PsbtGetRecipientsRequest request,
        io.grpc.stub.StreamObserver<com.sparrowwallet.sparrow.mweb.proto.PsbtGetRecipientsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getPsbtGetRecipientsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Sign the MWEB portion of a PSBT.
     * </pre>
     */
    default void psbtSign(com.sparrowwallet.sparrow.mweb.proto.PsbtSignRequest request,
        io.grpc.stub.StreamObserver<com.sparrowwallet.sparrow.mweb.proto.PsbtResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getPsbtSignMethod(), responseObserver);
    }

    /**
     * <pre>
     * Sign a non-MWEB input of a PSBT.
     * </pre>
     */
    default void psbtSignNonMweb(com.sparrowwallet.sparrow.mweb.proto.PsbtSignNonMwebRequest request,
        io.grpc.stub.StreamObserver<com.sparrowwallet.sparrow.mweb.proto.PsbtResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getPsbtSignNonMwebMethod(), responseObserver);
    }

    /**
     * <pre>
     * Extract the raw transaction from a signed PSBT.
     * </pre>
     */
    default void psbtExtract(com.sparrowwallet.sparrow.mweb.proto.PsbtExtractRequest request,
        io.grpc.stub.StreamObserver<com.sparrowwallet.sparrow.mweb.proto.CreateResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getPsbtExtractMethod(), responseObserver);
    }

    /**
     * <pre>
     * Process APDUs from the Ledger.
     * </pre>
     */
    default void ledgerExchange(com.sparrowwallet.sparrow.mweb.proto.LedgerApdu request,
        io.grpc.stub.StreamObserver<com.sparrowwallet.sparrow.mweb.proto.LedgerApdu> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getLedgerExchangeMethod(), responseObserver);
    }

    /**
     * <pre>
     * Broadcast a transaction to the network. This is provided as
     * existing broadcast services may not support MWEB transactions.
     * </pre>
     */
    default void broadcast(com.sparrowwallet.sparrow.mweb.proto.BroadcastRequest request,
        io.grpc.stub.StreamObserver<com.sparrowwallet.sparrow.mweb.proto.BroadcastResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getBroadcastMethod(), responseObserver);
    }

    /**
     * <pre>
     * Submit a coinswap request.
     * </pre>
     */
    default void coinswap(com.sparrowwallet.sparrow.mweb.proto.CoinswapRequest request,
        io.grpc.stub.StreamObserver<com.sparrowwallet.sparrow.mweb.proto.CoinswapResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCoinswapMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service Rpc.
   */
  public static abstract class RpcImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return RpcGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service Rpc.
   */
  public static final class RpcStub
      extends io.grpc.stub.AbstractAsyncStub<RpcStub> {
    private RpcStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RpcStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RpcStub(channel, callOptions);
    }

    /**
     * <pre>
     * Get the sync status of the daemon. The block headers are
     * synced first, followed by a subset of MWEB headers, and
     * finally the MWEB utxo set.
     * </pre>
     */
    public void status(com.sparrowwallet.sparrow.mweb.proto.StatusRequest request,
        io.grpc.stub.StreamObserver<com.sparrowwallet.sparrow.mweb.proto.StatusResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getStatusMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Get a continuous stream of unspent MWEB outputs (utxos)
     * for an account.
     * </pre>
     */
    public void utxos(com.sparrowwallet.sparrow.mweb.proto.UtxosRequest request,
        io.grpc.stub.StreamObserver<com.sparrowwallet.sparrow.mweb.proto.Utxo> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getUtxosMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Get a batch of MWEB addresses for an account.
     * </pre>
     */
    public void addresses(com.sparrowwallet.sparrow.mweb.proto.AddressRequest request,
        io.grpc.stub.StreamObserver<com.sparrowwallet.sparrow.mweb.proto.AddressResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddressesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Check whether MWEB outputs are in the unspent set or not.
     * This is used to determine when outputs have been spent by
     * either this or another wallet using the same seed, and to
     * determine when MWEB transactions have confirmed by checking
     * the output IDs of the MWEB inputs and outputs.
     * </pre>
     */
    public void spent(com.sparrowwallet.sparrow.mweb.proto.SpentRequest request,
        io.grpc.stub.StreamObserver<com.sparrowwallet.sparrow.mweb.proto.SpentResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSpentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Create the MWEB portion of a transaction.
     * </pre>
     */
    public void create(com.sparrowwallet.sparrow.mweb.proto.CreateRequest request,
        io.grpc.stub.StreamObserver<com.sparrowwallet.sparrow.mweb.proto.CreateResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Create a PSBT from a raw transaction.
     * </pre>
     */
    public void psbtCreate(com.sparrowwallet.sparrow.mweb.proto.PsbtCreateRequest request,
        io.grpc.stub.StreamObserver<com.sparrowwallet.sparrow.mweb.proto.PsbtResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getPsbtCreateMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Add a MWEB input to a PSBT.
     * </pre>
     */
    public void psbtAddInput(com.sparrowwallet.sparrow.mweb.proto.PsbtAddInputRequest request,
        io.grpc.stub.StreamObserver<com.sparrowwallet.sparrow.mweb.proto.PsbtResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getPsbtAddInputMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Add a recipient to a PSBT.
     * </pre>
     */
    public void psbtAddRecipient(com.sparrowwallet.sparrow.mweb.proto.PsbtAddRecipientRequest request,
        io.grpc.stub.StreamObserver<com.sparrowwallet.sparrow.mweb.proto.PsbtResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getPsbtAddRecipientMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Get the recipients of a PSBT.
     * </pre>
     */
    public void psbtGetRecipients(com.sparrowwallet.sparrow.mweb.proto.PsbtGetRecipientsRequest request,
        io.grpc.stub.StreamObserver<com.sparrowwallet.sparrow.mweb.proto.PsbtGetRecipientsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getPsbtGetRecipientsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Sign the MWEB portion of a PSBT.
     * </pre>
     */
    public void psbtSign(com.sparrowwallet.sparrow.mweb.proto.PsbtSignRequest request,
        io.grpc.stub.StreamObserver<com.sparrowwallet.sparrow.mweb.proto.PsbtResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getPsbtSignMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Sign a non-MWEB input of a PSBT.
     * </pre>
     */
    public void psbtSignNonMweb(com.sparrowwallet.sparrow.mweb.proto.PsbtSignNonMwebRequest request,
        io.grpc.stub.StreamObserver<com.sparrowwallet.sparrow.mweb.proto.PsbtResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getPsbtSignNonMwebMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Extract the raw transaction from a signed PSBT.
     * </pre>
     */
    public void psbtExtract(com.sparrowwallet.sparrow.mweb.proto.PsbtExtractRequest request,
        io.grpc.stub.StreamObserver<com.sparrowwallet.sparrow.mweb.proto.CreateResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getPsbtExtractMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Process APDUs from the Ledger.
     * </pre>
     */
    public void ledgerExchange(com.sparrowwallet.sparrow.mweb.proto.LedgerApdu request,
        io.grpc.stub.StreamObserver<com.sparrowwallet.sparrow.mweb.proto.LedgerApdu> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getLedgerExchangeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Broadcast a transaction to the network. This is provided as
     * existing broadcast services may not support MWEB transactions.
     * </pre>
     */
    public void broadcast(com.sparrowwallet.sparrow.mweb.proto.BroadcastRequest request,
        io.grpc.stub.StreamObserver<com.sparrowwallet.sparrow.mweb.proto.BroadcastResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBroadcastMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Submit a coinswap request.
     * </pre>
     */
    public void coinswap(com.sparrowwallet.sparrow.mweb.proto.CoinswapRequest request,
        io.grpc.stub.StreamObserver<com.sparrowwallet.sparrow.mweb.proto.CoinswapResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCoinswapMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service Rpc.
   */
  public static final class RpcBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<RpcBlockingV2Stub> {
    private RpcBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RpcBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RpcBlockingV2Stub(channel, callOptions);
    }

    /**
     * <pre>
     * Get the sync status of the daemon. The block headers are
     * synced first, followed by a subset of MWEB headers, and
     * finally the MWEB utxo set.
     * </pre>
     */
    public com.sparrowwallet.sparrow.mweb.proto.StatusResponse status(com.sparrowwallet.sparrow.mweb.proto.StatusRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getStatusMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Get a continuous stream of unspent MWEB outputs (utxos)
     * for an account.
     * </pre>
     */
    @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/10918")
    public io.grpc.stub.BlockingClientCall<?, com.sparrowwallet.sparrow.mweb.proto.Utxo>
        utxos(com.sparrowwallet.sparrow.mweb.proto.UtxosRequest request) {
      return io.grpc.stub.ClientCalls.blockingV2ServerStreamingCall(
          getChannel(), getUtxosMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Get a batch of MWEB addresses for an account.
     * </pre>
     */
    public com.sparrowwallet.sparrow.mweb.proto.AddressResponse addresses(com.sparrowwallet.sparrow.mweb.proto.AddressRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getAddressesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Check whether MWEB outputs are in the unspent set or not.
     * This is used to determine when outputs have been spent by
     * either this or another wallet using the same seed, and to
     * determine when MWEB transactions have confirmed by checking
     * the output IDs of the MWEB inputs and outputs.
     * </pre>
     */
    public com.sparrowwallet.sparrow.mweb.proto.SpentResponse spent(com.sparrowwallet.sparrow.mweb.proto.SpentRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getSpentMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Create the MWEB portion of a transaction.
     * </pre>
     */
    public com.sparrowwallet.sparrow.mweb.proto.CreateResponse create(com.sparrowwallet.sparrow.mweb.proto.CreateRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Create a PSBT from a raw transaction.
     * </pre>
     */
    public com.sparrowwallet.sparrow.mweb.proto.PsbtResponse psbtCreate(com.sparrowwallet.sparrow.mweb.proto.PsbtCreateRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getPsbtCreateMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Add a MWEB input to a PSBT.
     * </pre>
     */
    public com.sparrowwallet.sparrow.mweb.proto.PsbtResponse psbtAddInput(com.sparrowwallet.sparrow.mweb.proto.PsbtAddInputRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getPsbtAddInputMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Add a recipient to a PSBT.
     * </pre>
     */
    public com.sparrowwallet.sparrow.mweb.proto.PsbtResponse psbtAddRecipient(com.sparrowwallet.sparrow.mweb.proto.PsbtAddRecipientRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getPsbtAddRecipientMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Get the recipients of a PSBT.
     * </pre>
     */
    public com.sparrowwallet.sparrow.mweb.proto.PsbtGetRecipientsResponse psbtGetRecipients(com.sparrowwallet.sparrow.mweb.proto.PsbtGetRecipientsRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getPsbtGetRecipientsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Sign the MWEB portion of a PSBT.
     * </pre>
     */
    public com.sparrowwallet.sparrow.mweb.proto.PsbtResponse psbtSign(com.sparrowwallet.sparrow.mweb.proto.PsbtSignRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getPsbtSignMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Sign a non-MWEB input of a PSBT.
     * </pre>
     */
    public com.sparrowwallet.sparrow.mweb.proto.PsbtResponse psbtSignNonMweb(com.sparrowwallet.sparrow.mweb.proto.PsbtSignNonMwebRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getPsbtSignNonMwebMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Extract the raw transaction from a signed PSBT.
     * </pre>
     */
    public com.sparrowwallet.sparrow.mweb.proto.CreateResponse psbtExtract(com.sparrowwallet.sparrow.mweb.proto.PsbtExtractRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getPsbtExtractMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Process APDUs from the Ledger.
     * </pre>
     */
    public com.sparrowwallet.sparrow.mweb.proto.LedgerApdu ledgerExchange(com.sparrowwallet.sparrow.mweb.proto.LedgerApdu request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getLedgerExchangeMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Broadcast a transaction to the network. This is provided as
     * existing broadcast services may not support MWEB transactions.
     * </pre>
     */
    public com.sparrowwallet.sparrow.mweb.proto.BroadcastResponse broadcast(com.sparrowwallet.sparrow.mweb.proto.BroadcastRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getBroadcastMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Submit a coinswap request.
     * </pre>
     */
    public com.sparrowwallet.sparrow.mweb.proto.CoinswapResponse coinswap(com.sparrowwallet.sparrow.mweb.proto.CoinswapRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCoinswapMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service Rpc.
   */
  public static final class RpcBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<RpcBlockingStub> {
    private RpcBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RpcBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RpcBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Get the sync status of the daemon. The block headers are
     * synced first, followed by a subset of MWEB headers, and
     * finally the MWEB utxo set.
     * </pre>
     */
    public com.sparrowwallet.sparrow.mweb.proto.StatusResponse status(com.sparrowwallet.sparrow.mweb.proto.StatusRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getStatusMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Get a continuous stream of unspent MWEB outputs (utxos)
     * for an account.
     * </pre>
     */
    public java.util.Iterator<com.sparrowwallet.sparrow.mweb.proto.Utxo> utxos(
        com.sparrowwallet.sparrow.mweb.proto.UtxosRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getUtxosMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Get a batch of MWEB addresses for an account.
     * </pre>
     */
    public com.sparrowwallet.sparrow.mweb.proto.AddressResponse addresses(com.sparrowwallet.sparrow.mweb.proto.AddressRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddressesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Check whether MWEB outputs are in the unspent set or not.
     * This is used to determine when outputs have been spent by
     * either this or another wallet using the same seed, and to
     * determine when MWEB transactions have confirmed by checking
     * the output IDs of the MWEB inputs and outputs.
     * </pre>
     */
    public com.sparrowwallet.sparrow.mweb.proto.SpentResponse spent(com.sparrowwallet.sparrow.mweb.proto.SpentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSpentMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Create the MWEB portion of a transaction.
     * </pre>
     */
    public com.sparrowwallet.sparrow.mweb.proto.CreateResponse create(com.sparrowwallet.sparrow.mweb.proto.CreateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Create a PSBT from a raw transaction.
     * </pre>
     */
    public com.sparrowwallet.sparrow.mweb.proto.PsbtResponse psbtCreate(com.sparrowwallet.sparrow.mweb.proto.PsbtCreateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPsbtCreateMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Add a MWEB input to a PSBT.
     * </pre>
     */
    public com.sparrowwallet.sparrow.mweb.proto.PsbtResponse psbtAddInput(com.sparrowwallet.sparrow.mweb.proto.PsbtAddInputRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPsbtAddInputMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Add a recipient to a PSBT.
     * </pre>
     */
    public com.sparrowwallet.sparrow.mweb.proto.PsbtResponse psbtAddRecipient(com.sparrowwallet.sparrow.mweb.proto.PsbtAddRecipientRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPsbtAddRecipientMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Get the recipients of a PSBT.
     * </pre>
     */
    public com.sparrowwallet.sparrow.mweb.proto.PsbtGetRecipientsResponse psbtGetRecipients(com.sparrowwallet.sparrow.mweb.proto.PsbtGetRecipientsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPsbtGetRecipientsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Sign the MWEB portion of a PSBT.
     * </pre>
     */
    public com.sparrowwallet.sparrow.mweb.proto.PsbtResponse psbtSign(com.sparrowwallet.sparrow.mweb.proto.PsbtSignRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPsbtSignMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Sign a non-MWEB input of a PSBT.
     * </pre>
     */
    public com.sparrowwallet.sparrow.mweb.proto.PsbtResponse psbtSignNonMweb(com.sparrowwallet.sparrow.mweb.proto.PsbtSignNonMwebRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPsbtSignNonMwebMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Extract the raw transaction from a signed PSBT.
     * </pre>
     */
    public com.sparrowwallet.sparrow.mweb.proto.CreateResponse psbtExtract(com.sparrowwallet.sparrow.mweb.proto.PsbtExtractRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPsbtExtractMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Process APDUs from the Ledger.
     * </pre>
     */
    public com.sparrowwallet.sparrow.mweb.proto.LedgerApdu ledgerExchange(com.sparrowwallet.sparrow.mweb.proto.LedgerApdu request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getLedgerExchangeMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Broadcast a transaction to the network. This is provided as
     * existing broadcast services may not support MWEB transactions.
     * </pre>
     */
    public com.sparrowwallet.sparrow.mweb.proto.BroadcastResponse broadcast(com.sparrowwallet.sparrow.mweb.proto.BroadcastRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBroadcastMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Submit a coinswap request.
     * </pre>
     */
    public com.sparrowwallet.sparrow.mweb.proto.CoinswapResponse coinswap(com.sparrowwallet.sparrow.mweb.proto.CoinswapRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCoinswapMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service Rpc.
   */
  public static final class RpcFutureStub
      extends io.grpc.stub.AbstractFutureStub<RpcFutureStub> {
    private RpcFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RpcFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RpcFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Get the sync status of the daemon. The block headers are
     * synced first, followed by a subset of MWEB headers, and
     * finally the MWEB utxo set.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.sparrowwallet.sparrow.mweb.proto.StatusResponse> status(
        com.sparrowwallet.sparrow.mweb.proto.StatusRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getStatusMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Get a batch of MWEB addresses for an account.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.sparrowwallet.sparrow.mweb.proto.AddressResponse> addresses(
        com.sparrowwallet.sparrow.mweb.proto.AddressRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddressesMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Check whether MWEB outputs are in the unspent set or not.
     * This is used to determine when outputs have been spent by
     * either this or another wallet using the same seed, and to
     * determine when MWEB transactions have confirmed by checking
     * the output IDs of the MWEB inputs and outputs.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.sparrowwallet.sparrow.mweb.proto.SpentResponse> spent(
        com.sparrowwallet.sparrow.mweb.proto.SpentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSpentMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Create the MWEB portion of a transaction.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.sparrowwallet.sparrow.mweb.proto.CreateResponse> create(
        com.sparrowwallet.sparrow.mweb.proto.CreateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Create a PSBT from a raw transaction.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.sparrowwallet.sparrow.mweb.proto.PsbtResponse> psbtCreate(
        com.sparrowwallet.sparrow.mweb.proto.PsbtCreateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getPsbtCreateMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Add a MWEB input to a PSBT.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.sparrowwallet.sparrow.mweb.proto.PsbtResponse> psbtAddInput(
        com.sparrowwallet.sparrow.mweb.proto.PsbtAddInputRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getPsbtAddInputMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Add a recipient to a PSBT.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.sparrowwallet.sparrow.mweb.proto.PsbtResponse> psbtAddRecipient(
        com.sparrowwallet.sparrow.mweb.proto.PsbtAddRecipientRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getPsbtAddRecipientMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Get the recipients of a PSBT.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.sparrowwallet.sparrow.mweb.proto.PsbtGetRecipientsResponse> psbtGetRecipients(
        com.sparrowwallet.sparrow.mweb.proto.PsbtGetRecipientsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getPsbtGetRecipientsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Sign the MWEB portion of a PSBT.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.sparrowwallet.sparrow.mweb.proto.PsbtResponse> psbtSign(
        com.sparrowwallet.sparrow.mweb.proto.PsbtSignRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getPsbtSignMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Sign a non-MWEB input of a PSBT.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.sparrowwallet.sparrow.mweb.proto.PsbtResponse> psbtSignNonMweb(
        com.sparrowwallet.sparrow.mweb.proto.PsbtSignNonMwebRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getPsbtSignNonMwebMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Extract the raw transaction from a signed PSBT.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.sparrowwallet.sparrow.mweb.proto.CreateResponse> psbtExtract(
        com.sparrowwallet.sparrow.mweb.proto.PsbtExtractRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getPsbtExtractMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Process APDUs from the Ledger.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.sparrowwallet.sparrow.mweb.proto.LedgerApdu> ledgerExchange(
        com.sparrowwallet.sparrow.mweb.proto.LedgerApdu request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getLedgerExchangeMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Broadcast a transaction to the network. This is provided as
     * existing broadcast services may not support MWEB transactions.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.sparrowwallet.sparrow.mweb.proto.BroadcastResponse> broadcast(
        com.sparrowwallet.sparrow.mweb.proto.BroadcastRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBroadcastMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Submit a coinswap request.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.sparrowwallet.sparrow.mweb.proto.CoinswapResponse> coinswap(
        com.sparrowwallet.sparrow.mweb.proto.CoinswapRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCoinswapMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_STATUS = 0;
  private static final int METHODID_UTXOS = 1;
  private static final int METHODID_ADDRESSES = 2;
  private static final int METHODID_SPENT = 3;
  private static final int METHODID_CREATE = 4;
  private static final int METHODID_PSBT_CREATE = 5;
  private static final int METHODID_PSBT_ADD_INPUT = 6;
  private static final int METHODID_PSBT_ADD_RECIPIENT = 7;
  private static final int METHODID_PSBT_GET_RECIPIENTS = 8;
  private static final int METHODID_PSBT_SIGN = 9;
  private static final int METHODID_PSBT_SIGN_NON_MWEB = 10;
  private static final int METHODID_PSBT_EXTRACT = 11;
  private static final int METHODID_LEDGER_EXCHANGE = 12;
  private static final int METHODID_BROADCAST = 13;
  private static final int METHODID_COINSWAP = 14;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_STATUS:
          serviceImpl.status((com.sparrowwallet.sparrow.mweb.proto.StatusRequest) request,
              (io.grpc.stub.StreamObserver<com.sparrowwallet.sparrow.mweb.proto.StatusResponse>) responseObserver);
          break;
        case METHODID_UTXOS:
          serviceImpl.utxos((com.sparrowwallet.sparrow.mweb.proto.UtxosRequest) request,
              (io.grpc.stub.StreamObserver<com.sparrowwallet.sparrow.mweb.proto.Utxo>) responseObserver);
          break;
        case METHODID_ADDRESSES:
          serviceImpl.addresses((com.sparrowwallet.sparrow.mweb.proto.AddressRequest) request,
              (io.grpc.stub.StreamObserver<com.sparrowwallet.sparrow.mweb.proto.AddressResponse>) responseObserver);
          break;
        case METHODID_SPENT:
          serviceImpl.spent((com.sparrowwallet.sparrow.mweb.proto.SpentRequest) request,
              (io.grpc.stub.StreamObserver<com.sparrowwallet.sparrow.mweb.proto.SpentResponse>) responseObserver);
          break;
        case METHODID_CREATE:
          serviceImpl.create((com.sparrowwallet.sparrow.mweb.proto.CreateRequest) request,
              (io.grpc.stub.StreamObserver<com.sparrowwallet.sparrow.mweb.proto.CreateResponse>) responseObserver);
          break;
        case METHODID_PSBT_CREATE:
          serviceImpl.psbtCreate((com.sparrowwallet.sparrow.mweb.proto.PsbtCreateRequest) request,
              (io.grpc.stub.StreamObserver<com.sparrowwallet.sparrow.mweb.proto.PsbtResponse>) responseObserver);
          break;
        case METHODID_PSBT_ADD_INPUT:
          serviceImpl.psbtAddInput((com.sparrowwallet.sparrow.mweb.proto.PsbtAddInputRequest) request,
              (io.grpc.stub.StreamObserver<com.sparrowwallet.sparrow.mweb.proto.PsbtResponse>) responseObserver);
          break;
        case METHODID_PSBT_ADD_RECIPIENT:
          serviceImpl.psbtAddRecipient((com.sparrowwallet.sparrow.mweb.proto.PsbtAddRecipientRequest) request,
              (io.grpc.stub.StreamObserver<com.sparrowwallet.sparrow.mweb.proto.PsbtResponse>) responseObserver);
          break;
        case METHODID_PSBT_GET_RECIPIENTS:
          serviceImpl.psbtGetRecipients((com.sparrowwallet.sparrow.mweb.proto.PsbtGetRecipientsRequest) request,
              (io.grpc.stub.StreamObserver<com.sparrowwallet.sparrow.mweb.proto.PsbtGetRecipientsResponse>) responseObserver);
          break;
        case METHODID_PSBT_SIGN:
          serviceImpl.psbtSign((com.sparrowwallet.sparrow.mweb.proto.PsbtSignRequest) request,
              (io.grpc.stub.StreamObserver<com.sparrowwallet.sparrow.mweb.proto.PsbtResponse>) responseObserver);
          break;
        case METHODID_PSBT_SIGN_NON_MWEB:
          serviceImpl.psbtSignNonMweb((com.sparrowwallet.sparrow.mweb.proto.PsbtSignNonMwebRequest) request,
              (io.grpc.stub.StreamObserver<com.sparrowwallet.sparrow.mweb.proto.PsbtResponse>) responseObserver);
          break;
        case METHODID_PSBT_EXTRACT:
          serviceImpl.psbtExtract((com.sparrowwallet.sparrow.mweb.proto.PsbtExtractRequest) request,
              (io.grpc.stub.StreamObserver<com.sparrowwallet.sparrow.mweb.proto.CreateResponse>) responseObserver);
          break;
        case METHODID_LEDGER_EXCHANGE:
          serviceImpl.ledgerExchange((com.sparrowwallet.sparrow.mweb.proto.LedgerApdu) request,
              (io.grpc.stub.StreamObserver<com.sparrowwallet.sparrow.mweb.proto.LedgerApdu>) responseObserver);
          break;
        case METHODID_BROADCAST:
          serviceImpl.broadcast((com.sparrowwallet.sparrow.mweb.proto.BroadcastRequest) request,
              (io.grpc.stub.StreamObserver<com.sparrowwallet.sparrow.mweb.proto.BroadcastResponse>) responseObserver);
          break;
        case METHODID_COINSWAP:
          serviceImpl.coinswap((com.sparrowwallet.sparrow.mweb.proto.CoinswapRequest) request,
              (io.grpc.stub.StreamObserver<com.sparrowwallet.sparrow.mweb.proto.CoinswapResponse>) responseObserver);
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

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getStatusMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.sparrowwallet.sparrow.mweb.proto.StatusRequest,
              com.sparrowwallet.sparrow.mweb.proto.StatusResponse>(
                service, METHODID_STATUS)))
        .addMethod(
          getUtxosMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              com.sparrowwallet.sparrow.mweb.proto.UtxosRequest,
              com.sparrowwallet.sparrow.mweb.proto.Utxo>(
                service, METHODID_UTXOS)))
        .addMethod(
          getAddressesMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.sparrowwallet.sparrow.mweb.proto.AddressRequest,
              com.sparrowwallet.sparrow.mweb.proto.AddressResponse>(
                service, METHODID_ADDRESSES)))
        .addMethod(
          getSpentMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.sparrowwallet.sparrow.mweb.proto.SpentRequest,
              com.sparrowwallet.sparrow.mweb.proto.SpentResponse>(
                service, METHODID_SPENT)))
        .addMethod(
          getCreateMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.sparrowwallet.sparrow.mweb.proto.CreateRequest,
              com.sparrowwallet.sparrow.mweb.proto.CreateResponse>(
                service, METHODID_CREATE)))
        .addMethod(
          getPsbtCreateMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.sparrowwallet.sparrow.mweb.proto.PsbtCreateRequest,
              com.sparrowwallet.sparrow.mweb.proto.PsbtResponse>(
                service, METHODID_PSBT_CREATE)))
        .addMethod(
          getPsbtAddInputMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.sparrowwallet.sparrow.mweb.proto.PsbtAddInputRequest,
              com.sparrowwallet.sparrow.mweb.proto.PsbtResponse>(
                service, METHODID_PSBT_ADD_INPUT)))
        .addMethod(
          getPsbtAddRecipientMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.sparrowwallet.sparrow.mweb.proto.PsbtAddRecipientRequest,
              com.sparrowwallet.sparrow.mweb.proto.PsbtResponse>(
                service, METHODID_PSBT_ADD_RECIPIENT)))
        .addMethod(
          getPsbtGetRecipientsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.sparrowwallet.sparrow.mweb.proto.PsbtGetRecipientsRequest,
              com.sparrowwallet.sparrow.mweb.proto.PsbtGetRecipientsResponse>(
                service, METHODID_PSBT_GET_RECIPIENTS)))
        .addMethod(
          getPsbtSignMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.sparrowwallet.sparrow.mweb.proto.PsbtSignRequest,
              com.sparrowwallet.sparrow.mweb.proto.PsbtResponse>(
                service, METHODID_PSBT_SIGN)))
        .addMethod(
          getPsbtSignNonMwebMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.sparrowwallet.sparrow.mweb.proto.PsbtSignNonMwebRequest,
              com.sparrowwallet.sparrow.mweb.proto.PsbtResponse>(
                service, METHODID_PSBT_SIGN_NON_MWEB)))
        .addMethod(
          getPsbtExtractMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.sparrowwallet.sparrow.mweb.proto.PsbtExtractRequest,
              com.sparrowwallet.sparrow.mweb.proto.CreateResponse>(
                service, METHODID_PSBT_EXTRACT)))
        .addMethod(
          getLedgerExchangeMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.sparrowwallet.sparrow.mweb.proto.LedgerApdu,
              com.sparrowwallet.sparrow.mweb.proto.LedgerApdu>(
                service, METHODID_LEDGER_EXCHANGE)))
        .addMethod(
          getBroadcastMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.sparrowwallet.sparrow.mweb.proto.BroadcastRequest,
              com.sparrowwallet.sparrow.mweb.proto.BroadcastResponse>(
                service, METHODID_BROADCAST)))
        .addMethod(
          getCoinswapMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.sparrowwallet.sparrow.mweb.proto.CoinswapRequest,
              com.sparrowwallet.sparrow.mweb.proto.CoinswapResponse>(
                service, METHODID_COINSWAP)))
        .build();
  }

  private static abstract class RpcBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    RpcBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.sparrowwallet.sparrow.mweb.proto.Mwebd.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Rpc");
    }
  }

  private static final class RpcFileDescriptorSupplier
      extends RpcBaseDescriptorSupplier {
    RpcFileDescriptorSupplier() {}
  }

  private static final class RpcMethodDescriptorSupplier
      extends RpcBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    RpcMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (RpcGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new RpcFileDescriptorSupplier())
              .addMethod(getStatusMethod())
              .addMethod(getUtxosMethod())
              .addMethod(getAddressesMethod())
              .addMethod(getSpentMethod())
              .addMethod(getCreateMethod())
              .addMethod(getPsbtCreateMethod())
              .addMethod(getPsbtAddInputMethod())
              .addMethod(getPsbtAddRecipientMethod())
              .addMethod(getPsbtGetRecipientsMethod())
              .addMethod(getPsbtSignMethod())
              .addMethod(getPsbtSignNonMwebMethod())
              .addMethod(getPsbtExtractMethod())
              .addMethod(getLedgerExchangeMethod())
              .addMethod(getBroadcastMethod())
              .addMethod(getCoinswapMethod())
              .build();
        }
      }
    }
    return result;
  }
}
