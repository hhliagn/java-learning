package com.javalearning.demo.test.exceptions.test3;

public class MyException2 extends Exception {
    public MyException2(Exception e){
        super(e);
    }
    public MyException2(){
        super();
    }

}
