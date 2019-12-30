package com.javalearning.demo.test.finalize;

public class TestFinalize {
    public static void main(String[] args) {
        Tank tank = new Tank(true);
        tank.drop();
        new Tank(true);
//        tank1.drop();
        new Tank(true);
//        tank2.drop();
        System.gc();
    }
}
