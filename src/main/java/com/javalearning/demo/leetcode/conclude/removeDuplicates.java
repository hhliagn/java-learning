package com.javalearning.demo.leetcode.conclude;

public class removeDuplicates {
    public static int removeDuplicates(int[] nums) {
        int start = 0;
        int count = 0;
        boolean flag = false;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            flag = false;
            for (int j = 0; j < start; j++) {
                if (nums[j] == num){
                    flag = true;
                    count++;
                    break;
                }
            }
            if (!flag){
                nums[start++] = num;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,1,2};
        int i = removeDuplicates(a);
        System.out.println(i);
    }
}
