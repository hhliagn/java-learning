package com.javalearning.demo.commonmistakes.threadpool.threadpooloom;

import jodd.util.concurrent.ThreadFactoryBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j
@RequestMapping("threadpooloom")
@RestController
public class threadpooloom {

    @GetMapping("/oom1")
    public void oom1() throws InterruptedException {
        ThreadPoolExecutor threadPool = (ThreadPoolExecutor) Executors.newFixedThreadPool(1);
        printStats(threadPool);
        for (int i = 0; i < 100000000; i++) {
            threadPool.execute(()->{
                String payload = IntStream.rangeClosed(1,1000000)
                        .mapToObj(__ -> "a")
                        .collect(Collectors.joining("")) + UUID.randomUUID().toString();

                try {
                    TimeUnit.HOURS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                log.info(payload);
            });
        }

        threadPool.shutdown();
        threadPool.awaitTermination(1, TimeUnit.HOURS);
    }

    @GetMapping("/oom2")
    public void oom2() throws InterruptedException {
        ThreadPoolExecutor threadPool = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        printStats(threadPool);
        for (int i = 0; i < 100000000; i++) {
            threadPool.execute(()->{
                String payload = UUID.randomUUID().toString();
                try {
                    TimeUnit.HOURS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                log.info(payload);
            });
        }

        threadPool.shutdown();
        threadPool.awaitTermination(1, TimeUnit.HOURS);
    }

    @GetMapping("/right")
    public int right() throws InterruptedException {
        AtomicInteger counter = new AtomicInteger();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                2, 5,
                5, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(10),
                new ThreadFactoryBuilder().setNameFormat("demo-threadpool-%d").get(),
                new ThreadPoolExecutor.AbortPolicy()
        );

        printStats(threadPoolExecutor);

        IntStream.rangeClosed(1,20).forEach(i->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            int id = counter.incrementAndGet();

            try {
                threadPoolExecutor.submit(()->{
                    log.info("{} started", id);
                    try {
                        TimeUnit.SECONDS.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    log.info("{} finished", id);
                });
            } catch (Exception e) {
                log.warn("summit task error, id: {}", id, e);
                counter.decrementAndGet();
            }

        });

        TimeUnit.SECONDS.sleep(60);
        return counter.intValue();
    }


    private void printStats(ThreadPoolExecutor threadPool) {
        Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(() -> {
            log.info("=========================");
            log.info("Pool Size: {}", threadPool.getPoolSize());
            log.info("Active Threads: {}", threadPool.getActiveCount());
            log.info("Number of Tasks Completed: {}", threadPool.getCompletedTaskCount());
            log.info("Number of Tasks in Queue: {}", threadPool.getQueue().size());

            log.info("=========================");
        }, 0, 1, TimeUnit.SECONDS);
    }
}
