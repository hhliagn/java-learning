package com.javalearning.demo.test.exceptions.test4;

public class C extends B {
    @Override
    public void methodzzz() throws ThirdException {
        throw new ThirdException();
    }
}
