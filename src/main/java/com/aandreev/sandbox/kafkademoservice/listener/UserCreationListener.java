package com.aandreev.sandbox.kafkademoservice.listener;

import example.avro.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserCreationListener {
    @KafkaListener(topics = "${kafka.topic.name}", groupId = "${kafka.group.id}")
    public void listenUserCreate(User u) {
        log.info("Received user information: {}", u);
    }
}
