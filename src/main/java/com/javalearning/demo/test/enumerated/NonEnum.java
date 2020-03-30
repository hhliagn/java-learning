package com.javalearning.demo.test.enumerated;

public class NonEnum {
    public static void main(String[] args) {
        try {
            Class<Integer> integerClass = int.class;
            Integer[] enumConstants = integerClass.getEnumConstants();
            for (Integer enumConstant : enumConstants) {
                System.out.println(enumConstant);
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
