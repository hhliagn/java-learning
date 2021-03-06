package com.javalearning.demo.test.factory_pattern;

public class Impl2 implements Service {
    @Override
    public void method1() {
        System.out.println("impl2 method1");
    }

    @Override
    public void method2() {
        System.out.println("impl2 method2");
    }

    public static ServiceFactory serviceFactory(){
        return new ServiceFactory() {
            @Override
            public Service getService() {
                return new Impl2();
            }
        };
    }
}
