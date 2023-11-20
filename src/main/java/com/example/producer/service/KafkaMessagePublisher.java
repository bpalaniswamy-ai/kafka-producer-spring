package com.example.producer.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaMessagePublisher {

    @Autowired
    private KafkaTemplate<String, Object> template;

    public void sendMessageToTopic(String message) {
        template.send("topic-3", message)
                .thenAccept(result -> {
                    log.info("message sent to topic: {}, partition: {}, with offset: {}", "topic-1", result.getRecordMetadata().partition(), result.getRecordMetadata().offset());
                });
    }
}
