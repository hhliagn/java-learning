package com.javalearning.demo.test.enumerated;

public enum SpaceShip {

    SCOUT, CARGO, TRANSPORT, CRUISER, BATTLESHIP, MOTHERSHIP;

    @Override
    public String toString() {
        String name = name();
        String lowercase = name.substring(1).toLowerCase();
        return name.charAt(0) + lowercase;
    }

    public static void main(String[] args) {
        for (SpaceShip value : SpaceShip.values()) {
            System.out.println(value);
        }
    }
}
