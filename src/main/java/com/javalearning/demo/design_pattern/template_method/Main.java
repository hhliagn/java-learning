package com.javalearning.demo.design_pattern.template_method;

public class Main {

    public static void main(String[] args) {

        int a = 10, b = 5;
        Foo foo = null;

        foo = new Add();
        foo.handle(a, b);

        foo = new Sub();
        foo.handle(a, b);
    }
}
