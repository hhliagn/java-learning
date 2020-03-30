package com.javalearning.demo.test.arrays;

import java.util.Arrays;

public class MultidimensionalPrimitiveArray {
    public static void main(String[] args) {
        int[][] ints = {{1,2,3},{4,5,6}};
        System.out.println(Arrays.deepToString(ints));
        //output: [[1, 2, 3], [4, 5, 6]]
    }
}
