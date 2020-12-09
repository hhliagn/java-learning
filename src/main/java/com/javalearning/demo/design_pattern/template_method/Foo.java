package com.javalearning.demo.design_pattern.template_method;

public abstract class Foo {

    public abstract int algs(int a, int b);

    public void handle(int a, int b){
        int ret = algs(a, b);
        System.out.println(ret);
    }
}
