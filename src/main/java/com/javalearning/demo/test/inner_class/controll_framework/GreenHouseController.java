package com.javalearning.demo.test.inner_class.controll_framework;

public class GreenHouseController {
    public static void main(String[] args) {
        GreenHouseControls gc = new GreenHouseControls();
        Event[] events = {
                gc.new LightOn(200),
                gc.new LightOff(200),
        };
        gc.addEvent(gc.new Restart(1000, events));
        gc.addEvent(new GreenHouseControls.Terminal(2000));
        gc.run();
    }
}
