package com.javalearning.demo.optional;

import java.util.Optional;

public class demo3 {

    public static void main(String[] args) {
        // orElse 和 orElseThrow，不存在值时的动作
        Object o = new Object();
        Optional.ofNullable(o).orElse(new Object());
        Optional.ofNullable(o).orElseThrow(() -> new RuntimeException("Object is Null"));
    }
}
