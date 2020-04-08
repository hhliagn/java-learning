package com.javalearning.demo.leetcode.arrayAndstring.test;

import java.util.ArrayList;
import java.util.List;

public class spiralOrder {

    //每次只处理最外面一层
    //处理完后把体积缩小一圈
    public List<Integer> spiralOrder(int[][] matrix) {
        int row = 0, col = 0;
        int height = matrix.length;
        int width = matrix[0].length;
        List<Integer> list = new ArrayList<>();
        while (height > 0 && width > 0){
            if (height == 1){
                for (int i = 0; i < width; i++) {
                    list.add(matrix[row][col++]);
                }
                return list;
            }
            if (width == 1){
                for (int i = 0; i < height; i++) {
                    list.add(matrix[row++][col]);
                }
                return list;
            }

            for (int i = 0; i < width - 1; i++) {
                list.add(matrix[row][col++]);
            }
            for (int i = 0; i < height - 1; i++) {
                list.add(matrix[row++][col]);
            }
            for (int i = 0; i < width - 1; i++) {
                list.add(matrix[row][col--]);
            }
            for (int i = 0; i < height - 1; i++) {
                list.add(matrix[row--][col]);
            }

            row++;
            col++;
            height -= 2;
            width -= 2;
        }
        return list;
    }
}
