package com.javalearning.demo.leetcode.erweiArray;

import java.util.ArrayList;
import java.util.List;

public class generate {

    //杨辉三角：从第三行开始，每一个数据是它上一行的前一列和它上一行的本列之和
    public List<List<Integer>> generate(int numRows) {
        int[][] a = new int[numRows][numRows];

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    a[i][j] = 1;
                } else {
                    a[i][j] = a[i - 1][j - 1] + a[i - 1][j];
                }
            }
        }

        List<List<Integer>> listList = new ArrayList<>();
        for (int[] ints : a) {
            List<Integer> list = new ArrayList<>();
            for (int anInt : ints) {
                if (anInt!=0){ //坑
                    list.add(anInt);
                }
            }
            listList.add(list);
        }
        return listList;
    }

    public List<List<Integer>> generate1(int numRows) {

        if (numRows == 0){
            return new ArrayList<>();
        }
        List<List<Integer>> listList = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            if (i == 0){
                list.add(1);
                listList.add(list);
                continue;
            }

            list.add(1);

            for (int j = 1; j < i; j++) {
                List<Integer> integers = listList.get(i - 1);
                Integer i1 = integers.get(j-1);
                Integer i2 = integers.get(j);
                list.add(i1+i2);
            }

            list.add(1);
            listList.add(list);
        }

        return listList;
    }
}
