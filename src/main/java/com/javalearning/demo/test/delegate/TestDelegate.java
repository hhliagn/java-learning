package com.javalearning.demo.test.delegate;

public class TestDelegate {
    public static void main(String[] args) {
        //Test combine
        SpaceShip spaceShip = new SpaceShip();
        spaceShip.forward(1);

        //Test delegate
        SpaceShipDelegate spaceShipDelegate = new SpaceShipDelegate();
        spaceShipDelegate.forward(1);
    }
}
