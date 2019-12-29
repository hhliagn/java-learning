package com.javalearning.demo.test.PassingThis;

public class Apple {
    public Apple getPeel(){
        return Peeler.peel(this);
    }
}
