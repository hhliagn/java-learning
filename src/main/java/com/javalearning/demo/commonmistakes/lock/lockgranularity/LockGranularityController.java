package com.javalearning.demo.commonmistakes.lock.lockgranularity;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@RestController
@RequestMapping("lockgranularity")
@Slf4j
public class LockGranularityController {

    private List<Integer> data = new ArrayList<>();

    private void slow(){
        try {
            TimeUnit.MILLISECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/wrong")
    public int wrong(){
        long begin = System.currentTimeMillis();
        IntStream.rangeClosed(1, 1000).parallel().forEach(i -> {
            synchronized (data){
                slow();
                data.add(i);
            }
        });
        log.info("took {}ms", System.currentTimeMillis() - begin );
        return data.size();
    }

    @GetMapping("/right")
    public int right(){
        long begin = System.currentTimeMillis();
        IntStream.rangeClosed(1, 1000).parallel().forEach(i -> {
            slow();
            synchronized (data){
                data.add(i);
            }
        });
        log.info("took {}ms", System.currentTimeMillis() - begin );
        return data.size();
    }
}
