package com.javalearning.demo.commonmistakes.springpart2.aopfeign;

import com.javalearning.demo.commonmistakes.common.Utils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CommonMistakesApplication {

    public static void main(String[] args) {
        Utils.loadPropertySource(CommonMistakesApplication.class, "feign.properties");
        SpringApplication.run(CommonMistakesApplication.class, args);
    }
}

