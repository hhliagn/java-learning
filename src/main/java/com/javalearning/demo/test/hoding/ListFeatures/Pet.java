package com.javalearning.demo.test.hoding.ListFeatures;

public class Pet {
    private static int id;
    private long counter = id ++;
    public Pet(){
    }

    @Override
    public String toString() {
        return "Pet " + counter;
    }
}
