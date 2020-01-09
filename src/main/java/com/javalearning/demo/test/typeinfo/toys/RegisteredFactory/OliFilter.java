package com.javalearning.demo.test.typeinfo.toys.RegisteredFactory;

public class OliFilter extends Filter {
    public static class factory implements Factory<OliFilter>{

        @Override
        public OliFilter create() {
            return new OliFilter();
        }
    }
}
