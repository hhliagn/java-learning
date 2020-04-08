package com.javalearning.demo.leetcode.arrayAndstring.array;

public class pivotIndex {
    public int pivotIndex(int[] nums) {
        int sum = 0,leftsum = 0;
        for (int num : nums) {
            sum += num;
        }
        for (int i = 0; i < nums.length; i++) {
            if (leftsum == sum - nums[i] - leftsum){
                return i;
            }
            leftsum += nums[i];
        }
        return -1;
    }
}
