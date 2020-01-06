package com.javalearning.demo.test.exceptions.test4;

public class B extends A {
    @Override
    public void methodzzz() throws SecondException {
        throw new SecondException();
    }
}
