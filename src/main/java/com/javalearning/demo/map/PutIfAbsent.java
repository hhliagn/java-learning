package com.javalearning.demo.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PutIfAbsent {

    public static void main(String[] args) {

        // putIfAbsent: 如果之前的value是null, 返回null 并将value作为新的value
        Map<String, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0){
                // 会产生NPE
                map.putIfAbsent("even", new ArrayList<>()).add(i);
            }else {
                map.putIfAbsent("odd", new ArrayList<>()).add(i);
            }
        }

        System.out.println(map);
    }
}
