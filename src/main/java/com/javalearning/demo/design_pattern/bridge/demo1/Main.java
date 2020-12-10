package com.javalearning.demo.design_pattern.bridge.demo1;

/**
 * 我们不直接操作设备，而是通过遥控器控制设备，遥控器就相当于一座桥，连接了用户和设备
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        TV tv = new TV();
        Controller controller = new Controller(tv);
        controller.power();

        System.out.println("Watching TV..");
        Thread.sleep(2000);

        controller.power();
    }
}
