package com.javalearning.demo.test.DrawingSys;

public class Triangel extends Shape{
    public Triangel(int i){
        super(i);
        System.out.println("triangel constructor");
    }
    public void dispose(){
        System.out.println("triangel dispose");
        super.dispose();
    }
}
