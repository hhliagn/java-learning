package com.javalearning.demo.test.typeinfo.toys;

import com.javalearning.demo.test.typeinfo.toys.FancyToy;

public class GenericToyTest {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Class<FancyToy> ftClass = FancyToy.class;
        FancyToy fancyToy = ftClass.newInstance();
        Class<? super FancyToy> superclass = ftClass.getSuperclass();
//        Class<Toy> superclass1 = ftClass.getSuperclass();
        Object object = superclass.newInstance();
    }
}