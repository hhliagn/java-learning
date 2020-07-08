package com.javalearning.demo.commonmistakes.lock.lockscope;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

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
                log.info("a:{}, b:{}, a > b? {}", a, b, a > b);
            }
        }
    }

    public synchronized void compareRight(){
        for (int i = 0; i < 100000; i++) {
            if (a < b){
                log.info("a:{}, b:{}, a > b? {}", a, b, a > b);
            }
        }
    }

    //加锁只能对该逻辑的执行保证串行，不能保证其中资源中间不被其他线程读取
    //把涉及到资源的读写逻辑都加锁，才能保证在某一逻辑执行的同时让其他线程等待
}
