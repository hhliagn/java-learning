package com.javalearning.demo.test.factory_pattern;

public class Impl1 implements Service {
    @Override
    public void method1() {
        System.out.println("impl1 method1");
    }

    @Override
    public void method2() {
        System.out.println("impl1 method2");
    }

    public static ServiceFactory serviceFactory(){
        return new ServiceFactory() {
            @Override
            public Service getService() {
                return new Impl1();
            }
        };
    }
}
