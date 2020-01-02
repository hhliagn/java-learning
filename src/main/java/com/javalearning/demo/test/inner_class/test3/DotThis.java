package com.javalearning.demo.test.inner_class.test3;

public class DotThis {
    public DotThis(){

    }
    public void f(){
        System.out.println("DotThis.f()");
    }
    public class Inner{
        public DotThis outer(){
            return DotThis.this;
        }
    }
    public Inner inner(){
        return new Inner();
    }
}
