package com.javalearning.demo.concurrency.synchronized1;

/**
 * @author lhh
 * @date 2021/4/5
 */
public class Test {
    public static void main(String[] args) {
        Person you = new Person("aaa");
        Person he = new Person("bbb");

        //不同对象，在类锁下会同步。
        Thread you1 = new Thread(you, "苇名一心");
        Thread he1 = new Thread(he,"苇名弦一郎");

        you1.start();
        he1.start();
    }

}
