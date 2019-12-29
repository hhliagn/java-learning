package com.javalearning.demo.test;

import java.util.Arrays;

/**
 * 斐波那契数列指的是这样一个数列：1、1、2、3、5、8、13、21、34、……
 * 这个数列从第3项开始，每一项都等于前两项之和。
 */
public class Fibonacci {
    public static int[] fibonacci(int num){
        int[] a = new int[num];
        for (int z = 0; z < num; z++) {
            if (z == 0) a[z] = 1;
            if (z == 1) a[z] = 1;
            if (z > 1) a[z] = a[z - 2] + a[z - 1];
        }
        int k = 0;
        //在第47个数的时候会突破int的范围
//        for (int i : a) {
//            System.out.print(i + "-" + ++k + " ");
//        }
        System.out.println(Arrays.toString(a));
        return a;
    }

    public static void main(String[] args) {
        fibonacci(100);
    }
}
