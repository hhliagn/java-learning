package com.javalearning.demo.leetcode.arrayAndstring.twopointer.slowfast;

public class findMaxConsecutiveOnes {
    //定义两个计数器，一个累加1的和，一个用来比较
    //当遇到零的时候，把累加的和之前的作比较，取较大值
    //最后结束的时候还要比较一次
    public static int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int maxCount = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 1) {
                // Increment the count of 1's by one.
                count += 1;
            } else {
                // Find the maximum till now.
                maxCount = Math.max(maxCount, count);
                // Reset count of 1.
                count = 0;
            }
        }
        return Math.max(maxCount, count);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,0};
        int maxConsecutiveOnes = findMaxConsecutiveOnes(nums);
        System.out.println(maxConsecutiveOnes);
    }
}
