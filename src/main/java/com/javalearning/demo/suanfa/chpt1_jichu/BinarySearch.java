package com.javalearning.demo.suanfa.chpt1_jichu;

public class BinarySearch {

    public static int search(int[] a, int find){

        int lo = 0;
        int hi = a.length;

        while (lo <= hi){
            int mid = lo + (hi - lo) /2;
            if (find > a[mid]){
                lo = mid + 1;
            }else if (find < a[mid]){
                hi = mid - 1;
            }else {
                return mid;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] a = new int[]{4,5,7,8,10,20,24};
        int index = search(a, 7);
        System.out.println(index);
    }
}
