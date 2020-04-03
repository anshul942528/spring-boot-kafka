package com.ansh.config;

import lombok.Data;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
@Data
public class ConsumerConfig {

    @Value("${kafka.bootstrap.servers}")
    private String kafkaBootstrapServers;

    @Value("${zookeeper.groupId}")
    private String zookeeperGroupId;

    @Value("${kafka.topic.thetechcheck}")
    private String topicName;

    @Bean
    public KafkaConsumer<String, String> kafkaConsumer(){
        return new KafkaConsumer<String, String>(getConsumerProperties());
    }

    public Properties getConsumerProperties(){
        Properties consumerProperties = new Properties();
        consumerProperties.put("bootstrap.servers", kafkaBootstrapServers);
        consumerProperties.put("group.id", zookeeperGroupId);
        consumerProperties.put("zookeeper.session.timeout.ms", "6000");
        consumerProperties.put("zookeeper.sync.time.ms","2000");
        consumerProperties.put("auto.commit.enable", "false");
        consumerProperties.put("auto.commit.interval.ms", "1000");
        consumerProperties.put("consumer.timeout.ms", "-1");
        consumerProperties.put("max.poll.records", "1");
        consumerProperties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        consumerProperties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        return consumerProperties;
    }
}
