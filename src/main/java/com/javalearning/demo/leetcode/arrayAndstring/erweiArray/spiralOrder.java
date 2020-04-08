package com.javalearning.demo.leetcode.arrayAndstring.erweiArray;

import java.util.ArrayList;
import java.util.List;

public class spiralOrder {

    public static List < Integer > spiralOrder(int[][] matrix) {
        List ans = new ArrayList();
        if (matrix.length == 0)
            return ans;
        int r1 = 0, r2 = matrix.length - 1;
        int c1 = 0, c2 = matrix[0].length - 1;
        while (r1 <= r2 && c1 <= c2) {
            for (int c = c1; c <= c2; c++) ans.add(matrix[r1][c]);
            for (int r = r1 + 1; r <= r2; r++) ans.add(matrix[r][c2]);
            if (r1 < r2 && c1 < c2) {
                for (int c = c2 - 1; c > c1; c--) ans.add(matrix[r2][c]);
                for (int r = r2; r > r1; r--) ans.add(matrix[r][c1]);
            }
            r1++;
            r2--;
            c1++;
            c2--;
        }
        return ans;
    }

    public static List<Integer> spiralOrder3(int[][] matrix) {
        List ans = new ArrayList();
        if (matrix.length == 0) return ans;
        int R = matrix.length, C = matrix[0].length;
        boolean[][] seen = new boolean[R][C];
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        int r = 0, c = 0, di = 0;
        for (int i = 0; i < R * C; i++) {
            ans.add(matrix[r][c]);
            seen[r][c] = true;
            int cr = r + dr[di];
            int cc = c + dc[di];
            if (0 <= cr && cr < R && 0 <= cc && cc < C && !seen[cr][cc]){
                r = cr;
                c = cc;
            } else {
                di = (di + 1) % 4;
                r += dr[di];
                c += dc[di];
            }
        }
        return ans;
    }

    //螺旋矩阵：按螺旋的方式打印数组元素
    //每完成一轮遍历要把圈缩小一轮
    public static List<Integer> spiralOrder2(int[][] matrix) {
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

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        List<Integer> integers = spiralOrder(matrix);
        System.out.println(integers);
    }
}
