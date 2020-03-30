package com.javalearning.demo.test.enumerated;

public enum  OzWitch {

    WEST("this is WEST"),
    EAST("this is EAST"),
    NORTH("this is NORTH"),
    SOUTH("this is SOUTH"),
    ;

    private String descibe;

    OzWitch(String descibe) {
        this.descibe = descibe;
    }

    public static void main(String[] args) {
        for (OzWitch value : OzWitch.values()) {
            System.out.println(value + "   and the describe: " + value.descibe);
        }
    }
}
