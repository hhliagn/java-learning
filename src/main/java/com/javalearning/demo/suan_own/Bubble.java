package com.javalearning.demo.suan_own;

public class Bubble {

    public static void sort(int[] a){

        int n = a.length;
        for (int i = 0; i < n; i++) {
            for(int j = 1; j < n - i; j ++){
                if (a[j-1] > a[j]){
                    int var = a[j-1];
                    a[j-1] = a[j];
                    a[j] = var;
                }
            }
        }
    }
}
