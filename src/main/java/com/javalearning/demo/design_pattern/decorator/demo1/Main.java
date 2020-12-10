package com.javalearning.demo.design_pattern.decorator.demo1;

public class Main {

    public static void main(String[] args) {
        Compoent finalCompoent = new FlowerDecorator(
                new GraphicDecorator(new Room()));
        consume(finalCompoent);
    }

    public static void consume(Compoent compoent){
        compoent.print();
    }
}
