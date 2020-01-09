package com.javalearning.demo.test.typeinfo.toys.pets;

import com.javalearning.demo.test.typeinfo.toys.pets.creator.LiteralPetCreator;

public class PetCount2 {
    public static void main(String[] args) {
        PetCount.countPets(new LiteralPetCreator());
    }
}
