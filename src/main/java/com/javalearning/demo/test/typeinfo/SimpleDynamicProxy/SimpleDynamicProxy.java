package com.javalearning.demo.test.typeinfo.SimpleDynamicProxy;

import com.javalearning.demo.test.typeinfo.SimpleProxyDemo.Interface1;
import com.javalearning.demo.test.typeinfo.SimpleProxyDemo.RealObject;

import java.lang.reflect.Proxy;

public class SimpleDynamicProxy {
    public static void consumer(Interface1 interface1){
        interface1.doSomething();
        interface1.somethingElse("lhh dynamic");
    }

    public static void main(String[] args) {
        RealObject realObject = new RealObject();
        consumer(realObject);

        Interface1 proxy = (Interface1) Proxy.newProxyInstance(
                Interface1.class.getClassLoader(),
                new Class[]{Interface1.class},
                new DynamicProxyHandler(realObject)
        );
        for (int i = 0; i < 10; i++) {
            consumer(proxy);
        }
        System.out.println(DynamicProxyHandler.count());
    }
}
