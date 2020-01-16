package com.javalearning.demo.test.generics;

import com.javalearning.demo.test.util.TwoTuple;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

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
        return null;
    }
}
public class DynamicProxyMixin {
}
