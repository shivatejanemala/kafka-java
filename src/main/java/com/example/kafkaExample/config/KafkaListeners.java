package com.example.kafkaExample.config;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    //KafkaListeners annotation is used to ensure the identification of kafka listener
    //groupId is used to make sure the listener listen to same partition/topic when we have multiple instances of the same class
    @KafkaListener(topics = "custom-kafka-topic",groupId="customGroupId") 
    void listeners(String data){
            System.out.println("Listener Received data: " +data );
    }
}
