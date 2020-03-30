package com.javalearning.demo.review.ningmenghuokeji;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class review2 {

    public static char maxChar(String str){
        Map<Character, Integer> map = new HashMap<>();
        char[] c = str.toCharArray();
        for (int i = 0; i < c.length; i++) {
            char c1 = c[i];
            Integer count = map.get(c1);
            if (count == null){
                count = 0;
            }
            map.put(c1, ++count);
        }
        System.out.println(map);

        Set<Map.Entry<Character, Integer>> entries = map.entrySet();
        int max = 0;
        char result = 0;
        for (Map.Entry<Character, Integer> entry : entries) {
            Character key = entry.getKey();
            Integer value = entry.getValue();
            if (value > max){
                max = value;
                result = key;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        char maxChar = maxChar("aaabbbcccccccc");
        System.out.println( maxChar);
    }
}
