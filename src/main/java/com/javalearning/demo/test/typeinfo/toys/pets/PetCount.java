package com.javalearning.demo.test.typeinfo.toys.pets;

import com.javalearning.demo.test.typeinfo.toys.pets.creator.ForNameCreator;

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
            if (pet instanceof Dog){
                petCounter.count(pet.getClass().getSimpleName());
            }
            if (pet instanceof Mutt){
                petCounter.count(pet.getClass().getSimpleName());
            }
            if (pet instanceof Pug){
                petCounter.count(pet.getClass().getSimpleName());
            }
            if (pet instanceof Cat){
                petCounter.count(pet.getClass().getSimpleName());
            }
            if (pet instanceof EgyptianMau){
                petCounter.count(pet.getClass().getSimpleName());
            }
            if (pet instanceof Manx){
                petCounter.count(pet.getClass().getSimpleName());
            }
            if (pet instanceof Cymric){
                petCounter.count(pet.getClass().getSimpleName());
            }
            if (pet instanceof Rodent){
                petCounter.count(pet.getClass().getSimpleName());
            }
            if (pet instanceof Rat){
                petCounter.count(pet.getClass().getSimpleName());
            }
            if (pet instanceof Mouse){
                petCounter.count(pet.getClass().getSimpleName());
            }
            if (pet instanceof Hamster){
                petCounter.count(pet.getClass().getSimpleName());
            }
        }
        System.out.println(petCounter);
    }

    public static void main(String[] args) {
        countPets(new ForNameCreator());
    }
}

