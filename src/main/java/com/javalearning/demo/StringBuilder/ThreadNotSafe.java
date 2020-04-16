package com.javalearning.demo.StringBuilder;

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
