package com.javalearning.demo.leetcode.conclude;

import java.util.ArrayList;
import java.util.List;

public class getRow {
    public static List<Integer> getRow(int rowIndex) {
        int[][] a = new int[rowIndex+1][rowIndex+1];

        for (int i = 0; i < rowIndex+1; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    a[i][j] = 1;
                } else {
                    a[i][j] = a[i - 1][j - 1] + a[i - 1][j];
                }
            }
        }

        List<Integer> listList = new ArrayList<>();
        int[] ints1 = a[a.length - 1];
        for (int anInt : ints1) {
            if (anInt!=0){ //坑
                listList.add(anInt);
            }
        }
        return listList;
    }

    public static void main(String[] args) {
        List<Integer> row = getRow(3);
        System.out.println(row);
    }
}
