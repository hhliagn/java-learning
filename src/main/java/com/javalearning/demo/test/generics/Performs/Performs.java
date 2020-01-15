package com.javalearning.demo.test.generics.Performs;

import com.javalearning.demo.test.typeinfo.toys.pets.Dog;

public interface Performs {
    void speak();
    void sit();
}
class PerformingDog extends Dog implements Performs{

    @Override
    public void speak() {
        System.out.println("woof.");
    }

    @Override
    public void sit() {
        System.out.println("sitting.");
    }
}
class Robot implements Performs{

    @Override
    public void speak() {
        System.out.println("click");
    }

    @Override
    public void sit() {
        System.out.println("clank");
    }
}
class Communicate{
    public static <T extends Performs> void perform(T performer){
        performer.speak();
        performer.sit();
    }
}