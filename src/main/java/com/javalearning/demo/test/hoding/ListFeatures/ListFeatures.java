package com.javalearning.demo.test.hoding.ListFeatures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ListFeatures {
    public static void main(String[] args) {
        //init
        List<Pet> pets = new ArrayList<>();
        pets.add(new Pet());
        pets.add(new Pet());
        pets.add(new Pet());
        pets.add(new Pet());
        pets.add(new Pet());

        Random random = new Random();
        Collections.shuffle(pets, random);

        List<Pet> pets2 = new ArrayList<>();
        pets.add(new Pet());
        pets.add(new Pet());

        pets.retainAll(pets2);
    }
}
