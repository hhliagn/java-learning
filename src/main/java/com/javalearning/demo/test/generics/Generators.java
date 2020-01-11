package com.javalearning.demo.test.generics;

import com.javalearning.demo.test.generics.coffee.Coffee;
import com.javalearning.demo.test.generics.fibonacci.Fibonacci;
import com.javalearning.demo.test.util.CoffeeGenerator;
import com.javalearning.demo.test.util.Generator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class Generators {
    public static <T> Collection<T> fill(Collection<T> collection, Generator<T> generator, int n){
        for (int i = 0; i < n; i++) {
            collection.add(generator.next());
        }
        return collection;
    }

    public static <T> List<T> fill(List<T> collection, Generator<T> generator, int n){
        for (int i = 0; i < n; i++) {
            collection.add(generator.next());
        }
        return collection;
    }

    public static void main(String[] args) {
        List<Coffee> fill = Generators.fill(new ArrayList<Coffee>(), new CoffeeGenerator(), 10);
        for (Coffee coffee : fill) {
            System.out.print(coffee + " ");
        }
        System.out.println();
        System.out.println(fill.getClass().getSimpleName());

        List<Coffee> fill0 = Generators.fill(new LinkedList<Coffee>(), new CoffeeGenerator(), 10);
        for (Coffee coffee : fill0) {
            System.out.print(coffee + " ");
        }
        System.out.println();
        System.out.println(fill0.getClass().getSimpleName());

        Collection<Integer> fill1 = Generators.fill(new ArrayList<Integer>(), new Fibonacci(), 12);
        for (Integer integer : fill1) {
            System.out.print(integer + " ");
        }
        System.out.println();
    }
}
