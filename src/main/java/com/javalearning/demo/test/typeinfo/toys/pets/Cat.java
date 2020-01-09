package com.javalearning.demo.test.typeinfo.toys.pets;

import com.javalearning.demo.test.typeinfo.toys.RegisteredFactory.Factory;

public class Cat extends Pet {
    public Cat(){

    }
    public Cat(String name){
        super(name);
    }
    public static class factory implements Factory<Cat>{

        @Override
        public Cat create() {
            return new Cat();
        }
    }
}