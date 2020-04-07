package com.javalearning.demo.leetcode.conclude;

public class rotate {
    //构建一个新数组
    //通过取余得到新数组的下标
    //最后把新数组的元素复制回旧数组

    //数组环 - 根据规律获取下标
    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] newArr = new int[n];
        for (int i = 0; i < n; i++) {
            newArr[(i+k)%n] = nums[i];
        }
        for (int i = 0; i < n; i++) {
            nums[i] = newArr[i];
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7};
        int k = 3;
        rotate(nums, k);
    }
}
