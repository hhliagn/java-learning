package com.javalearning.demo.test.exceptions.test1;

public class Test {
    public static void main(String[] args) {
        try {
            throw new MyException("aaa");
        }catch (MyException e){
            String args1 = e.getArgs();
            System.out.println(args1);
            e.printStackTrace();
        }
    }
}
