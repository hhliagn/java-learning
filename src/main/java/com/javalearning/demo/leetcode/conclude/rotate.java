package com.javalearning.demo.leetcode.conclude;

import java.util.Arrays;

public class rotate {
    //构建一个新数组
    //通过取余得到新数组的下标
    //最后把新数组的元素复制回旧数组
    public static void rotate(int[] nums, int k) {
        int[] a = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            a[(i + k) % nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = a[i];
        }

        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7};
        int k = 3;
        rotate(nums, k);
    }
}
