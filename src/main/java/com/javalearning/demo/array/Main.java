package com.javalearning.demo.array;

/**
 * @author lhh
 * @date 2021/3/16
 */
public class Main {

    public static void main(String[] args) {
        String[] arr = {"1","2","3","4","5"};
        int index = 0;
        del2(arr, index);
    }

    public static String[] del2(String[] arr,int index) {//index从1开始
        String[] arr2;
        arr2 = arr;
        //arr2 = new String[arr.length];
        System.arraycopy(arr, index, arr2, index,arr.length);
        arr[arr.length-1]=null;
        System.out.println("######新数组#######");
        for(String m:arr) {
            System.out.println(m);
        }

        System.out.println("######旧数组#######");
        for(String m:arr2) {
            System.out.println(m);
        }
        return arr2;
    }
}
