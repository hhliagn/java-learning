package com.javalearning.demo.test.typeinfo.toys.pets.creator;

import com.javalearning.demo.test.typeinfo.toys.pets.Pet;
import com.javalearning.demo.test.typeinfo.toys.pets.PetCreator;

import java.util.ArrayList;
import java.util.List;

public class ForNameCreator extends PetCreator {
    private static List<Class<? extends Pet>> types = new ArrayList<>();
    @Override
    public List<Class<? extends Pet>> types() {
        return types;
    }
    private static String[] typeNames = {
            "com.javalearning.demo.test.typeinfo.toys.pets.Mutt",
            "com.javalearning.demo.test.typeinfo.toys.pets.Pug",
            "com.javalearning.demo.test.typeinfo.toys.pets.EgyptianMau",
            "com.javalearning.demo.test.typeinfo.toys.pets.Manx",
            "com.javalearning.demo.test.typeinfo.toys.pets.Cymric",
            "com.javalearning.demo.test.typeinfo.toys.pets.Rat",
            "com.javalearning.demo.test.typeinfo.toys.pets.Mouse",
            "com.javalearning.demo.test.typeinfo.toys.pets.Hamster"
    };
    @SuppressWarnings("unchecked")
    public static void loader(){
        for (String typeName : typeNames) {
            try {
                types.add((Class<? extends Pet>) Class.forName(typeName));
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }
    static {
        loader();
    }
}
