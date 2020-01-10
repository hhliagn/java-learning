package com.javalearning.demo.test.generics.Manipulate;

public class ReturnGenericType<T extends HasF> {
    private T obj;
    public ReturnGenericType(T obj){
        this.obj = obj;
    }

    public T get(){
        return obj;
    }
}
