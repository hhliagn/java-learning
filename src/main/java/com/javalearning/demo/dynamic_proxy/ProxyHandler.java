package com.javalearning.demo.dynamic_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ProxyHandler implements InvocationHandler {

    private Object target;

    public ProxyHandler(Object target) {
        this.target = target;
    }

    /**
     * 对proxy对象任何的调用都会进这个方法，所有在这个方法中要小心使用proxy对象，很容易引起循环调用
     * @param proxy
     * @param method
     * @param args
     * @return
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) {

        System.out.println("before...");
        Object result = null;

        System.out.println(target);

        //这行代码会无限调用toString
//        System.out.println(proxy);

        try {
            System.out.println(method);
            result = method.invoke(target, args);

            //这行代码会无限调用toString
//            result = method.invoke(proxy, args);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }finally {
            System.out.println("after...");
        }

        return result;
    }
}
