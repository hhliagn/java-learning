package com.javalearning.demo.test.typeinfo.toys.RegisteredFactory;

public class CanbinAirFilter extends Filter {
    public static class factory implements Factory<CanbinAirFilter>{

        @Override
        public CanbinAirFilter create() {
            return new CanbinAirFilter();
        }
    }
}
