package com.javalearning.demo.leetcode.arrayAndstring.conclude;

public class reverseWords2 {
    //双指针
    public static String reverseWords(String s) {
        String[] split = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String s1 : split) {
            String s2 = reverseWords2(s1);
            sb.append(s2);
            sb.append(" ");
        }
        return sb.substring(0,sb.length() -1).toString();
    }

    public static String reverseWords2(String s) {
        int start = 0;
        int end = s.length() -1;
        char[] chars = s.toCharArray();
        while (start<end){
            char tmp = chars[start];
            chars[start] = chars[end];
            chars[end] = tmp;
            start++;
            end--;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        String s1 = reverseWords(s);
        System.out.println(s1);
    }
}
