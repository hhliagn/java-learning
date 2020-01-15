package com.javalearning.demo.test.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericWriting {
    private static List<Fruit> fruits = new ArrayList<>();
    private static List<Apple> apples = new ArrayList<>();
    static <T> void writeExact(List<T> list, T item){
        list.add(item);
        System.out.println(list.size());
    }
    static <T> void writeWithWildCard(List<? super T> list, T item){
        list.add(item);
    }
    static void f1(){
        writeExact(fruits, new Apple());
        writeExact(apples, new Apple());
    }

    public static void main(String[] args) {
        f1();
    }
}
