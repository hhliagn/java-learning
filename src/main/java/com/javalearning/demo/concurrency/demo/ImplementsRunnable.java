package com.javalearning.demo.concurrency.demo;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author lhh
 * @date 2021/3/16
 */
public class ImplementsRunnable implements Runnable {

    private AtomicInteger ticketNums = new AtomicInteger(10);
    private boolean flag = true;

    @Override
    public void run() {
        while(flag){
            //买票
            try {
                buy();
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void buy() throws InterruptedException {
        if(ticketNums.get() <= 0){
            flag = false;
            return ;
        }
        //睡10秒
        System.out.println(Thread.currentThread().getName() + "拿到了第" + ticketNums.decrementAndGet() + "票");
    }

    public static void main(String[] args) {
        ImplementsRunnable implementsRunnable = new ImplementsRunnable();
        Thread thread = new Thread(implementsRunnable, "小二");
        Thread thread1 = new Thread(implementsRunnable, "小三");
        Thread thread2 = new Thread(implementsRunnable, "小四");
        Thread thread3 = new Thread(implementsRunnable, "小五");
        thread.start();
        thread1.start();
        thread2.start();
        thread3.start();
        //打印线程状态
        while(true){
            if((thread.getState().equals(Thread.State.TERMINATED)) ||
                    (thread1.getState().equals(Thread.State.TERMINATED)) ||
                    (thread2.getState().equals(Thread.State.TERMINATED)) ||
                    (thread3.getState().equals(Thread.State.TERMINATED))
            ){
                break;
            }
            System.out.println("thread = " + thread.getState());
            System.out.println("thread1 = " + thread1.getState());
            System.out.println("thread2 = " + thread2.getState());
            System.out.println("thread3 = " + thread3.getState());
            System.out.println("------------------------------------");
            //一次打印 等待10秒
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}