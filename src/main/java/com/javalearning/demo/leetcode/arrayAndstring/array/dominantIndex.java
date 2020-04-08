package com.javalearning.demo.leetcode.arrayAndstring.array;

public class dominantIndex {

    //查找数组中的最大元素是否至少是数组中每个其他数字的两倍。
    //第二遍遍历注意跳过最大值自身的比较
    public static int dominantIndex(int[] nums) {
        int maxIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > nums[maxIndex]){
                maxIndex = i;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[maxIndex] != nums[i] && nums[maxIndex] < nums[i] * 2){
                return -1;
            }
        }
        return maxIndex;
    }

    public static void main(String[] args) {
        int[] ints = {0, 0, 0, 1};
        int i = dominantIndex(ints);
        System.out.println(i);
    }
}
