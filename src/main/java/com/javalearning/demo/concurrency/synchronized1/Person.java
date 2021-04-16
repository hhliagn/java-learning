package com.javalearning.demo.concurrency.synchronized1;

/**
 * @author lhh
 * @date 2021/4/5
 */

public class Person implements Runnable {

    private Object lock = new Object();

    private String name;

    public Person(String name){
        this.name = name;
    }

    @Override
    public void run() {

        System.out.println(name + "111");
        System.out.println(name + "111");
        System.out.println(name + "111");
        System.out.println(name + "111");
        System.out.println(name + "111");
        System.out.println(name + "111");
        System.out.println(name + "111");
        System.out.println(name + "111");
        System.out.println(name + "111");

        synchronized (Object.class) {
            for(int i = 0; i <= 100; i++)
            {
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"放巴之雷");
            }
        }

        System.out.println(name + "222");
        System.out.println(name + "222");
        System.out.println(name + "222");
        System.out.println(name + "222");
        System.out.println(name + "222");
        System.out.println(name + "222");
        System.out.println(name + "222");
        System.out.println(name + "222");
        System.out.println(name + "222");

    }
}

