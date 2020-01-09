package com.javalearning.demo.test.typeinfo.toys.RegisteredFactory;

public class PowerSteeringBelt extends Belt {
    public static class factory implements Factory<PowerSteeringBelt>{

        @Override
        public PowerSteeringBelt create() {
            return new PowerSteeringBelt();
        }
    }
}
