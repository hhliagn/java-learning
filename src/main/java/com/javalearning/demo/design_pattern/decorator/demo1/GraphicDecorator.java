package com.javalearning.demo.design_pattern.decorator.demo1;

public class GraphicDecorator implements Compoent {

    private Compoent compoent;

    public GraphicDecorator(Compoent compoent) {
        this.compoent = compoent;
    }

    @Override
    public void print() {
        this.compoent.print();
        System.out.println("Compoent was decorated by graphic..");
    }
}
