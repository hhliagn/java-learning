package com.javalearning.demo.leetcode.conclude;

public class reverseWords {
    //双指针
    public static String reverseWords(String s) {
        if (s.length() == 0 ){
            return s;
        }
        String[] s1 = s.split(" ");
        int start = 0;
        int end = s1.length - 1;
        while (start<end){
            if (s1[start].length() == 0){
                start++;
                continue;
            }
            if (s1[end].length() == 0){
                end--;
                continue;
            }
            String tmp = s1[start];
            s1[start] = s1[end];
            s1[end] = tmp;
            start++;
            end--;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s1.length; i++) {
            if (s1[i].length() == 0){
                continue;
            }
            if (i != s1.length -1){
                sb.append(s1[i] + " ");
            }else {
                sb.append(s1[i]);
            }
        }
        String substring = sb.toString();
        return substring;
    }

    public static void main(String[] args) {
        String s = reverseWords("a good   example");
        System.out.println(s);
    }
}
