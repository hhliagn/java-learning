package com.javalearning.demo.test.generics.HijackedInterface;

public class ComparablePet implements Comparable<ComparablePet>{

    @Override
    public int compareTo(ComparablePet o) {
        return 0;
    }
}
