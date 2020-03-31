package com.javalearning.demo.lambda;

import java.util.Arrays;
import java.util.List;

public class demo2 {

    //foreach
    public static void main(String[] args) {
        List features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
        for (Object feature : features) {
            System.out.println(feature);
        }
        System.out.println("======================");
        features.forEach(n -> System.out.println(n));
        System.out.println("======================");
        // 当方法参数和后面用到的参数一致时，可以这样简写
        features.forEach(System.out::println);
    }

}
