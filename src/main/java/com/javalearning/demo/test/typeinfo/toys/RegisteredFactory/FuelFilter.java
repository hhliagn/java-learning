package com.javalearning.demo.test.typeinfo.toys.RegisteredFactory;

public class FuelFilter extends Filter {

    public static class factory implements Factory<FuelFilter> {
        @Override
        public FuelFilter create() {
            return new FuelFilter();
        }
    }
}