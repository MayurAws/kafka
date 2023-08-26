package com.mds.kafka.controller;


import com.mds.kafka.domain.Employee;
import com.mds.kafka.producer.KafkaEmployeeRecordPublisher;
import com.mds.kafka.producer.KafkaPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kafka")
@RequiredArgsConstructor
public class KafkaController {

    private final KafkaPublisher kafkaPublisher;

    private final KafkaEmployeeRecordPublisher kafkaEmployeeRecordPublisher;

    @PostMapping("/send")
    public ResponseEntity<String> sendMessageToKafka(@RequestParam String message) {
        kafkaPublisher.sendMessageToKafka(message);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    @PostMapping("/send/employee")
    public ResponseEntity<String> sendEmployeeDetailsToKafka(@RequestBody Employee employee) {
        kafkaEmployeeRecordPublisher.sendObjectToKafka(employee);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }
}
