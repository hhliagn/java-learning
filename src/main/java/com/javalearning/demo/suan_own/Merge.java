package com.javalearning.demo.suan_own;

import java.util.Arrays;

public class Merge {

    public static void sort(int[] a){
        int[] aux = new int[a.length];
        sort(a, aux, 0, a.length -1);
    }

    private static void sort(int[] a, int[] aux, int lo, int hi) {

        if (hi<=lo){
            return;
        }

        int mid = lo + (hi - lo) /2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, hi);
        merge(a, aux, lo, mid, hi);
    }

    private static void merge(int[] a, int[] aux, int lo, int mid, int hi) {
        for (int i = lo; i <= hi; i++) {
            aux[i] = a[i];
        }

        int i = lo;
        int j = mid + 1;
//
        for (int k = lo; k <= hi; k++) {
            if (i > mid)                  a[k] = aux[j++];
            else if (j > hi)              a[k] = aux[i++];
            else if (less(aux[j],aux[i])) a[k] = aux[j++];
            else                          a[k] = aux[i++];
        }

//        for (int k = lo; k <= hi; k++) {
//            aux[k] = a[k];
//        }

        // merge back to a[]
//        int i = lo, j = mid+1;
//        for (int k = lo; k <= hi; k++) {
//            if      (i > mid)              a[k] = aux[j++];
//            else if (j > hi)               a[k] = aux[i++];
//            else if (less(aux[j], aux[i])) a[k] = aux[j++];
//            else                           a[k] = aux[i++];
//        }
    }

    private static boolean less(int i, int i1) {
        return i < i1;
    }

    public static void main(String[] args) {
        int[] a = {0, -1, 3, 8, 6, 4, 88, 35, 96, 18};
        Merge.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
