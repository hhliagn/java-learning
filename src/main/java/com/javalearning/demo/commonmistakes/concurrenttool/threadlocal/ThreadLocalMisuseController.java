package com.javalearning.demo.commonmistakes.concurrenttool.threadlocal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/threadlocal")
public class ThreadLocalMisuseController {

    private static final ThreadLocal<Integer> currentUser = ThreadLocal.withInitial(()-> null);

    @GetMapping("/wrong")
    public void wrong(Integer userId){
        Integer before = currentUser.get();
        System.out.println(Thread.currentThread().getName() + " " + before);
        currentUser.set(userId);
        System.out.println(Thread.currentThread().getName() + " " + currentUser.get());
    }

    @GetMapping("/right")
    public void right(Integer userId){
        try {
            Integer before = currentUser.get();
            System.out.println(Thread.currentThread().getName() + " " + before);
            currentUser.set(userId);
            System.out.println(Thread.currentThread().getName() + " " + currentUser.get());
        }finally {
            currentUser.remove();
        }
    }
}
