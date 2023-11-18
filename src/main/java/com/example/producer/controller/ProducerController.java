package com.example.producer.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ProducerController {

    @GetMapping("/api/v1/publish/{message}")
    public ResponseEntity<String> publishStringMessage(@PathVariable String message){

        log.info("Message from request : {}", message);
        return ResponseEntity.ok("Published successfully");
    }
}
