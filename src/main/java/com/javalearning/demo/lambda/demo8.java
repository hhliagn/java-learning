package com.javalearning.demo.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class demo8 {

    public static void main(String[] args) {
        // 使用 distinct 对集合进行去重
        List<Integer> numbers = Arrays.asList(9, 10, 3, 4, 7, 3, 4);
        List<Integer> collect = numbers.stream().distinct().collect(Collectors.toList());
        System.out.println(collect);
    }
}
