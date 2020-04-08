package com.javalearning.demo.leetcode.arrayAndstring.test;

import java.util.ArrayList;
import java.util.List;

public class generate {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        int[][] ints = new int[numRows][numRows];
        for (int i = 0; i < numRows; i++) {
            for(int j = 0; j <= i; j++){
                if (j == 0 || j == i){
                    ints[i][j] = 1;
                }else {
                    ints[i][j] = ints[i-1][j] + ints[i-1][j-1];
                }
            }
        }
        for (int[] anInt : ints) {
            List<Integer> subList = new ArrayList<>();
            for (int i : anInt) {
                if (i != 0) subList.add(i);
            }
            list.add(subList);
        }
        return list;
    }
}
