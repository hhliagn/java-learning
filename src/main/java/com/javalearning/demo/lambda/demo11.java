package com.javalearning.demo.lambda;

import java.util.HashMap;
import java.util.Map;

public class demo11 {
    public static void main(String[] args) {
        // 创建Map集合
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"张三");
        map.put(2,"李四");
        map.forEach((key, value) -> System.out.println(key + " " + value));
    }
}
