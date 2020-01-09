package com.javalearning.demo.test.typeinfo.toys.RegisteredFactory;

public class AirFilter extends Filter {
    public static class factory implements Factory<AirFilter>{

        @Override
        public AirFilter create() {
            return new AirFilter();
        }
    }
}
