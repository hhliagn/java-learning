package com.javalearning.demo.test.polymorphism.interface1;

public class Music {
    static void tune(Playable i){
        i.play(Note.MIDDLE_C);
    }
    static void tuneAll(Playable[] ps){
        for (Playable p : ps) {
            tune(p);
        }
    }

    public static void main(String[] args) {
        Playable[] playables = {new Wind(), new Stringed(), new Wind(), new Stringed()};
        tuneAll(playables);
    }
}
