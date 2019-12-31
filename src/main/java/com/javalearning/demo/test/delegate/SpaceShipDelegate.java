package com.javalearning.demo.test.delegate;

public class SpaceShipDelegate{

    private String name;
    private static SpaceShipControlls controlls = new SpaceShipControlls();

    public void forward(int step){
        controlls.forward(step);
    }
    public void back(int step){
        controlls.back(step);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
