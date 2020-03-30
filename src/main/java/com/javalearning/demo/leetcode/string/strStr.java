package com.javalearning.demo.leetcode.string;

public class strStr {
    public static int strStr(String haystack,String needle){
        //求差值，从零开始遍历
        //什么时候条件继续找
        //什么时候该返回了
        int k = haystack.length() - needle.length();
        int start = 0;
        while (start<k){
            int i1 = start,i2 = 0;
            while (i2<needle.length()&&haystack.charAt(i1)==needle.charAt(i2)){
                i1++;
                i2++;
            }
            if (i2==needle.length()){
                return start;
            }
            start++;
        }
        return -1;
    }

    //类似的思路，使用 string API
    public static int strStr2(String haystack,String needle){
        int L = needle.length(), n = haystack.length();

        for (int start = 0; start < n - L + 1; start++) {
            if (haystack.substring(start, start + L).equals(needle)) {
                return start;
            }
        }
        return -1;
    }
}
