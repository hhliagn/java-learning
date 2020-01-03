package com.javalearning.demo.test.factory_pattern;

public class Factories {
    public static void service_consume(ServiceFactory serviceFactory){
        Service service = serviceFactory.getService();
        service.method1();
        service.method2();
    }
    public static void main(String[] args) {
        service_consume(Impl1.serviceFactory());
        service_consume(Impl2.serviceFactory());
    }
}
