package com.javalearning.demo.test.exceptions.loggingException;

public class Test {
    public static void main(String[] args) {
        try {
            throw new NullPointerException();
        }catch (NullPointerException e){
            LoggingException.Log(e);
        }
    }
}
