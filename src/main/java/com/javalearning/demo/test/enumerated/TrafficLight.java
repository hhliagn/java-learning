package com.javalearning.demo.test.enumerated;

enum Signal{
    RED, BLUE, GREEN
}
public class TrafficLight {
    Signal color = Signal.RED;

    public TrafficLight() {

    }

    public void change(){
        switch (color){
            default:
            case RED:
                color = Signal.BLUE;
                break;
            case BLUE:
                color = Signal.GREEN;
                break;
            case GREEN:
                color = Signal.RED;
                break;
        }
    }

    @Override
    public String toString() {
        return "The TrafficLight is " + color;
    }

    public static void main(String[] args) {
        TrafficLight light = new TrafficLight();
        for (int i = 0; i < 7; i++) {
            System.out.println(light);
            light.change();
        }
    }
}
