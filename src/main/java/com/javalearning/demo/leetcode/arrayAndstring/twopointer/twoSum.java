package com.javalearning.demo.leetcode.arrayAndstring.twopointer;

import java.util.Arrays;

public class twoSum {
    //定义两个指针，一个从头开始，一个从尾开始
    //保证头指针小于尾指针
    //指针对应的元素之和等于目标，那么返回，大于目标，尾指针前移，小于目标，头指针前移
    public static int[] twoSum(int[] numbers, int target) {
        int[] a = new int[2];
        int start = 0, end = numbers.length -1;
        while (start<end){
            int cmd = numbers[start] + numbers[end];
            if (cmd == target){
                a[0] = start+1;
                a[1] = end+1;
                return a;
            }else if (cmd > target){
                end--;
            }else {
                start++;
            }
        }
        return a;
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{2,7,11,15};
        int target = 9;
        int[] ints = twoSum(numbers, target);
        System.out.println(Arrays.toString(ints));
    }
}
