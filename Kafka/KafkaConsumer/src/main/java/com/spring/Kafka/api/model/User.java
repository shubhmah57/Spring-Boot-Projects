package com.spring.Kafka.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class User {

    private int id;
    private String name;
    private int age;
    private String email;
    private String mobile;

}
