package com.javalearning.demo.leetcode.arrayAndstring.test;

public class minSubArrayLen {

    public int minSubArrayLen(int s, int[] nums) {
        int res = Integer.MAX_VALUE;
        int sum = 0;
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= s){
                res = Math.min(res, i-left+1);
                sum -= nums[left++];
            }
        }
        return res == Integer.MAX_VALUE ? 0: res;
    }
}
