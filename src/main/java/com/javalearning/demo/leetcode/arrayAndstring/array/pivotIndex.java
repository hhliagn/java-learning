package com.javalearning.demo.leetcode.arrayAndstring.array;

public class pivotIndex {

    public int provitIndex(int[] nums){
        int sum = 0, leftSum = 0;

        for (int num : nums) {
            sum += num;
        }

        for (int i = 0; i < nums.length; i++) {
            if (leftSum == sum - nums[i] - leftSum){
                return i;
            }
            leftSum += nums[i];
        }

        return -1;
    }
}
