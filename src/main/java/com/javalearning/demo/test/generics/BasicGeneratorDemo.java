package com.javalearning.demo.test.generics;

import com.javalearning.demo.test.util.BasicGenerator;
import com.javalearning.demo.test.util.Generator;

public class BasicGeneratorDemo {
    public static void main(String[] args) {
        Generator<CountedObject> countedObjectGenerator = BasicGenerator.create(CountedObject.class);
        for (int i = 0; i < 10; i++) {
            CountedObject next = countedObjectGenerator.next();
            System.out.println(next);
        }
    }
}
