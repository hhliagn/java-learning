package com.javalearning.demo.test;

import java.util.ArrayList;
import java.util.List;

/**
 * 吸血鬼数字是指位数为偶数的数字，可以由一对数字相乘而得到，而这对数字各包含乘积的一半位数的数字，其中从最初的数字中选取的数字可以任意排序。
 *
 * 以两个0结尾的数字是不允许的，例如，下列数字都是“吸血鬼”数字：
 * 1260 = 21 * 60 　1827 = 21 * 87 　2187 = 27 * 81
 *
 * 4位数的吸血鬼数有7个：
 * 1260, 1395, 1435, 1530, 1827, 2187, 6880
 */
public class ViperNumber {
    public static List<String> viperNumber(int wei){
        if (wei % 2 != 0) return null;
        List<String> result = new ArrayList<>();
        int begin = 1, end = 1;
        for (int i = 0; i < wei - 1; i++) begin *= 10;
        for (int i = 0; i < wei + 1; i++) end *= 10;
//        System.out.println(begin + " " + end);
        for (int i = begin; i < end; i++) {
            String s = i + "";
            //一共有48种情况，下面是其中的一种情况，每一种情况乘积的结果都要 = wei数
            String s1 = s.charAt(0) + "" + s.charAt(1);
            String s2 = s.charAt(2) + "" + s.charAt(3);
            Integer intval1 = Integer.valueOf(s1);
            Integer intval2 = Integer.valueOf(s2);
            int k = intval1 * intval2;
            System.out.println(k);
            if (begin <= k && k <= end) result.add(k + "");
        }
        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
        viperNumber(4);
    }
}
