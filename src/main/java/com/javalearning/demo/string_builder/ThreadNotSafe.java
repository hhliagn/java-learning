package com.javalearning.demo.string_builder;

public class ThreadNotSafe {

    StringBuffer b;

    public ThreadNotSafe() {
        b = new StringBuffer();
    }

    public String someMethod() {
        b.append("Some Method");
        return(b.toString());
    }
}
