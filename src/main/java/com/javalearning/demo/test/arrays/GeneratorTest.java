package com.javalearning.demo.test.arrays;

import com.javalearning.demo.test.util.CountingGenerator;
import com.javalearning.demo.test.util.Generator;

public class GeneratorTest {
    public static int size = 10;
    public static void test(Class<?> surroundingClass) throws Exception {
        Class<?>[] classes = surroundingClass.getClasses();
        for (Class<?> aClass : classes) {
            System.out.print(aClass.getSimpleName() + ":");
            Generator<?> g = (Generator<?>) aClass.newInstance();
            for (int i = 0; i < size; i++) {
                System.out.print(g.next() + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws Exception {
        test(CountingGenerator.class);
    }
}
