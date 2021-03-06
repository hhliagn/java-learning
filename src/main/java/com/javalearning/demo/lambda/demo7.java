package com.javalearning.demo.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class demo7 {

    public static void main(String[] args) {

        // 将字符串换成大写并用逗号链接起来
        List<String> G7 = Arrays.asList("USA", "Japan", "France", "Germany", "Italy", "U.K.","Canada");
        String collect = G7.stream().map(s -> s.toUpperCase()).collect(Collectors.joining(", "));
        System.out.println(collect);
    }
}
