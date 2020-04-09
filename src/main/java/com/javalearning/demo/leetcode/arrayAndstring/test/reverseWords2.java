package com.javalearning.demo.leetcode.arrayAndstring.test;

public class reverseWords2 {

    public String reverseWords(String s) {
        String[] split = s.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (String s1 : split) {
            sb.append(new StringBuilder(s1).reverse().toString() + "");
        }
        return sb.toString().trim();
    }
}
