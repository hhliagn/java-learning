package com.javalearning.demo.commonmistakes.lock.lockscope;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;

@Slf4j
public class Interesting {

    volatile int a = 0;
    volatile int b = 0;

    public synchronized void add(){
        log.info("add start");
        for (int i = 0; i < 100000; i++) {
            a++;
            b++;
        }
        log.info("add end");
    }

    public synchronized void compare(){
        log.info("compare start");
        for (int i = 0; i < 100000; i++) {
            if (a<b){
                log.info("a:{}, b:{}, a>b: {}", a, b, a>b);
            }
        }
        log.info("compare end");
    }

    public synchronized void compareRight(){
        log.info("compare start");
        for (int i = 0; i < 100000; i++) {
            Assert.isTrue(a == b);
            if (a<b){
                log.info("a:{}, b:{}, a>b: {}", a, b, a>b);
            }
        }
        log.info("compare end");
    }
}
