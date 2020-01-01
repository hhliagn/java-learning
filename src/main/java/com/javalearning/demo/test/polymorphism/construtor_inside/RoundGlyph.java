package com.javalearning.demo.test.polymorphism.construtor_inside;

public class RoundGlyph extends Glyph {
    private int field;
    public RoundGlyph(int field){
        this.field = field;
        System.out.println("RoundGlyph drwa, field = " + field);
    }

    @Override
    public void draw() {
        System.out.println("RoundGlyph drwa, field = " + field);
    }
}
