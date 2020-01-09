package com.javalearning.demo.test.typeinfo.SimpleProxyDemo;

public class SimpleProxy implements Interface1 {
    private static int count = 0;
    private Interface1 proxied;

    public SimpleProxy(Interface1 proxied){
        this.proxied = proxied;
    }

    @Override
    public void doSomething() {
        System.out.println("simple proxy do something: ");
        proxied.doSomething();
        count++;
    }

    @Override
    public void somethingElse(String args) {
        System.out.println("simple proxy something else: " + args);
        proxied.somethingElse(args);
        count++;
    }

    public long count(){
        return count;
    }
}
