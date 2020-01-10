package com.javalearning.demo.test.generics.Test;

public class SomeOneCanSing implements CanSing {
    @Override
    public void sing() {
        System.out.println("people can sing");
    }

    @Override
    public void beatbox() {
        System.out.println("people can beatbox");
    }
    public void rap(){
        System.out.println("people can rap");
    }
}
