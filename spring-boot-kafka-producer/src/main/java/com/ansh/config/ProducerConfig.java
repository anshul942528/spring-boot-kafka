package com.ansh.config;

import lombok.Data;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
@Data
public class ProducerConfig {

    @Value("${kafka.bootstrap.servers}")
    private String kafkaBootstrapServers;

    @Value("${kafka.topic.thetechcheck}")
    private String topicName;

    @Bean
    public KafkaProducer<String, String> kafkaProducer(){
        return new KafkaProducer<String, String>(getProducerProperties());
    }

    public Properties getProducerProperties(){
        Properties producerProperties = new Properties();
        producerProperties.put("bootstrap.servers", kafkaBootstrapServers);
        producerProperties.put("acks", "all");
        producerProperties.put("retries", 0);
        producerProperties.put("batch.size", 16384);
        producerProperties.put("linger.ms", 1);
        producerProperties.put("buffer.memory", 33554432);
        producerProperties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        producerProperties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        return producerProperties;
    }
}
