package com.mds.kafka.producer;

import com.mds.kafka.domain.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.KafkaException;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaEmployeeRecordPublisher {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    public void sendObjectToKafka(Employee employee) {
        kafkaTemplate.send("kafka-employee-topic", employee)
                .whenComplete((sendResult, exception) -> {
                    if (exception == null) {
                        log.info("An employee record {} has been successfully published to Kafka with offset: {}", employee.toString(), sendResult.getRecordMetadata().offset());
                    } else {
                        log.error("Error while sending an employee record to Kafka due to {}", exception.getMessage());
                        throw new KafkaException("Error while sending an employee record to Kafka due to ", exception);
                    }
                });

    }

}
