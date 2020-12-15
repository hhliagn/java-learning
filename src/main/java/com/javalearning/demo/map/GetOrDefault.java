package com.javalearning.demo.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetOrDefault {

    public static void main(String[] args) {

        // getOrDefault: 如果这个key没有value, 返回预设的默认值
        Map<String, List<Integer>> map = new HashMap<>();

        List<Integer> res = map.getOrDefault("odd", new ArrayList<>());
        System.out.println(res);
    }
}
