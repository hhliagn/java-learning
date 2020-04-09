package com.javalearning.demo.leetcode.arrayAndstring.test;

public class removeDuplicates {
    //数组是排序的
    public int removeDuplicates(int[] nums) {
        int start = 0;
        for(int j =1;j<nums.length;j++){
            if (nums[j] != nums[start]){
                nums[++start] = nums[j];
            }
        }
        return start+1;
    }
}
