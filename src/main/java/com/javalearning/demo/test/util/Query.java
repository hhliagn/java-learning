package com.javalearning.demo.test.util;

import java.util.LinkedList;

public class Query<T> {
    private LinkedList<T> storage = new LinkedList<>();
    public void insert(T t){
        this.storage.addLast(t);
    }
    public T peek(){
        return this.storage.peek();
    }
    public T pop(){
        return this.storage.poll();
    }
    public boolean isEmpty(){
        return this.storage.isEmpty();
    }

    @Override
    public String toString() {
        return this.storage.toString();
    }
}
