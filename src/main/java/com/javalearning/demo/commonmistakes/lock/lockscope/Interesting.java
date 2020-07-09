package com.javalearning.demo.commonmistakes.lock.lockscope;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Interesting {

    volatile int a = 1;
    volatile int b = 1;

    public synchronized void add(){
        for (int i = 0; i < 100000; i++) {
            a++;
            b++;
        }
    }

    public void compare(){
        for (int i = 0; i < 100000; i++) {
            if (a < b){
                log.info("a:{} b:{} a > b?: {}", a, b, a > b);
            }
        }
    }

    public synchronized void compareRight(){
        for (int i = 0; i < 100000; i++) {
            if (a < b){
                log.info("a:{} b:{} a > b?: {}", a, b, a > b);
            }
        }
    }
}
