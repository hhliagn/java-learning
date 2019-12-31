package com.javalearning.demo.test.delegate;

public class TestDelegate {
    public static void main(String[] args) {
        //test combine
        SpaceShip spaceShip = new SpaceShip();
        spaceShip.forward(1);

        //test delegate
        SpaceShipDelegate spaceShipDelegate = new SpaceShipDelegate();
        spaceShipDelegate.forward(1);
    }
}
