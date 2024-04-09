package com.example.kafkaExample.config;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/api/v1/mapping")
public class MessageController {


    private KafkaTemplate<String,String> kafkaTemplate;

    public MessageController(KafkaTemplate<String,String> template){
        this.kafkaTemplate = template;
    }
    
    @PostMapping
    public void publish(@RequestBody MessageRecord request){
            kafkaTemplate.send("custom-kafka-topic",request.message());
    }
}
