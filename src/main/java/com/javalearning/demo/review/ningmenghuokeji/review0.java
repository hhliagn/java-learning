package com.javalearning.demo.review.ningmenghuokeji;

import java.util.Arrays;

public class review0 {

    //从小到大
    static void sort1(int[] ints){
//        System.out.println(Arrays.toString(ints));
        int c = ints.length;
        for(int i = 0; i < c; i++){
            int max = ints[0];
            int temp = 0;
            for(int j = 0; j < c - i ; j++){
                if (ints[j] > max){
                    max = ints[j];
                    temp = j;
                }
            }

            int var = ints[c-i-1];
            ints[c-i-1] = ints[temp];
            ints[temp] = var;
        }
//        System.out.println(Arrays.toString(ints));
    }

    //从大到小
    static void sort2(int[] ints){
//        System.out.println(Arrays.toString(ints));
        int c = ints.length;
        for(int i = 0; i < c; i++){
            int min = ints[i];
            int temp = i;
            for(int j = i + 1; j < c; j++){
                if (ints[j] < min){
                    min = ints[j];
                    temp = j;
                }
            }

            int var = ints[i];
            ints[i] = ints[temp];
            ints[temp] = var;
        }
//        System.out.println(Arrays.toString(ints));
    }

    static void sort3(int[] ints){
//        System.out.println(Arrays.toString(ints));
        Arrays.sort(ints);
//        System.out.println(Arrays.toString(ints));
    }

    public static void main(String[] args) {

        int[] a = new int[]{6,5,2,8};
        long total1 = 0;
        for(int i = 0; i< 10000; i++){
            long start = System.currentTimeMillis();
            sort1(a);
            long use = System.currentTimeMillis() - start;
            total1 += use;
        }
//        long avg1 = total1 / 100;

        long total2 = 0;
        for(int i = 0; i< 10000; i++){
            long start = System.currentTimeMillis();
            sort3(a);
            long use = System.currentTimeMillis() - start;
            total2 += use;
        }
//        long avg2 = total2 / 100;

        System.out.println(total1);
        System.out.println(total2);
    }
}
