package com.example.kafka.controller;

import java.util.UUID;

import com.example.kafka.model.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.kafka.core.KafkaTemplate;

@RestController
@RequestMapping("/message")
@RequiredArgsConstructor
public class KafkaController {

    @Value("${kafka.topic}")
    private String topic;

    private final KafkaTemplate<String, Message> kafkaTemplate;

    @PostMapping
    public void sendMessage(@RequestBody Message kMessage) {
        kafkaTemplate.send(topic, UUID.randomUUID().toString(), kMessage);
    }
}
