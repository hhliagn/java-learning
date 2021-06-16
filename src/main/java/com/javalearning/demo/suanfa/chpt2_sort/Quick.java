package com.javalearning.demo.suanfa.chpt2_sort;


import java.util.Arrays;

public class Quick {

    //找一个切点，从后开始找一个比它小的，从前开始找一个比它大的，交换
    public static void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }

    // quicksort the subarray from A[lo] to A[hi]
    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j-1);
        sort(a, j+1, hi);
    }

    // partition the subarray A[lo..hi] so that A[lo..j-1] <= A[j] <= A[j+1..hi]
    // and return the index j.
    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        Comparable v = a[lo];
        while (true) {

            // find item on lo to swap
            while (less(a[++i], v)) {
                if (i == hi) break;
            }

            // find item on hi to swap
            while (less(v, a[--j])) {
                if (j == lo) break;      // redundant since A[lo] acts as sentinel
            }

            // check if pointers cross
            if (i >= j) break;

            exch(a, i, j);
        }

        // put partitioning item v at A[j]
        exch(a, lo, j);

        // now, A[lo .. j-1] <= A[j] <= A[j+1 .. hi]
        return j;
    }

    // is v < w ?
    private static boolean less(Comparable v, Comparable w) {
        if (v == w) return false;   // optimization when reference equals
        return v.compareTo(w) < 0;
    }

    // exchange A[i] and A[j]
    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    public static void main(String[] args) {
        Integer[] a = {0, -1, 3, 8, 6, 4, 88, 35, 96, 18};
        Quick.sort(a);
        System.out.println(Arrays.toString(a));
    }

}
