package com.javalearning.demo.test.typeinfo.toys.RegisteredFactory;

public class FanBelt extends Belt{
    public static class factory implements Factory<FanBelt>{

        @Override
        public FanBelt create() {
            return new FanBelt();
        }
    }
}
