package com.example.kafka.service;

import com.example.kafka.model.Message;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {

    @KafkaListener(
            topics = "${kafka.topic}",
            groupId = "${kafka.group.id}"
    )
    public void listen(@Payload Message message) {
        System.out.println(
                        "Message received.. MessageID : " + message.getId() +
                        " Message: " + message.getMessage() +
                        " Date : " + message.getMessageDate()
        );
    }
}
