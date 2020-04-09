package com.javalearning.demo.leetcode.arrayAndstring.test;

public class rotate {

    public void rotate(int[] nums, int k) {
        int[] tmp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            tmp[(i+k)%nums.length] = nums[i];
        }
        for (int i = 0; i < tmp.length; i++) {
            nums[i] = tmp[i];
        }
    }
}
