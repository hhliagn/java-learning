package com.javalearning.demo.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;

public class MyDynamicProxy {
    public static Hello withProxy(Object target, Class<?> clz){
        MyInvocationHandler handler = new MyInvocationHandler(target);
        return (Hello) Proxy.newProxyInstance(clz.getClassLoader(), new Class<?>[]{ clz }, handler);
    }
    public static  void main (String[] args) {
        // 构造代码实例
        Hello proxyHello = withProxy(new HelloImpl(), Hello.class);
        // 调用代理方法
        proxyHello.sayHello();

//        HashMap<Object, Integer> objectObjectHashMap = new HashMap<>();
//        objectObjectHashMap.merge("name", 1, Integer::sum);
//        objectObjectHashMap.toString();
    }
}
interface Hello {
    void sayHello();
}
class HelloImpl implements  Hello {
    @Override
    public void sayHello() {
        System.out.println("Hello World");
    }
}
class MyInvocationHandler implements InvocationHandler {
    private Object target;
    public MyInvocationHandler(Object target) {
        this.target = target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        System.out.println("Invoking sayHello");
        Object result = method.invoke(target, args);
        return result;
    }
}
