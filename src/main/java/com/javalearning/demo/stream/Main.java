package com.javalearning.demo.stream;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author lhh
 * @date 2021/3/15
 */
public class Main {

    /**
     * 使用stream流先根据字母出现次数排序再根据字母降序排序
     * 如：String s = "BBAACCC"，则排序后结果为一个Map，Map里内容为C3B2A2
     * @param args
     */
    public static void main(String[] args) {
        String s="BBAACCC";
        List<String> strings = Arrays.asList(s.split(""));
        Map<String, Long> collect = strings.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        // 倒序
        Map<String, Long> result = new TreeMap<>(Comparator.reverseOrder());
        for (String item: collect.keySet()) {
            result.put(item,collect.get(item));
        }
        System.out.println(result);
    }
}
