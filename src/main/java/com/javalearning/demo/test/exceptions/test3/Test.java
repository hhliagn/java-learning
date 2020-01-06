package com.javalearning.demo.test.exceptions.test3;

public class Test {
    static void g() throws MyException1 {
        throw new MyException1();
    }
    static void f() throws MyException2 {
        try {
            g();
        }catch (Exception e){
            throw new MyException2(e);
        }
    }
    public static void main(String[] args) {
        try {
            f();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
