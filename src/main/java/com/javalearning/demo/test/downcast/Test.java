package com.javalearning.demo.test.downcast;

public class Test {
    public static void main(String[] args) {
        Useful[] u = {new Useful(), new MoreUseful()};
        u[0].f();
        u[1].g();
        //u[0].u(); //Useful中没有该方法
        ((MoreUseful) u[0]).u(); //抛异常，类型转换异常
        //u[1].u();
        ((MoreUseful) u[1]).u();
    }
}
