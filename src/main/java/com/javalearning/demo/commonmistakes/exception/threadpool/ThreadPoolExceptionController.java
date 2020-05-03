package com.javalearning.demo.commonmistakes.exception.threadpool;

import jodd.util.concurrent.ThreadFactoryBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
@Slf4j
public class ThreadPoolExceptionController {

    static {
        Thread.setDefaultUncaughtExceptionHandler((thread, throwable)-> log.error("ThreadPool {} got exception", thread, throwable));
    }

    @GetMapping("/executeWrong")
    public void wrong1() throws InterruptedException {
        String prefix = "test";
        ThreadPoolExecutor threadPool = (ThreadPoolExecutor) Executors.newFixedThreadPool(1, new ThreadFactoryBuilder().setNameFormat(prefix + "%d").get());
        IntStream.rangeClosed(1,10).forEach(i-> threadPool.execute(()->{
                if (i == 5) throw new RuntimeException("error");
                log.info("I'm done. : {}", i);
            }));

        threadPool.shutdown();
        threadPool.awaitTermination(1, TimeUnit.HOURS);
    }

    @GetMapping("/executeRight")
    public void right1() throws InterruptedException {
        String prefix = "test";
        ThreadPoolExecutor threadPool = (ThreadPoolExecutor) Executors.
                newFixedThreadPool(1, new ThreadFactoryBuilder()
                        .setNameFormat(prefix + "%d")
                        .setUncaughtExceptionHandler((thread, throwable)-> log.error("ThreadPool {} got exception", thread, throwable)).get());
        IntStream.rangeClosed(1,10).forEach(i -> threadPool.execute(()->{
                if (i == 5) throw new RuntimeException("error");
                log.info("I'm done. : {}", i);
            }));

        threadPool.shutdown();
        threadPool.awaitTermination(1, TimeUnit.HOURS);
    }

    @GetMapping("/submitWrong")
    public void wrong2() throws InterruptedException {
        String prefix = "test";
        ThreadPoolExecutor threadPool = (ThreadPoolExecutor) Executors.
                newFixedThreadPool(1, new ThreadFactoryBuilder()
                        .setNameFormat(prefix + "%d")
                        .setUncaughtExceptionHandler((thread, throwable)-> log.error("ThreadPool {} got exception", thread, throwable)).get());
        IntStream.rangeClosed(1,10).forEach(i->{
            threadPool.submit(()->{
                if (i == 5) throw new RuntimeException("error");
                log.info("I'm done. : {}", i);
            });
        });

        threadPool.shutdown();
        threadPool.awaitTermination(1, TimeUnit.HOURS);
    }

    @GetMapping("/submitRight")
    public void right2() throws InterruptedException {
        String prefix = "test";
        ThreadPoolExecutor threadPool = (ThreadPoolExecutor) Executors.
                newFixedThreadPool(1, new ThreadFactoryBuilder()
                        .setNameFormat(prefix + "%d")
                        .setUncaughtExceptionHandler((thread, throwable)-> log.error("ThreadPool {} got exception", thread, throwable)).get());
        List<Future> tasks = IntStream.rangeClosed(1,10).mapToObj(i-> threadPool.submit(()-> {
            if (i == 5) throw new RuntimeException("error");
            log.info("I'm done. : {}", i);
        })).collect(Collectors.toList());

        tasks.forEach(task->{
            try {
                task.get();
            } catch (Exception e) {
                log.error("got Exception", e);
            }
        });

        threadPool.shutdown();
        threadPool.awaitTermination(1, TimeUnit.HOURS);
    }
}
