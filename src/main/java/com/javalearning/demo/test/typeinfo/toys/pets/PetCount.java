package com.javalearning.demo.test.typeinfo.toys.pets;

import java.util.HashMap;

public class PetCount {
    static class PetCounter extends HashMap<String,Integer>{
        public void count(String type){
            Integer integer = get(type);
            if (integer == null) {
                put(type, 1);
            }else {
                put(type, integer + 1);
            }
        }
    }
    public static void countPets(PetCreator creator){
        PetCounter petCounter = new PetCounter();
        for (Pet pet : creator.createArray(20)) {
            if (pet instanceof Pet){
                petCounter.count(pet.getClass().getSimpleName());
            }
            //...
        }
        System.out.println(petCounter);
    }
}

