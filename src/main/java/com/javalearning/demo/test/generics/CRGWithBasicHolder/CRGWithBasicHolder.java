package com.javalearning.demo.test.generics.CRGWithBasicHolder;

public class CRGWithBasicHolder {
    public static void main(String[] args) {
        SubType s1 = new SubType();
        SubType s2 = new SubType();
        s1.set(s2);
        SubType subType = s2.get();
        s2.f();
    }
}
