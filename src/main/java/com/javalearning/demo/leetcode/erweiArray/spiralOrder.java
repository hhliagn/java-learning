package com.javalearning.demo.leetcode.erweiArray;

import java.util.ArrayList;
import java.util.List;

public class spiralOrder {

    //螺旋矩阵：按螺旋的方式打印数组元素
    //每完成一轮遍历要把圈缩小一轮
    public static List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new ArrayList<>();
        }

        int hight = matrix.length;
        int width = matrix[0].length;
        List<Integer> list = new ArrayList<>(width*hight);

        int m = 0; //当前横坐标
        int n = 0; //当前纵坐标
        while (hight > 0 && width > 0) {

            //如果是只有一行或一列
            if (width == 1) {
                for (int i = 0; i < hight; i++) {
                    list.add(matrix[n++][m]);
                }
                return list;
            } else if (hight == 1) {
                for (int i = 0; i < width; i++) {
                    list.add(matrix[n][m++]);
                }
                return list;
            }
            //向右
            for (int i = 0; i < width-1; i++)
                list.add(matrix[m][n++]);
            //向下
            for (int i = 0; i < hight-1; i++)
                list.add(matrix[m++][n]);
            //向左
            for (int i = 0; i < width-1; i++)
                list.add(matrix[m][n--]);
            //向上
            for (int i = 0; i < hight-1; i++)
                list.add(matrix[m--][n]);

            m++;
            n++;
            width -= 2;
            hight -=2;
        }
        return list;
    }

//    public static List<Integer> spiralOrder1(int[][] matrix) {
//        List<Integer> list = new ArrayList<>();
//
//        int m = matrix.length;
//        int n = matrix[0].length;
//
//        int row = 0;
//        int col = 0;
//
////        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
//
//        boolean[][] marked = new boolean[m+2][n+2];
//        for (int i = 0; i <= n + 1; i++) {
//            marked[0][i] = true;
//            marked[m+1][i] = true;
//        }
//        for (int i = 0; i <= m + 1; i++) {
//            marked[i][0] = true;
//            marked[i][n+1] = true;
//        }
//
//        int k = 0;
//
//        while (true){
////            list.add(matrix[row][col]);
//
//            int temp1 = 0;
//            while (col++ < n && k == 0){
//                list.add(matrix[row][col-1]);
//                marked[row+1][col+1] = true;
//            }
//            temp1 = col-2;
//
//            k = 1-k;
//
//            int temp2 = 0;
//            while (row++ < m && k == 1){
//                list.add(matrix[row-1][temp1]);
//                marked[row+1][temp1+1] = true;
//            }
//            temp2 = row -2;
//
//            k = 1-k;
//
//            if (marked[temp2][temp1+1] && marked[temp2][temp1-1] && marked[temp2+1][temp1] && marked[temp2-1][temp1]){
//                break;
//            }
//        }
//
//
//        return list;
//    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        List<Integer> integers = spiralOrder(matrix);
        System.out.println(integers);
    }
}
