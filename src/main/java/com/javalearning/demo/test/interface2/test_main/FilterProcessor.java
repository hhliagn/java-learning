package com.javalearning.demo.test.interface2.test_main;

import com.javalearning.demo.test.interface2.Apply;
import com.javalearning.demo.test.interface2.adapter.FilterAdapter;
import com.javalearning.demo.test.interface2.other_case.Lowcase;
import com.javalearning.demo.test.interface2.other_case.Upcase;
import com.javalearning.demo.test.interface2.other_case.Waveform;

public class FilterProcessor {
    public static void main(String[] args) {
        Waveform w = new Waveform();
        Apply.process(new FilterAdapter(new Upcase(10)), w);
        Apply.process(new FilterAdapter(new Lowcase(10)), w);
    }
}
