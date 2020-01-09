package com.javalearning.demo.test.typeinfo.toys.pets.creator;

import com.javalearning.demo.test.typeinfo.toys.pets.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LiteralPetCreator extends PetCreator {
    private static final List<Class<? extends Pet>>  allTypes = Collections.unmodifiableList(Arrays.asList(
            Pet.class, Dog.class, Cat.class, Rodent.class,
            Mutt.class,Manx.class,Cymric.class,Pug.class,EgyptianMau.class,
            Rat.class,Mouse.class,Hamster.class
    ));
    private static final List<Class<? extends Pet>> types = allTypes.subList(allTypes.indexOf(Mutt.class), allTypes.size());
    @Override
    public List<Class<? extends Pet>> types() {
        return types;
    }
    public static void main(String[] args) {
        System.out.println(types);
    }
}
