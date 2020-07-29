package com.javalearning.demo.rabbitmq.compensation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class CommonMistakeApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommonMistakeApplication.class, args);
    }
}

