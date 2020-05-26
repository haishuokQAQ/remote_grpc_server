package com.ulyssesk.remote_grpc.grpc;

import io.grpc.stub.StreamObserver;

public class DanmuConsumerServiceImpl extends DanmuConsumerGrpc.DanmuConsumerImplBase {

    @Override
    public void pullDanmu(Danmu.DanmuRequest request, StreamObserver<Danmu.DanmuResponse> responseObserver) {
        System.out.println(request.toString());
        Danmu.DanmuResponse resp = Danmu.DanmuResponse.newBuilder().setPlatform("test").setAnchor("test").setContext("test").build();
        responseObserver.onNext(resp);
    }
}
