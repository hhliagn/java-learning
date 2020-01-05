package com.javalearning.demo.test.inner_class.callback;

public class Caller {
    private Incrementable incrementable;
    public Caller(Incrementable incrementable){
        this.incrementable = incrementable;
    }
    public void go(){
        incrementable.increment();
    }
}
