package com.javalearning.demo.leetcode.arrayAndstring.test;

public class twoSum {

    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        int start = 0;
        int end = numbers.length -1;
        while (start<end){
            int cmd = numbers[start] + numbers[end];
            if(cmd == target){
                result[0] = ++start;
                result[1] = ++end;
                return result;
            }else if (cmd < target){
                start++;
            }else {
                end--;
            }
        }
        return result;
    }
}
