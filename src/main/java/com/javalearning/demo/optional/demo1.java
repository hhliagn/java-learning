package com.javalearning.demo.optional;

import java.util.Optional;

public class demo1 {

    public static void main(String[] args) {
        // 使用Optional.of（）创建具有默认非空值的可选项。如果在of（）中传递null，则立即引发NullPointerException。
        Optional<Object> o = Optional.of(null);
    }
}
