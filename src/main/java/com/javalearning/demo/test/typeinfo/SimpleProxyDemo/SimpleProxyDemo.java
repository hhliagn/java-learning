package com.javalearning.demo.test.typeinfo.SimpleProxyDemo;

public class SimpleProxyDemo {
    public static void consumer(Interface1 interface1){
        interface1.doSomething();
        interface1.somethingElse("lhh");
    }

    public static void main(String[] args) {
        consumer(new RealObject());
        consumer(new SimpleProxy(new RealObject()));
    }
}
