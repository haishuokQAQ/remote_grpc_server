package com.ulyssesk.remote_grpc.grpc;

import io.grpc.stub.StreamObserver;

import java.util.concurrent.Future;
import java.util.concurrent.locks.ReentrantLock;

public class DanmuConsumerServiceImpl extends DanmuConsumerGrpc.DanmuConsumerImplBase {
    private Danmu.DanmuResponse currentDanmu;
    private ReentrantLock lock = new ReentrantLock();
    @Override
    public void pullDanmu(Danmu.DanmuRequest request, StreamObserver<Danmu.DanmuResponse> responseObserver) {
        System.out.println(request.toString());
        lock.lock();

        Danmu.DanmuResponse resp = Danmu.DanmuResponse.newBuilder().setPlatform("test").setAnchor("test").setContext("test").build();
        responseObserver.onNext(resp);
    }

    public boolean publishDanmu(String danmuData, String platform, String anchor) {
        if (currentDanmu != null) {
            return false;
        }
        lock.lock();
        Danmu.DanmuResponse resp = Danmu.DanmuResponse.newBuilder().setPlatform(platform).setAnchor(anchor).setContext(danmuData).build();
        currentDanmu = resp;
        lock.unlock();
        return true;
    }
}
