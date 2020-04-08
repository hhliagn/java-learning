package com.javalearning.demo.leetcode.arrayAndstring.test;

public class pivotIndex {
    //1.求出总和
    //2.左边元素的和 = 总和 - 当前元素 - 左边元素的和
    //3.不满足，左边元素的和加上当前元素
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
