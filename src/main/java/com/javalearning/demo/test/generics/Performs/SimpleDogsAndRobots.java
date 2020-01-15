package com.javalearning.demo.test.generics.Performs;

class SimpleCommunicate{
    static void perform(Performs performs){
        performs.speak();
        performs.sit();
    }
}
public class SimpleDogsAndRobots {
    public static void main(String[] args) {
        SimpleCommunicate.perform(new PerformingDog());
        SimpleCommunicate.perform(new Robot());
    }
}
