package com.javalearning.demo.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class demo17 {

    /**
     * java.util.function.Function<T,R>`接口用来根据一个类型的数据得到另一个类型的数据，前者称为前置条件，后者称为后置条件。有进有出，所以称为“函数Function”。
     */
    public static void main(String[] args) {
        List<String> strList = new ArrayList<>();
        strList.add("123");
        strList.add("456");
        strList.add("789");
        strList.add("110");
        strList.add("424");

        Function<String,Integer> f1 = s -> Integer.parseInt(s);
        Function<Integer, Integer> f2 = s -> s+100;

        List<Integer> collect = strList.stream().map(f1.andThen(f2)).collect(Collectors.toList());
        System.out.println(collect);
    }
}
