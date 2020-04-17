package com.javalearning.demo.commonmistakes.concurrenttool.threadlocal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/threadlocal")
public class ThreadReUse {

    private ThreadLocal<Integer> currentUser = ThreadLocal.withInitial(() -> null);

    @GetMapping("/wrong")
    public Map wrong(@RequestParam("userId") Integer userId){
        String before = Thread.currentThread().getName() + ":" + currentUser.get();
        currentUser.set(userId);
        String after = Thread.currentThread().getName() + ":" + currentUser.get();
        Map rs = new HashMap();
        rs.put("before", before);
        rs.put("after", after);
        return rs;
    }

    @GetMapping("/right")
    public Map right(@RequestParam("userId") Integer userId){
        try {
            String before = Thread.currentThread().getName() + ":" + currentUser.get();
            currentUser.set(userId);
            String after = Thread.currentThread().getName() + ":" + currentUser.get();
            Map rs = new HashMap();
            rs.put("before", before);
            rs.put("after", after);
            return rs;
        } finally {
            currentUser.remove();
        }
    }

}
