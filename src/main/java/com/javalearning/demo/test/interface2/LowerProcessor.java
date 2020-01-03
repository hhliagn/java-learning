package com.javalearning.demo.test.interface2;

public class LowerProcessor implements Processor {
    @Override
    public String name() {
        return this.getClass().getSimpleName();
    }

    @Override
    public String process(Object input) {
        return ((String) input).toLowerCase();
    }
}
