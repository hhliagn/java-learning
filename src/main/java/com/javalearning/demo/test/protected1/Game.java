package com.javalearning.demo.test.protected1;

public class Game {
    private String name;
    protected void play(){
        System.out.println("playing" + name);
    }
    protected void set(String name){
        this.name = name;
    }
}
