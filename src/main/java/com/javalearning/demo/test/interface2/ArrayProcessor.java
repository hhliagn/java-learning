package com.javalearning.demo.test.interface2;

import java.util.Arrays;

public class ArrayProcessor implements Processor {
    @Override
    public String name() {
        return this.getClass().getSimpleName();
    }
    @Override
    public String process(Object input) {
        return Arrays.toString(((String) input).split(" "));
    }
}
