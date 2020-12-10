package com.javalearning.demo.design_pattern.factory.demo1;

public class Main {

    public static void main(String[] args) {
        Product product = null;
        String productType = "Fan";
        Factory factory = getFactory(productType);
        if (factory != null){
            product = factory.produce();
        }

        System.out.println(product);
    }

    private static Factory getFactory(String productType) {
        switch (productType) {
            case "Fan":
                return new FanFactory();
            case "Toy":
                return new ToyFactory();
            default:
                return null;
        }
    }
}
