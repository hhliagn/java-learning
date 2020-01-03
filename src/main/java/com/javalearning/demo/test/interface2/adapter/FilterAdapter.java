package com.javalearning.demo.test.interface2.adapter;

import com.javalearning.demo.test.interface2.Processor;
import com.javalearning.demo.test.interface2.other_case.Filter;
import com.javalearning.demo.test.interface2.other_case.Waveform;;

public class FilterAdapter implements Processor {
    private Filter filter;
    public FilterAdapter(Filter filter){
        this.filter = filter;
    }
    @Override
    public String name() {
        return filter.name();
    }

    @Override
    public Waveform process(Object input) {
        return filter.process((Waveform) input);
    }
}
