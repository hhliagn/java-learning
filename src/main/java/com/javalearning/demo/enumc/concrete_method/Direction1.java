package com.javalearning.demo.enumc.concrete_method;

public enum  Direction1 {

    EAST, NORTH, WEST, SOUTH;

    public String printDirection(){
        String message = "You're moving in " + this + " direction.";
        System.out.println(message);
        return message;
    }
}
