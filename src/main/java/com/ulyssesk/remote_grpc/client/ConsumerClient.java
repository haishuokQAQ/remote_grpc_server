package com.ulyssesk.remote_grpc.client;

import com.mongodb.MongoClient;
import com.ulyssesk.remote_grpc.dao.DanmuDao;
import com.ulyssesk.remote_grpc.dao.impl.DanmuDaoImpl;
import com.ulyssesk.remote_grpc.grpc.Danmu;
import com.ulyssesk.remote_grpc.grpc.DanmuConsumerGrpc;
import com.ulyssesk.remote_grpc.pojo.DanmuEntity;
import com.ulyssesk.remote_grpc.utils.JacksonUtil;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;

public class ConsumerClient {
    private static final String DEFAULT_HOST = "localhost";

    private static final int DEFAULT_PORT = 8999;

    private static final Logger log = LoggerFactory.getLogger(ConsumerClient.class);

    //这里用异步请求存根
    private DanmuConsumerGrpc.DanmuConsumerStub stub;

    public ConsumerClient(String host, int port) {

        //使用明文通讯，这里简单化，实际生产环境需要通讯加密
        this(ManagedChannelBuilder.forAddress(host,port).usePlaintext().build());

    }

    public ConsumerClient(ManagedChannel managedChannel) {
        this.stub = DanmuConsumerGrpc.newStub(managedChannel);
    }

    /**
     * 实际调用部分
     */
    public void getResult(DanmuDao danmuDao){

        //判断调用状态。在内部类中被访问，需要加final修饰

        final StreamObserver<Danmu.DanmuResponse> responseObserver = new StreamObserver<Danmu.DanmuResponse>() {
            private int cnt = 0;
            public void onNext(Danmu.DanmuResponse result) {
                //此处直接打印结果，其他也可用回调进行复杂处理
                log.info("第{}次调用得到结果为:{}",++cnt,result);
                String content = result.getContext();
                DanmuEntity danmuEntity = JacksonUtil.readValue(content, DanmuEntity.class);
                danmuDao.save(danmuEntity);
            }

            public void onError(Throwable throwable) {
                log.warn("调用出错:{}",throwable.getMessage());
            }

            public void onCompleted() {
                log.info("调用完成");
            }

        };

        StreamObserver<Danmu.DanmuRequest> requestObserver = new StreamObserver<Danmu.DanmuRequest>() {
            @Override
            public void onNext(Danmu.DanmuRequest danmuRequest) {
                stub.pullDanmu(danmuRequest, responseObserver);
            }

            @Override
            public void onError(Throwable throwable) {
                log.warn("调用出错:{}",throwable.getMessage());
            }

            @Override
            public void onCompleted() {
                log.info("调用完成");
            }
        };

        while (true) {
            requestObserver.onNext(Danmu.DanmuRequest.newBuilder().setResult(true).build());
        }
    }


    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        properties.load(new FileInputStream(new File("conf/consumer.properties")));
        String remoteHost = properties.getProperty("remote.host");
        String mongoHost = properties.getProperty("mongo.host");
        ConsumerClient additionClient = new ConsumerClient(remoteHost,DEFAULT_PORT);
        MongoClient mongoClient = new MongoClient(mongoHost);
        MongoTemplate mongoTemplate = new MongoTemplate(mongoClient, "dys");
        DanmuDaoImpl dao = new DanmuDaoImpl();
        dao.setMongoTemplate(mongoTemplate);
        additionClient.getResult(dao);

    }
}
