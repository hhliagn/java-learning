package com.javalearning.demo.test.hoding;

import java.util.Arrays;
import java.util.List;

public class AddingGroups {
    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 10, 12, 19);
        integers.add(20); //运行时异常：java.lang.UnsupportedOperationException  因为Arrays.asList转化出来的List底层是数组，所以长度是固定的，不能增加或删除元素
    }
}
