package com.javalearning.demo.test.util;

import com.javalearning.demo.test.generics.coffee.*;

import java.util.Iterator;
import java.util.Random;

public class CoffeeGenerator implements Generator<Coffee>, Iterable<Coffee>  {
    private Class[] types = {
            Latte.class, Mocha.class, Cappuccino.class, Breve.class, Americano.class
    };
    private static Random random = new Random(47);
    private int count = 0;
    public CoffeeGenerator(){}
    public CoffeeGenerator(int count){
        this.count = count;
    }
    @Override
    public Coffee next() {
        try {
            return (Coffee) types[random.nextInt(types.length)].newInstance();
        } catch (Exception e) {
          throw new RuntimeException(e);
        }
    }

    class CoffeeIterator implements Iterator<Coffee>{
        private int n = count;

        @Override
        public boolean hasNext() {
            return n > 0;
        }

        @Override
        public Coffee next() {
            n --;
            return CoffeeGenerator.this.next();
        }
    }

    @Override
    public Iterator<Coffee> iterator() {
        return new CoffeeIterator();
    }

    public static void main(String[] args) {
        CoffeeGenerator coffees = new CoffeeGenerator();
        for (int i = 0; i < 5; i++) {
            Coffee next = coffees.next();
            System.out.println(next);
        }
        CoffeeGenerator coffees1 = new CoffeeGenerator(5);
        for (Coffee coffee : coffees1) {
            System.out.println(coffee);
        }
    }
}
