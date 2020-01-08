package com.javalearning.demo.test.typeinfo.toysss.pets;

import java.util.ArrayList;
import java.util.List;

public class ForNameCreator extends PetCreator {
    private static List<Class<? extends Pet>> types = new ArrayList<>();
    @Override
    public List<Class<? extends Pet>> types() {
        return types;
    }
    private static String[] typeNames = {
            "",
            "",
            ""
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
