package com.javalearning.demo.test.generics;

public class Holder3<T> {
    private T a;
    public Holder3(T a){
        this.a = a;
    }
    public T get(){
        return a;
    }
    public void set(T a){
        this.a = a;
    }

    public static void main(String[] args) {
        Holder3<Automobile> automobileHolder3 = new Holder3<>(new Automobile());
        Automobile automobile = automobileHolder3.get();
        automobileHolder3.set(new Automobile());
//        automobileHolder3.set("lhh");
//        automobileHolder3.set(10);
    }
}
