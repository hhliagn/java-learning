package com.javalearning.demo.test.typeinfo.toys.RegisteredFactory;

public class GeneratorBelt extends Belt {
    public static class factory implements Factory<GeneratorBelt>{

        @Override
        public GeneratorBelt create() {
            return new GeneratorBelt();
        }
    }
}
