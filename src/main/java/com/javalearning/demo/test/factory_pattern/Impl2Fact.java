package com.javalearning.demo.test.factory_pattern;

public class Impl2Fact implements ServiceFactory {
    @Override
    public Service getService() {
        return new Impl2();
    }
}
