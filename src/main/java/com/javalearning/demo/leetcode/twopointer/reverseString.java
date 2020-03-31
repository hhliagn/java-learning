package com.javalearning.demo.leetcode.twopointer;

public class reverseString {
    public static void reverseString(char[] s) {
        int end = s.length -1;
        int start = 0;
        while (start<end){
            char temp = s[end];
            s[end--] = s[start];
            s[start++] = temp;
        }
    }

    public static void main(String[] args) {
        String s = "hello";
        char[] chars = s.toCharArray();
        reverseString(chars);
        System.out.println(new String(chars));
    }
}
