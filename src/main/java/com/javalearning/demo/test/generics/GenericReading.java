package com.javalearning.demo.test.generics;

import java.util.Arrays;
import java.util.List;

public class GenericReading {
    static List<Fruit> fruits = Arrays.asList(new Fruit());
    static List<Apple> apples = Arrays.asList(new Apple());
    static <T> T readExact(List<T> list){
        return list.get(0);
    }
    static class Reader<T>{
        T readExact(List<T> list){
            return list.get(0);
        }
    }
    static class ConvariantReader<T>{
        T readExact(List<? extends T> list){
            return list.get(0);
        }
    }
    static void f1(){
        Fruit f = readExact(fruits);
        Apple a = readExact(apples);
        f = readExact(apples);
    }
    static void f2(){
        Reader<Fruit> fruitReader = new Reader<>();
        Fruit fruit = fruitReader.readExact(fruits);
//        fruitReader.readExact(apples);
    }
    static void f3(){
        ConvariantReader<Fruit> fruitConvariantReader = new ConvariantReader<>();
        Fruit fruit = fruitConvariantReader.readExact(fruits);
        Fruit fruit1 = fruitConvariantReader.readExact(apples);
    }

    public static void main(String[] args) {
        f1();
        f2();
        f3();
    }
}
