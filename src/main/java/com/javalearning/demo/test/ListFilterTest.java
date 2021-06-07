package com.javalearning.demo.test;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author lhh
 * @date 2021/5/15
 */
public class ListFilterTest {

    public static void main(String[] args) {
        List<String> list = Lists.newArrayList("aaa");

        List<String> aaa = list.stream()
                .filter(k -> !k.equals("aaa"))
                .collect(Collectors.toList());

        System.out.println(aaa);
    }
}
