package com.javalearning.demo.designpattern.strategy;

/**
 * @description test main
 * @date 2020/5/9
 */
public class Main {

    public static void main(String[] args) {
        iStrategy strategy = null;
        if (true){
            strategy = new AStrategy();
        }else {
            strategy = new BStrategy();
        }

        Integer add = strategy.add(10, 2);
        System.out.println(add);
    }
}
