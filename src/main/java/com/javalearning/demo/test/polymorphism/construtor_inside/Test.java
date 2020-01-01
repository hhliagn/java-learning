package com.javalearning.demo.test.polymorphism.construtor_inside;

public class Test {
    public static void main(String[] args) {
        new RoundGlyph(10);
        //Glyph before draw
        //RoundGlyph drwa, field = 0
        //Glyph after draw
        //RoundGlyph drwa, field = 10
    }
}
