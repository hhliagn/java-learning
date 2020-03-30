package com.javalearning.demo.test.arrays;

import com.javalearning.demo.test.util.Generated;
import com.javalearning.demo.test.util.RandomGenerator;

import java.util.Arrays;

public class AlphabeticSearch {

    public static void main(String[] args) {

        String[] array = Generated.array(new String[30], new RandomGenerator.String(5));

//        Arrays.chpt2_sort(array, String.CASE_INSENSITIVE_ORDER);
        System.out.println("sorted array: " + Arrays.toString(array));

//        int index = Arrays.binarySearch(array, array[10], String.CASE_INSENSITIVE_ORDER);
        int index = Arrays.binarySearch(array, array[10]);
        System.out.println("array[10]: " + array[10]);
        System.out.println("array[10] index: " + index);
    }
}
