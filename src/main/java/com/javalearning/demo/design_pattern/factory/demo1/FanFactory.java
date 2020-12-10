package com.javalearning.demo.design_pattern.factory.demo1;

public class FanFactory implements Factory {

    @Override
    public Product produce() {
        return new Fan();
    }
}
