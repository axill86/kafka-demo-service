package com.aandreev.sandbox.kafkademoservice.service;

import example.avro.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService {
    @Value("${kafka.topic.name}")
    private String topic;
    private final KafkaTemplate<String, User> kafkaTemplate;

    public UserService(KafkaTemplate<String, User> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void createUser(User u) {
        kafkaTemplate.send(topic, u).thenAccept(sendResult -> {
            log.info("Sent with result {}", sendResult);
        });
    }
}
