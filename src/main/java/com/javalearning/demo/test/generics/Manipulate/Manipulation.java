package com.javalearning.demo.test.generics.Manipulate;

public class Manipulation {
    public static void main(String[] args) {
        HasF hf = new HasF();
        Manipulator<HasF> hasFManipulator = new Manipulator<>(hf);
        hasFManipulator.manipute();
    }
}
