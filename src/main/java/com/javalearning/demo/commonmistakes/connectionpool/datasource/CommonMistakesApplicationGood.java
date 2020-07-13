package com.javalearning.demo.commonmistakes.connectionpool.datasource;

import com.javalearning.demo.commonmistakes.common.Utils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CommonMistakesApplicationGood {

    public static void main(String[] args) {
//        Utils.loadPropertySource(CommonMistakesApplicationGood.class, "good.properties");
        SpringApplication.run(CommonMistakesApplicationGood.class, args);
    }
}

