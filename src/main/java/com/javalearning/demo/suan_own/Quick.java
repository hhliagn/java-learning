package com.javalearning.demo.suan_own;

import java.util.Arrays;

public class Quick {

    public static void sort(int[] a){
        sort(a, 0, a.length -1);
    }

    private static void sort(int[] a, int lo, int hi) {

        if (hi<=lo) return;
//        int mid = lo + (hi - lo) / 2;
        int j = partion(a, lo, hi);
        sort(a, lo, j-1);
        sort(a, j+1, hi);
    }

    private static int partion(int[] a, int lo, int hi) {

        int i = lo;
        int j = hi + 1;

        int v = a[i];
        while (true){
            while (less(a[++i],v)){
                if (i == hi) break;
            }
            while (less(v,a[--j])){
                if (j == lo) break;
            }
            if (i>=j) break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }

    private static void exch(int[] a, int i, int j) {
        int var = a[i];
        a[i] = a[j];
        a[j] = var;
    }

    private static boolean less(int i, int v) {
        return i < v;
    }

    public static void main(String[] args) {

        int[] a = {0, -1, 3, 8, 6, 4, 88, 35, 96, 18};
        Quick.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
