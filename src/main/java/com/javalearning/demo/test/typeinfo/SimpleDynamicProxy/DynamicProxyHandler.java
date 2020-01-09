package com.javalearning.demo.test.typeinfo.SimpleDynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicProxyHandler implements InvocationHandler {
    private static long count = 0;
    private Object proxied;
    public DynamicProxyHandler(Object proxied){
        this.proxied = proxied;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (args != null){
            for (Object arg : args) {
                System.out.println(arg + " ");
            }
        }
        //这里可以加代理逻辑
        count++;
        return method.invoke(proxied, args);
    }

    public static long count(){
        return count;
    }
}
