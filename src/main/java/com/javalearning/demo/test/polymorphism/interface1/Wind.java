package com.javalearning.demo.test.polymorphism.interface1;

public class Wind implements Instrument,Playable {
    @Override
    public String toString() {
        return "Wind";
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
