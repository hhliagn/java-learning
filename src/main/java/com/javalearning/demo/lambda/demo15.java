package com.javalearning.demo.lambda;

import java.util.function.Consumer;

public class demo15 {

    /**
     * Consumer<T>：消费者，负责消费数据
     * 	抽象方法：void accpet(T t); 消费指定类型的数据
     * 	默认方法：default Consumer<T> andThen(Consumer<T>() two) 按顺序执行多个消费操作。
     */
    public static void main(String[] args) {

        String[] array = { "迪丽热巴,女", "古力娜扎,女", "马尔扎哈,男" };
        Consumer<String> c1 = (str) -> System.out.print(str.split(",")[0] + "=");
        Consumer<String> c2 = (str) -> System.out.print(str.split(",")[1] + " ");

        for (String s : array) {
            c1.andThen(c2).accept(s);
        }
    }
}
