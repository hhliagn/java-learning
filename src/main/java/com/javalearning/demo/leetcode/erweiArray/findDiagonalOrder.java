package com.javalearning.demo.leetcode.erweiArray;

public class findDiagonalOrder {

    //按对角线的方式打印一个二维数组
    //定义方向，只有两种
    //定义下一个元素位置：右上或是左下
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0){
            return new int[0];
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int[] a = new int[m * n];

        int row = 0;
        int col = 0;

        //定义下一个元素位置：右上，或是左下
        int[][] dirs = {{-1, 1},{1, -1}};

        //定义方向
        int k = 0;

        for (int i = 0; i < a.length; i++) {

            a[i] = matrix[row][col];

            row += dirs[k][0];
            col += dirs[k][1];

            if (col>n-1){
                col = n-1;
                row += 2;
                k = 1- k; //改变方向
            }
            if (row < 0){
                row = 0;
                k = 1-k; //改变方向
            }
            if (row > m-1){
                row = m-1;
                col += 2;
                k = 1-k; //改变方向
            }
            if (col<0){
                col = 0;
                k = 1-k; //改变方向
            }
        }
        return a;
    }
}
