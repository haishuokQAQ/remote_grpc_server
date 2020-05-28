package com.ulyssesk.remote_grpc.server;

import com.ulyssesk.remote_grpc.grpc.DanmuConsumerServiceImpl;
import com.ulyssesk.remote_grpc.server.kafka.Consumer;
import io.grpc.BindableService;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;
import java.util.logging.Logger;

public class ConsumerServer {
    private static final Logger logger = Logger.getLogger(ConsumerServer.class.getName());

    private static final int DEFAULT_PORT = 8999;

    private int port;//服务端口号

    private Server server;

    public ConsumerServer(int port) {
        this(port, ServerBuilder.forPort(port));
    }

    public ConsumerServer(int port, ServerBuilder<?> serverBuilder) {
        this.port = port;

        //构造服务器，添加我们实际的服务
        BindableService srv = new DanmuConsumerServiceImpl();
        server = serverBuilder.addService(srv).build();
    }
    public ConsumerServer(int port, ServerBuilder<?> serverBuilder, BindableService srv) {
        this.port = port;

        //构造服务器，添加我们实际的服务

        server = serverBuilder.addService(srv).build();
    }


    private void start() throws IOException {
        server.start();
        logger.info("Server has started, listening on " + port);
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {

                ConsumerServer.this.stop();

            }
        });

    }

    private void stop() {

        if(server != null)
            server.shutdown();

    }

    //阻塞到应用停止
    private void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    public static void main(String[] args) {

        ConsumerServer addtionServer;

        if(args.length > 0){
            addtionServer = new ConsumerServer(Integer.parseInt(args[0]));
        }else{
            addtionServer = new ConsumerServer(DEFAULT_PORT);
        }
        Consumer.init("127.0.0.1:9092", "danmu");
        final DanmuConsumerServiceImpl srv = new DanmuConsumerServiceImpl();
        Consumer.runWithCallback(stringStringConsumerRecord -> {
            try{
                String content = stringStringConsumerRecord.value();
                return srv.publishDanmu(content, "egame", "dys");
            }catch (Exception e) {
                e.printStackTrace();
            }
            return false;
        });
        try {
            addtionServer.start();
            addtionServer.blockUntilShutdown();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
