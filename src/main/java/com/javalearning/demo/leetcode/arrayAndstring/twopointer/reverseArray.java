package com.javalearning.demo.leetcode.arrayAndstring.twopointer;

import java.util.Arrays;

public class reverseArray {

    public static int[] reverseArray(int[] a){
        int end = a.length -1;
        int start = 0;
        while (start<end){
            int temp = a[end];
            a[end--] = a[start];
            a[start++] = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        int[] a = new int[]{4,5,1,3,2};
        int[] ints = reverseArray(a);
        System.out.println(Arrays.toString(ints));
    }
}
