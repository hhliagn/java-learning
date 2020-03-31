package com.javalearning.demo.suanfa.chpt2_sort;

import java.util.Arrays;

public class Bubble {
    //每次把一个最大的放到最后，外面从零开始遍历
    //里面从1开始遍历，到n-i结束，每一个和前一个比较，交换元素。
    public static void sort(int[] ints){
        int n = ints.length;
        for (int i = 0; i < n; i++) {
            for(int j = 1; j < n - i; j ++){
                if (ints[j - 1] > ints[j]){
                    int var = ints[j-1];
                    ints[j-1] = ints[j];
                    ints[j] = var;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] ints = {0, -1, 3, 8, 6, 4, 88, 35, 96, 18};
        Bubble.sort(ints);
        System.out.println(Arrays.toString(ints));
    }
}
