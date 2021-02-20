package com.javalearning.demo.design_pattern.decorator.coffee;

public class WithSprinkles extends CoffeeDecorator {

    public WithSprinkles(Coffee coffeeToBeDecorate) {
        super(coffeeToBeDecorate);
    }

    @Override
    public double getCost() {
        return super.getCost() + 0.3;
    }

    @Override
    public String getIngredients() {
        return super.getIngredients() + ", sprinkles";
    }
}
