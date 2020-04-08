package com.javalearning.demo.leetcode.arrayAndstring.conclude;

public class moveZeroes {
    //快慢指针
    //快指针每次前移一步，慢指针在不等0时前移一步
    //当所有非0元素都移动到开头，把后面的元素全部用0填充
    public static void moveZeroes(int[] nums) {
        int start = 0;
        int count = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0){
                nums[start++] = nums[i];
                count++;
            }
        }
        for (int i = count; i < n; i++) {
            nums[i] = 0;
        }
    }

    //快慢指针
    //只要遇到非0就交换到下一个没修改的位置
    //如果不是连续的，那么中间的元素一定是0
    public static void moveZeroes2(int[] nums) {
        int lastNonZeroFoundAt = 0;
        for (int cur = 0; cur < nums.length; cur++) {
            if (nums[cur] != 0) {
                swap(nums, lastNonZeroFoundAt++, cur);
            }
        }
    }

    private static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        int[] a = new int[]{0,1,0,3,12};
        moveZeroes(a);
    }
}
