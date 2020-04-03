package com.ansh.service;


import com.ansh.config.ConsumerConfig;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Service
@Slf4j
public class ConsumerService {

    @Autowired
    private KafkaConsumer<String, String> kafkaConsumer;

    @Autowired
    private ConsumerConfig consumerConfig;

    @PostConstruct
    public void consumerUtil(){
        kafkaConsumer.subscribe(Arrays.asList(consumerConfig.getTopicName()));
        Thread kafkaConsumerThread = new Thread(() -> {
            consumeMessage();
        });
        kafkaConsumerThread.start();
    }

    private void consumeMessage() {
        while(true) {
            ConsumerRecords<String, String> records = kafkaConsumer.poll(100);
            for (ConsumerRecord<String, String> record : records) {
                String message = record.value();
                log.info("Received message is : " + message);
            }
        }
    }
}
