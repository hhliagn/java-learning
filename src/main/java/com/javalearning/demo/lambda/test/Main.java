package com.javalearning.demo.lambda.test;

import org.junit.Test;

/**
 * @author lhh
 * @date 2021/6/8
 */
public class Main {

    public static final int A = 40;
    public int a = 20;

    public static void main(String[] args) {

    }

    @Test
    public void run() throws InterruptedException {

        int a = 20;

        Runnable r1 = () -> {

            // Lambda中，this代表的是包含类
            this.doSomeThing();
            System.out.println("r1:" + this.a); // 20

            // 编译报错，Lambda无法屏蔽包含类的变量
            //int a = 10;
            System.out.println("r1:" + a); // 10
        };


        int A = 10;

        Runnable r2 = new Runnable(){

            int A = 30;

            @Override
            public void run(){

                int A = 20;

                // 匿名类中，this代表的是类自身
                this.doSomeThing();
                System.out.println("r2:" + this.A); // 30

                // 匿名类可以屏蔽包含类的变量
                System.out.println("r2:" + A); // 20
            }

            private void doSomeThing() {

                System.out.println("[Anonymous] do something..");
            }
        };


        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);

        t1.start();
        t2.start();

        t1.join();
        t2.join();


    }

    private void doSomeThing() {

        System.out.println("[Lambda] do something..");
    }
}
