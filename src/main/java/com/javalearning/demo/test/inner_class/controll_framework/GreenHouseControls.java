package com.javalearning.demo.test.inner_class.controll_framework;


public class GreenHouseControls extends Controller {
    private boolean light = false;
    public class LightOn extends Event {
        public LightOn(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            light = true;
        }

        @Override
        public String toString() {
            return "light on";
        }
    }
    public class LightOff extends Event{

        public LightOff(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            light = false;
        }

        @Override
        public String toString() {
            return "light off";
        }
    }

    public class Restart extends Event{
        private Event[] events;
        public Restart(long delayTime, Event[] events) {
            super(delayTime);
            this.events = events;
            for (Event event : events) {
                addEvent(event);
            }
        }

        @Override
        public void action() {
            for (Event event : events) {
                event.start();
                addEvent(event);
            }
            start();
            addEvent(this);
        }

        @Override
        public String toString() {
            return "Restart System";
        }
    }
    public static class Terminal extends Event{

        public Terminal(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            System.exit(0);
        }

        @Override
        public String toString() {
            return "Terminal";
        }
    }
}
