package com.mds.kafka.consumer;


import com.mds.kafka.domain.Employee;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaMessageConsumer {

    @KafkaListener(topics = "kafka-sample-app")
    public void consumeMessages(String inputMessage) {
        log.info("Message received: {}", inputMessage);
    }

    @KafkaListener(topics = "kafka-employee-topic")
    public void consumeEmployeeRecords(Employee employee) {
        log.info("Employee record received: {}", employee);
    }
}
