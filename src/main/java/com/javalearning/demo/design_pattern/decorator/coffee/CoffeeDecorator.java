package com.javalearning.demo.design_pattern.decorator.coffee;

public abstract class CoffeeDecorator implements Coffee {

    private Coffee coffeeToBeDecorate;

    public CoffeeDecorator(Coffee coffeeToBeDecorate) {
        this.coffeeToBeDecorate = coffeeToBeDecorate;
    }

    @Override
    public double getCost() {
        return coffeeToBeDecorate.getCost();
    }

    @Override
    public String getIngredients() {
        return coffeeToBeDecorate.getIngredients();
    }
}
