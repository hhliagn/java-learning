package com.javalearning.demo.leetcode.arrayAndstring;

public class pivotIndex {

    //寻找中心索引：索引左边数的和等于索引右边数的和
    //注意边界
    public int pivotIndex(int[] nums) {

        int privotIndex = -1;
        for(int i = 0; i < nums.length; i++){
            int m = -1;
            int left = 0;
            int n = nums.length;
            int right = 0;
            while(++m < i) left  += nums[m];
            while(--n > i) right += nums[n];
            if(left == right) {
                privotIndex = i;
                break;
            }
        }
        return privotIndex;
    }
}
