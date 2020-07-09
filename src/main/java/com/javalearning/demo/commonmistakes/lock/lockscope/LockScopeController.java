package com.javalearning.demo.commonmistakes.lock.lockscope;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.IntStream;

@Slf4j
@RestController
@RequestMapping("/lockscope")
public class LockScopeController {

    @GetMapping("/wrong")
    public int wrong(@RequestParam(value = "count", defaultValue = "100000") int count){
        Data.reset();
        IntStream.rangeClosed(1, count).parallel().forEach(i -> new Data().wrong());
        return Data.getCounter();
    }

    @GetMapping("/right")
    public int right(@RequestParam(value = "count", defaultValue = "100000") int count){
        Data.reset();
        IntStream.rangeClosed(1, count).parallel().forEach(i -> new Data().right());
        return Data.getCounter();
    }

    @GetMapping("/wrong2")
    public void wrong2(){
        Interesting interesting = new Interesting();
        new Thread(() -> interesting.add()).start();
        new Thread(() -> interesting.compare()).start();
    }

    @GetMapping("/right2")
    public void right2(){
        Interesting interesting = new Interesting();
        new Thread(() -> interesting.add()).start();
        new Thread(() -> interesting.compareRight()).start();
    }
}
