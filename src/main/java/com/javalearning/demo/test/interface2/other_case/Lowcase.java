package com.javalearning.demo.test.interface2.other_case;

public class Lowcase extends Filter {
    private int cutoff;
    public Lowcase(int cutoff){
        this.cutoff = cutoff;
    }
    @Override
    public Waveform process(Waveform input) {
        return input;
    }
}
