package com.javalearning.demo.leetcode.arrayAndstring.test;

public class findDiagonalOrder {

    //判断顺序要正确
    //方向判断、边界检测
    public int[] findDiagonalOrder(int[][] matrix) {
        int M = matrix.length;
        int N = matrix[0].length;
        int[] result = new int[M*N];
        int start = 0;
        int[][] dir = {{-1,1},{1,-1}};
        int k = 0;
        int x = 0,y = 0;
        for (int i = 0; i < result.length; i++) {
            result[start++] = matrix[x][y];
            int[] ints = dir[k];
            x += ints[0];
            y += ints[1];

            if (y>N-1){
                y = N-1;
                x+=2;
                k = 1-k;
            }
            if (x<0){
                x = 0;
                k = 1-k;
            }

            if (x>=M){
                x = M-1;
                y+=2;
                k = 1-k;
            }
            if (y<0){
                y = 0;
                k = 1-k;
            }
        }
        return result;
    }
}
