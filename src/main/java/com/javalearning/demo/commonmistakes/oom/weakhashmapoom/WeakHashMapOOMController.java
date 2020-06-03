package com.javalearning.demo.commonmistakes.oom.weakhashmapoom;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ConcurrentReferenceHashMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.LongStream;

@RestController
@RequestMapping("weakhashmapoom")
@Slf4j
public class WeakHashMapOOMController {

    private Map<String, User> cache0 = new WeakHashMap<>();
    private Map<User, UserProfile> cache1 = new WeakHashMap<>();
    private Map<User, WeakReference<UserProfile>> cache2 = new WeakHashMap<>();
    private Map<User, UserProfile> cache3 = new ConcurrentReferenceHashMap<>();

    @GetMapping("/normal")
    public void normal(){
        Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(
                () -> log.info("cache0 size: {}", cache0.size()),
                1,
                1,
                TimeUnit.SECONDS
        );

        String userName = "lhh";
        LongStream.rangeClosed(1, 2000000).forEach(i -> {
            User user = new User(userName + i);
            cache0.put(user.getName(), user);
        });
    }

    @GetMapping("/wrong")
    public void wrong() throws InterruptedException { //size: 200_0000
        Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(
                () -> log.info("cache0 size: {}", cache1.size()),
                1,
                1,
                TimeUnit.SECONDS
        );

        String userName = "lhh";
        LongStream.rangeClosed(1, 2000000).forEach(i -> {
            User user = new User(userName + i);
            cache1.put(user, new UserProfile(user, "location" + i));
        });

        TimeUnit.SECONDS.sleep(10);
        System.gc();
    }

    @GetMapping("/right")
    public void right1() throws InterruptedException { //size: 94643
        Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(
                () -> log.info("cache0 size: {}", cache1.size()),
                1,
                1,
                TimeUnit.SECONDS
        );

        String userName = "lhh";
        LongStream.rangeClosed(1, 2000000).forEach(i -> {
            User user = new User(userName + i);
            cache1.put(user, new UserProfile(new User(userName + i), "location" + i));
        });

        TimeUnit.SECONDS.sleep(10);
        System.gc();
    }

    @GetMapping("/right2")
    public void right2() throws InterruptedException { //size: 726870
        Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(
                () -> log.info("cache0 size: {}", cache2.size()),
                1,
                1,
                TimeUnit.SECONDS
        );

        String userName = "lhh";
        LongStream.rangeClosed(1, 2000000).forEach(i -> {
            User user = new User(userName + i);
            cache2.put(user, new WeakReference<>(new UserProfile(user, "location" + i)));
        });

        TimeUnit.SECONDS.sleep(10);
        System.gc();
    }

    @GetMapping("/right3")
    public void right3() throws InterruptedException { //size: 2000000
        Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(
                () -> log.info("cache0 size: {}", cache3.size()),
                1,
                1,
                TimeUnit.SECONDS
        );

        String userName = "lhh";
        LongStream.rangeClosed(1, 2000000).forEach(i -> {
            User user = new User(userName + i);
            cache3.put(user, new UserProfile(user, "location" + i));
        });

        TimeUnit.SECONDS.sleep(10);
        System.gc();
    }


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    class User {
        private String name;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class UserProfile {
        private User user;
        private String location;
    }
}
