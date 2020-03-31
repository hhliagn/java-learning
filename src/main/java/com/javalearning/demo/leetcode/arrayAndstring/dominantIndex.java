package com.javalearning.demo.leetcode.arrayAndstring;

public class dominantIndex {

    //查找数组中的最大元素是否至少是数组中每个其他数字的两倍。
    //第二遍遍历注意跳过最大值自身的比较
    public static int dominantIndex(int[] nums) {
//        List<Integer> ints = new ArrayList<>();
        int index = -1;
        boolean flag = true;
        int max = 0;
        for (int i= 0; i < nums.length; i++) {
            if (nums[i] >= max){
                max = nums[i];
                index = i;
            }
        }

        for (int i= 0; i < nums.length; i++) {
            if (nums[i] == max) continue;
            if (max/2 < nums[i]){
                flag = false;
            }
        }

        if (flag){
            return index;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] ints = {0, 0, 0, 1};
        int i = dominantIndex(ints);
        System.out.println(i);
    }
}
