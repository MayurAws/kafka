package com.mds.kafka.controller;


import com.mds.kafka.producer.KafkaPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
@RequiredArgsConstructor
public class KafkaController {

    private final KafkaPublisher kafkaPublisher;

    @PostMapping("/send")
    public ResponseEntity<String> sendMessageToKafka(@RequestParam String message) {
        kafkaPublisher.sendMessageToKafka(message);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }
}
