package com.javalearning.demo.test.override;

public class Bart extends Homer {
    @Override
    public char doh(char c){
        System.out.println("doh(milehouse)");
        return 'c';
    }
}
