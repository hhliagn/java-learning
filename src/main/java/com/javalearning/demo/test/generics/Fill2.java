package com.javalearning.demo.test.generics;

import com.javalearning.demo.test.generics.coffee.Coffee;
import com.javalearning.demo.test.generics.coffee.Latte;
import com.javalearning.demo.test.generics.coffee.Mocha;
import com.javalearning.demo.test.util.Generator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

interface Addable<T>{
    void add(T t);
}
public class Fill2 {
    public static <T> void fill(Addable<T> addable, Class<? extends T> classToken, int size){
        try{
            for (int i = 0; i < size; i++) {
                addable.add(classToken.newInstance());
            }
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
    public static <T> void fill(Addable<T> addable, Generator<T> generator, int size){
        for (int i = 0; i < size; i++) {
            addable.add(generator.next());
        }
    }
}
class AddableCollectionAdapter<T> implements Addable<T>{

    private Collection<T> c;
    public AddableCollectionAdapter(Collection<T> c){
        this.c = c;
    }
    @Override
    public void add(T t) {
        c.add(t);
    }
}
class Adapter{
    public static <T> Addable<T> collectionAdapter(Collection<T> c){
        return new AddableCollectionAdapter<T>(c);
    }
}
class AddableSimpleQueue<T> extends SimpleQueue<T> implements Addable<T>{
    public void add(T item){
        super.add(item);
    }
}
class Fill2Test{
    public static void main(String[] args) {
        List<Coffee> carrier = new ArrayList<>();
        Fill2.fill(new AddableCollectionAdapter<>(carrier), Coffee.class, 3);
        Fill2.fill(Adapter.collectionAdapter(carrier), Latte.class, 2);
        for (Coffee coffee : carrier) {
            System.out.println(coffee);
        }
        System.out.println("-----------");
        AddableSimpleQueue<Coffee> coffeeQueue = new AddableSimpleQueue<Coffee>();
        Fill2.fill(coffeeQueue, Mocha.class, 4);
        Fill2.fill(coffeeQueue, Latte.class, 1);
        for (Coffee coffee : coffeeQueue) {
            System.out.println(coffee);
        }
    }
}
