package com.javalearning.demo.test.enumerated;

enum Shrubbery{
    GROUND, CRAWLING, HANGING
}
public class EnumClass {

    private Shrubbery shrubbery;

    public EnumClass(Shrubbery shrubbery) {
        this.shrubbery = shrubbery;
    }

    public static void main(String[] args) {
        for (Shrubbery value : Shrubbery.values()) {
            System.out.println("ordinal: " + value.ordinal());
            System.out.println("equals CRAWLING? : " + value.equals(Shrubbery.CRAWLING));
            System.out.println("== CRAWLING? : " + (value == Shrubbery.CRAWLING));
            System.out.println("compareTo CRAWLING: " + value.compareTo(Shrubbery.CRAWLING));
            System.out.println(value.getDeclaringClass());
            System.out.println("-----------------------");
        }

        String[] split = "GROUND CRAWLING HANGING".split(" ");
        for (String s : split) {
            Shrubbery shrubbery = Enum.valueOf(Shrubbery.class, s);
            System.out.println(shrubbery);
        }

    }
}
