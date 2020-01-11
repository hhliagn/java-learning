package com.javalearning.demo.test.generics.fibonacci;

import java.util.Iterator;

public class IterableFibonacci2 implements Iterable<Integer> {
    private int n;
    public IterableFibonacci2(int n){
        this.n = n;
    }
    private Fibonacci fibonacci = new Fibonacci();
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return n > 0;
            }

            @Override
            public Integer next() {
                n --;
                return fibonacci.next();
            }
        };
    }

    public static void main(String[] args) {
        for (Integer integer : new IterableFibonacci2(18)) {
            System.out.print(integer + " ");
        }
        System.out.println();
    }
}
