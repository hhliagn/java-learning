package com.javalearning.demo.leetcode.arrayAndstring;

import java.util.Arrays;

public class plusOne {

    //在数组表示的数的基础上加1，并返回新的数组  比如 [9,9] -> [1,0,0]
    //注意只要任意一位不等于9时，加完1就要跳出循环
    public static int[] plusOne(int[] digits) {

        int n = digits.length;
        boolean flag = false;
        while (--n >= 0){
            if (digits[n] == 9){
                digits[n] = 0;
                if (n == 0){
                    flag = true;
                }
            }else {
                digits[n] = digits[n] + 1;
                break;
            }
        }
        if (flag){
            int[] ints = new int[digits.length + 1];
            ints[0] = 1;
            for (int i = 0; i < digits.length; i++) {
                ints[i+1] = digits[i];
            }
            return ints;
        }else {
            return digits;
        }
    }

    public static void main(String[] args) {
        int[] ints = {9, 9};
        int[] ints1 = plusOne(ints);
        System.out.println(Arrays.toString(ints1));
    }
}
