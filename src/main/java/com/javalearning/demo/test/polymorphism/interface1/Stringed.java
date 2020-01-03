package com.javalearning.demo.test.polymorphism.interface1;

public class Stringed implements Instrument,Playable {
    @Override
    public String toString() {
        return "Stringed";
    }

    @Override
    public void adjust() {
        System.out.println(this + ".adjust()");
    }

    @Override
    public void play(Note n) {
        System.out.println(this + " play " + n);
    }
}
