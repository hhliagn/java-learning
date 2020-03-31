package com.javalearning.demo.review.ningmenghuokeji;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class review1 {

    public static String[] jiaoji(String[] str1, String[] str2){
        List<String> s1 = Arrays.asList(str1);
        List<String> s2 = new ArrayList<>();
        for (String s : str2) {
            if (s1.contains(s)){
                s2.add(s);
            }
        }
        int size = s2.size();
        String[] result = new String[size];
        for (int i = 0; i < size; i++) {
            String s = s2.get(i);
            result[i] = s;
        }
        return result;
    }

    public static void main(String[] args) {
        String[] str1 = new String[]{"a","b","c","d","e"};
        String[] str2 = new String[]{"c","f","e"};
        String[] jiaoji = jiaoji(str1, str2);
        System.out.println(Arrays.toString(jiaoji));
    }
}
