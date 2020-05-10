package com.javalearning.demo.commonmistakes.java8_tmp;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.stream.IntStream;

@Slf4j
public class ParallelTest {

    @Test
    public void parallel(){ //四核 1s 执行4次
        IntStream.rangeClosed(1,100).parallel().forEach(i -> {
            System.out.println(LocalDateTime.now() + " : " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        });
    }
}
