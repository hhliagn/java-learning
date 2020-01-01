package com.javalearning.demo.test.polymorphism.construtor_inside;

public class Glyph {
    public Glyph(){
        System.out.println("Glyph before draw");
        draw();
        System.out.println("Glyph after draw");
    }
    public void draw(){
        System.out.println("Glyph draw");
    }
}
