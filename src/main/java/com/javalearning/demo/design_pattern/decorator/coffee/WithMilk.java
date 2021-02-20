package com.javalearning.demo.design_pattern.decorator.coffee;

public class WithMilk extends CoffeeDecorator {

    public WithMilk(Coffee coffeeToBeDecorate) {
        super(coffeeToBeDecorate);
    }

    @Override
    public double getCost() {
        return super.getCost() + 0.2;
    }

    @Override
    public String getIngredients() {
        return super.getIngredients() + ", milk";
    }
}
