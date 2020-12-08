package com.javalearning.demo.dynamic_proxy;

import java.lang.reflect.Proxy;

public class Main {

    public static void main(String[] args) {

        User user = new User();
        People agent
                = (People) Proxy.newProxyInstance(
                        user.getClass().getClassLoader(),
                        user.getClass().getInterfaces(),
                        new ProxyHandler(user));
        agent.eat("Apple");
    }
}
