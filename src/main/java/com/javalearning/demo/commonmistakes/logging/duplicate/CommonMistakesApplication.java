package com.javalearning.demo.commonmistakes.logging.duplicate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CommonMistakesApplication {

    public static void main(String[] args) {
        System.setProperty("logging.config", "classpath:filterright.xml");
        SpringApplication.run(CommonMistakesApplication.class, args);
    }
}

