package com.spring.Kafka.api.controller;

import com.spring.Kafka.api.model.User;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ConsumerController {

    List<String> messgaesList = new ArrayList<>();
    User userFromTopic = null;
    @KafkaListener(groupId = "group",
                    topics = "first_topic",
                        containerFactory = "kafkaListenerContainerFactory")
    public List<String> getMsgFromTopic(String data){
        messgaesList.add(data);
        return messgaesList;
    }

    @KafkaListener(groupId = "group1",
            topics = "first_topic",
            containerFactory = "userKafkaListenerContainerFactory")
    public User getUserFromTopic(User user){
        userFromTopic  = user;
        return userFromTopic;
    }

    @GetMapping("/consumeStringMessage")
    public List<String> getMessage(){
        return messgaesList;
    }

    @GetMapping("/consumeJSONMessage")
    public User getUser(){
        return userFromTopic;
    }
}
