package com.javalearning.demo.lambda;

public class demo1 {

    public static void main(String[] args) {

        // 接口式编程(简化匿名内部类)
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("running the thread");
            }
        }).start();

        new Thread(() -> System.out.println("running the thread in lambda way") ).start();
    }
}
