package com.shubham.microservice.KafkaPublisher.springcloudstreampublisher;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.messaging.MessageChannel;

@Configuration
public class Config {

    @Bean("bean1")
    @Primary
    public MessageChannel bean1(){
        return new DirectChannel();
    }
}
