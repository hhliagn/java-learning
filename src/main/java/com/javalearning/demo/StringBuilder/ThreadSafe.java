package com.javalearning.demo.StringBuilder;

public class ThreadSafe {

    public String someMethod() {
        StringBuilder b = new StringBuilder();
        b.append("Some Method");
        return(b.toString());
    }
}
