package com.example.producer.controller;

import com.example.producer.service.KafkaMessagePublisher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ProducerController {

    @Autowired
    private KafkaMessagePublisher kafkaMessagePublisher;
    @GetMapping("/api/v1/publish/{message}")
    public ResponseEntity<String> publishStringMessage(@PathVariable String message){
        for (int i=0; i< 10000; i++){
            kafkaMessagePublisher.sendMessageToTopic(message+" : "+ i);
        }
        return ResponseEntity.ok("Published successfully!!");
    }
}
