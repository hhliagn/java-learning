package com.javalearning.demo.design_pattern.decorator.coffee;

public class SimpleCoffee implements Coffee {

    @Override
    public double getCost() {
        return 0.5;
    }

    @Override
    public String getIngredients() {
        return "coffee";
    }
}
