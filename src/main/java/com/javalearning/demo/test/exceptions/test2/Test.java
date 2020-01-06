package com.javalearning.demo.test.exceptions.test2;

import com.javalearning.demo.test.exceptions.test1.MyException;

public class Test { //恢复模式
    public static void main(String[] args) {
        int i = 10;
        while (true) {
            try {
                if (i > 0) {
                    i--;
                    throw new MyException();
                } else {
                    System.out.println("success");
                    break;
                }
            } catch (MyException e) {
                e.printStackTrace();
            }
        }
    }
}
