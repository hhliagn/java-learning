package com.javalearning.demo.design_pattern.strategy.demo1;

public class Add implements AlgsStrategy {

    @Override
    public int algs(int a, int b) {
        int ret = a + b;
        return ret;
    }
}
