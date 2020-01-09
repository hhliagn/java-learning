package com.javalearning.demo.test.typeinfo.toys.pets;

import com.javalearning.demo.test.typeinfo.toys.pets.creator.LiteralPetCreator;

import java.util.List;

public class Pets {
    private static final PetCreator petCreator = new LiteralPetCreator();
    public static Pet randomPet(){
        return petCreator.randomPet();
    }
    public static Pet[] createArray(int size){
        return petCreator.createArray(size);
    }
    public static List<Pet> arrayList(int size){
        return petCreator.arrayList(size);
    }
}
