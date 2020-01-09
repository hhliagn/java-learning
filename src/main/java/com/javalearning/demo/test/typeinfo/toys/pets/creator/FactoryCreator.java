package com.javalearning.demo.test.typeinfo.toys.pets.creator;

import com.javalearning.demo.test.typeinfo.toys.pets.Cat;
import com.javalearning.demo.test.typeinfo.toys.pets.Pet;
import com.javalearning.demo.test.typeinfo.toys.pets.PetCreator;

import java.util.ArrayList;
import java.util.List;

public class FactoryCreator extends PetCreator {
    private static List<Class<? extends Pet>> types = new ArrayList<>();
    static {
        types.add(new Cat.factory().create().getClass());
        //...
    }

    @Override
    public List<Class<? extends Pet>> types() {
        return types;
    } 
}
