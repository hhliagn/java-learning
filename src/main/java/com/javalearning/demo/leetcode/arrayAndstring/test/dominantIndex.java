package com.javalearning.demo.leetcode.arrayAndstring.test;

public class dominantIndex {
    //1.先遍历一次，找到最大元素m，记录它的索引maxIndex
    //2.再遍历一次，如果 m != x 且 m < 2x 则 return -1
    public int dominantIndex(int[] nums) {
        int maxIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > nums[maxIndex]){
                maxIndex = i;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (maxIndex != i && nums[maxIndex] < nums[i] * 2){
                return -1;
            }
        }
        return maxIndex;
    }
}
