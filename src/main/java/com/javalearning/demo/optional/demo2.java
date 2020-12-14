package com.javalearning.demo.optional;

import java.util.Optional;

public class demo2 {

    public static void main(String[] args) {
        // 如果存在可选值，则执行某些操作（里面可以接一个Consumer进行消费）
        Object o = new Object();
        Optional.ofNullable(o).ifPresent(System.out::println);
    }
}
