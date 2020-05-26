package com.ulyssesk.remote_grpc.server.kafka;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Consumer {
    private static KafkaConsumer<String, String> consumer;

    public static void init(String address, String topic) {
        Properties p = new Properties();
        p.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, address);//kafka地址，多个地址用逗号分割
        p.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        p.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        consumer = new KafkaConsumer<String, String>(p);
        List<String> topicList = new ArrayList<String>();
        topicList.add(topic);
        consumer.subscribe(topicList);
    }


    public static void runWithCallback(java.util.function.Consumer<ConsumerRecord<String, String>> consumerFunction) {
        while(true){
            ConsumerRecords<String,String> records = consumer.poll(Duration.ofMinutes(60));
            for(ConsumerRecord<String,String> record : records){
                consumerFunction.accept(record);
            }
        }
    }
}
