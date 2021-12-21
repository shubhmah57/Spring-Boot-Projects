package com.spring.transactional.Transactional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class TransactionalApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransactionalApplication.class, args);
	}

}
