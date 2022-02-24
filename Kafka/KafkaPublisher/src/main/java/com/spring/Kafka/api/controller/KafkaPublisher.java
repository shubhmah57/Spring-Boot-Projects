package com.spring.Kafka.api.controller;


import com.spring.Kafka.api.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaPublisher {

    @Autowired
    KafkaTemplate<String, Object> template;

    private String topic = "first_topic";

    @RequestMapping(value = "/publish/{name}", method = RequestMethod.GET)
    public String kafkaPublisher(@PathVariable String name){
        template.send(topic, "Hi my name:" + name + "Welcome");
        return "Published Data";
    }

    @RequestMapping(value = "/publish", method = RequestMethod.GET)
    public String kafkaPublisherWithJson(){
        User user = new User(1, "Shubham", 27, "s@w.com", "9999");
        template.send(topic, user);
        return "Published Data";
    }
}
