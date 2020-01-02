package com.javalearning.demo.test.factory_pattern;

public class Factories {
    public static void service_consume(ServiceFactory serviceFactory){
        Service service = serviceFactory.getService();
        service.method1();
        service.method2();
    }
    public static void main(String[] args) {
        service_consume(new Impl1Fact());
        service_consume(new Impl2Fact());
    }
}
