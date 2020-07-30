package com.javalearning.demo.rabbitmq.rabbitmqdlx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CommonMistakesApplication {
    public static void main(String[] args) {
        //dlx方式太复杂了
        SpringApplication.run(CommonMistakesApplication.class, args);
    }
}

