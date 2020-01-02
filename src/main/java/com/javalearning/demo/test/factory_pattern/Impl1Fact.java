package com.javalearning.demo.test.factory_pattern;

public class Impl1Fact implements ServiceFactory {
    @Override
    public Service getService() {
        return new Impl1();
    }
}
