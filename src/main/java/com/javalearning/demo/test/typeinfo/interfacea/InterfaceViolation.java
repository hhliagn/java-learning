package com.javalearning.demo.test.typeinfo.interfacea;

public class InterfaceViolation {
    public static void main(String[] args) {
        A a = new B();
        a.f();
//        a.g();
        System.out.println(a.getClass().getSimpleName());
        if (a instanceof B){
            B b = (B) a;
            b.g();
        }
    }
}
