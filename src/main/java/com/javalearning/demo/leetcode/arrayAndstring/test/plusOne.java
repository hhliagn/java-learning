package com.javalearning.demo.leetcode.arrayAndstring.test;

public class plusOne {
    //1.从后到前遍历数组
    //2.遇到9把当前下标设为0，继续，否则加1返回
    //3.最后构造新数组并把第一个元素设为1返回
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n-1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) return digits;
        }
        int[] ints = new int[n + 1];
        ints[0] = 1;
        return ints;
    }
}
