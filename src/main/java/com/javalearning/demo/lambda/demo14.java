package com.javalearning.demo.lambda;

import java.util.function.Consumer;

public class demo14 {

    /**
     * Consumer<T>：消费者，负责消费数据
     * 	抽象方法：void accpet(T t); 消费指定类型的数据
     * 	默认方法：default Consumer<T> andThen(Consumer<T>() two) 按顺序执行多个消费操作。
     */
    public static void main(String[] args) {

        Consumer<String> c1 = (str) -> System.out.println(str.toUpperCase());
        Consumer<String> c2 = (str) -> System.out.println(str.toLowerCase());
        Consumer<String> c3 = (str) -> System.out.println(str.toUpperCase());

        c1.andThen(c2).andThen(c3).accept("wo shi ni die");

    }
}
