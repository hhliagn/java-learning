package com.javalearning.demo.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;

@SpringBootApplication
public class CommonMistakesApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(CommonMistakesApplication.class, args);
    }

    @Autowired
    private MyService myService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println(myService.someWsCall(new HashMap()));
    }
}

