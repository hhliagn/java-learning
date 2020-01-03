package com.javalearning.demo.test.interface2;

public class UpperProcessor implements Processor {
    @Override
    public String name() {
        return this.getClass().getSimpleName();
    }
    @Override
    public String process(Object input) {
        return ((String) input).toUpperCase();
    }
}
