package com.javalearning.demo.test.util;

import java.util.LinkedList;

public class Stack<T> {
    private LinkedList<T> storage = new LinkedList<>();
    public void push(T t){
        this.storage.addFirst(t);
    }
    public T peek(){
        return this.storage.getFirst();
    }
    public T pop(){
        return this.storage.removeFirst();
    }
    public boolean isEmpty(){
        return this.storage.isEmpty();
    }

    @Override
    public String toString() {
        return this.storage.toString();
    }
}
