package com.javalearning.demo.test.inner_class.test7;

public class NewClass {
    public SomeClass getSome(final int id){
        return new SomeClass(id);
    }

    public static void main(String[] args) {
        NewClass newClass = new NewClass();
        SomeClass some = newClass.getSome(10);
    }
}
