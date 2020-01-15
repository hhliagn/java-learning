package com.javalearning.demo.test.generics.CRGWithBasicHolder;

public class BasicHolder<T> {
    T element;
    public void set(T item){
        this.element = item;
    }
    public T get(){
        return element;
    }
    void f(){
        System.out.println(element.getClass().getSimpleName());
    }
}
