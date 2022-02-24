package com.shubham.microservice.KafkaConsumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableBinding(Sink.class)
@RestController
public class SpringCloudStreamConsumerApplication {
	Logger logger = LoggerFactory.getLogger(SpringCloudStreamConsumerApplication.class);

	@StreamListener("input")
	public void consumeMessageD(Employee employee){
		logger.info("Employee Consumed:" + employee);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudStreamConsumerApplication.class, args);
	}

}
