package com.javalearning.demo.test.generics.Manipulate;

public class Manipulator2<T extends HasF> {
    private T obj;
    public Manipulator2(T x){
        this.obj = x;
    }
    public void manipulate(){
        obj.f();
    }
}
