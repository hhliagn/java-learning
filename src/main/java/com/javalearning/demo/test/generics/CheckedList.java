package com.javalearning.demo.test.generics;

import com.javalearning.demo.test.typeinfo.toys.pets.Dog;
import java.util.ArrayList;
import java.util.List;

public class CheckedList {
    public static void main(String[] args) {
        ArrayList<Dog> dogs = new ArrayList<>();
        addSomething(dogs, new Dog());
//        dogs.add(new Cat());
    }
    public static <T> void addSomething(List<T> list, T args){
        list.add(args);
    }
}
