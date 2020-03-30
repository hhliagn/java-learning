package com.javalearning.demo.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class demo6 {

    public static void main(String[] args) {
        List<String> strList = Arrays.asList("abc","bcd","defg","jk");
        System.out.println(strList);

        System.out.println("=====================");

        List<String> collect = strList.stream().filter(s -> s.length() > 2).collect(Collectors.toList());
        System.out.println(collect);
    }
}
