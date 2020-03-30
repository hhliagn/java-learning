package com.javalearning.demo.test.enumerated;

public class Burrito {

    Spiciness degree;

    public Burrito(Spiciness degree) {
        this.degree = degree;
    }

    @Override
    public String toString() {
        return "Burrito{" +
                "degree=" + degree +
                '}';
    }

    public static void main(String[] args) {
        Burrito burrito1 = new Burrito(Spiciness.NOT);
        Burrito burrito2 = new Burrito(Spiciness.MEDIUM);
        Burrito burrito3 = new Burrito(Spiciness.FLAMING);

        System.out.println(burrito1);
        System.out.println(burrito2);
        System.out.println(burrito3);

    }
}
