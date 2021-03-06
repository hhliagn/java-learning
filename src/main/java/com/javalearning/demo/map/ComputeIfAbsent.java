package com.javalearning.demo.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ComputeIfAbsent {

    public static void main(String[] args) {

        // computeIfAbsent: 如果之前的value为null, 返回function构造的value 并作为新的value
        Map<String, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0){
                map.computeIfAbsent("even", list -> new ArrayList<>()).add(i);
            }else {
                map.computeIfAbsent("odd", list -> new ArrayList<>()).add(i);
            }
        }

        System.out.println(map);
    }
}
