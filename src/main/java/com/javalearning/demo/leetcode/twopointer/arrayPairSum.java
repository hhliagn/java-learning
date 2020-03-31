package com.javalearning.demo.leetcode.twopointer;

import java.util.Arrays;

public class arrayPairSum {
    public static int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i+=2) {
            sum += nums[i];
        }
        return sum;
    }
}
