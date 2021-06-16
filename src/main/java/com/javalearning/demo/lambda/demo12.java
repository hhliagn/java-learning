package com.javalearning.demo.lambda;

public class demo12 {

    /**
     * lambda 常用接口 Runnable
     * @return
     */
    public static Runnable getRunnable(){
        Runnable runnable = () -> System.out.println("this is A runnable interface");
        return runnable;
    }

    public static void main(String[] args) {
        Runnable runnable = getRunnable();
        new Thread(runnable).start();
    }
}
