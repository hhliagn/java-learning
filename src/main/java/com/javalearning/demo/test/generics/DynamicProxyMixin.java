package com.javalearning.demo.test.generics;

import com.javalearning.demo.test.generics.decoration.*;
import com.javalearning.demo.test.util.TwoTuple;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

import static com.javalearning.demo.test.util.Tuple.tuple;

class MixinProxy implements InvocationHandler{
    Map<String,Object> delegatesMethods;
    public MixinProxy(TwoTuple<Object, Class<?>>...pairs){
        delegatesMethods = new HashMap<>();
        for (TwoTuple<Object, Class<?>> pair : pairs) {
            for (Method method : pair.second.getMethods()) {
                String methodName = method.getName();
                if (!delegatesMethods.containsKey(methodName)){
                    delegatesMethods.put(methodName, pair.first);
                }
            }
        }
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String methodName = method.getName();
        Object o = delegatesMethods.get(methodName);
        return method.invoke(o, args);
    }

    @SuppressWarnings("unchecked")
    public static Object newInstance(TwoTuple...pairs){
        Class[] interfaces = new Class[pairs.length];
        for (int i = 0; i < pairs.length; i++) {
            interfaces[i] = (Class) pairs[i].second;
        }
        ClassLoader cl = pairs[0].first.getClass().getClassLoader();
        return Proxy.newProxyInstance(cl, interfaces, new MixinProxy(pairs));
    }
}
public class DynamicProxyMixin {
    public static void main(String[] args) {
        Object mixin = MixinProxy.newInstance(
                tuple(new BasicImpl(), Basic.class),
                tuple(new TimeStampImpl(), TimeStamp.class),
                tuple(new SerialNumberedImpl(), SerialNumbered.class)
        );
        Basic b = (Basic) mixin;
        b.set("hello");
        TimeStamp ts = (TimeStamp) mixin;
        SerialNumbered sn = (SerialNumbered) mixin;
        String s = b.get();
        Long timeStamp = ts.getTimeStamp();
        Long serialNumber = sn.getSerialNumber();
        System.out.println(s + " " + timeStamp + " " + serialNumber);
    }
}
