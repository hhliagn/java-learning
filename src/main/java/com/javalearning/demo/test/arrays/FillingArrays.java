package com.javalearning.demo.test.arrays;

import java.util.Arrays;

public class FillingArrays {
    public static void main(String[] args) {
        boolean[] bs = new boolean[10];
        Arrays.fill(bs, true); //为数组填充给定的值
        System.out.println(Arrays.toString(bs));
    }
}
