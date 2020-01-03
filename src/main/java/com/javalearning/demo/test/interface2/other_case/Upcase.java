package com.javalearning.demo.test.interface2.other_case;

public class Upcase extends Filter {
    private int cutoff;
    public Upcase(int cutoff){
        this.cutoff = cutoff;
    }
    @Override
    public Waveform process(Waveform input) {
        return input;
    }
}
