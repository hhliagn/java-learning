package com.javalearning.demo.designpattern.adapter;

import java.util.Collection;

interface Addable<T>{
    void add(T t);
}
public class AddableCollectionAdapter<T> implements Addable<T> {

    private Collection<T> c;

    public AddableCollectionAdapter(Collection<T> c){
        this.c = c;
    }

    @Override
    public void add(T t) {
        c.add(t);
    }
}
