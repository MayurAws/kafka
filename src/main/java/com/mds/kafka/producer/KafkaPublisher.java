package com.mds.kafka.producer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.KafkaException;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaPublisher {
    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    public void sendMessageToKafka(String message) {
        kafkaTemplate.send("kafka-sample-app", message)
                .whenComplete((sendResult, exception) -> {
                    if (exception == null) {
                        log.info("A message has been successfully published to Kafka with offset: {}", sendResult.getRecordMetadata().offset());
                    } else {
                        log.error("Error while sending a message to Kafka due to {}", exception.getMessage());
                        throw new KafkaException("Error while sending a message to kafka due to ", exception);
                    }
                });
    }


}
