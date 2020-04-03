package com.ansh.service;


import com.ansh.config.ProducerConfig;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {

    @Autowired
    private ProducerConfig producerConfig;

    @Autowired
    private KafkaProducer<String, String> kafkaProducer;

    public void sendKafkaMessage(String payload) {
        kafkaProducer.send(new ProducerRecord<>(producerConfig.getTopicName(), payload));
    }
}
