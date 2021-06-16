package com.javalearning.demo.leetcode.arrayAndstring.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class reverseWords {
    public static String reverseWords(String s) {
        String trim = s.trim();
        String[] split = trim.split("\\s+");
        List<String> strings = Arrays.asList(split);
        Collections.reverse(strings);
        return String.join(" ", strings);
    }

    public static void main(String[] args) {
        String str = "A good   example";
        String s = reverseWords(str);
        System.out.println(s);
    }
}
