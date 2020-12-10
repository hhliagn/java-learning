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

@RestController
@RequestMapping("threadpooloom")
@Slf4j
public class ThreadPoolOOMController {

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

    @GetMapping("oom1")
    public void oom1() throws InterruptedException {
        ThreadPoolExecutor threadPoolExecutor
                = (ThreadPoolExecutor) Executors.newFixedThreadPool(1);
        printStats(threadPoolExecutor);
        for (int i = 0; i < 100000000; i++) {
            threadPoolExecutor.execute(() -> {
                String payload = IntStream.rangeClosed(1, 100000).mapToObj(__ -> "a").collect(Collectors.joining(",")) + UUID.randomUUID().toString();
                try {
                    TimeUnit.HOURS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            });
        }
        threadPoolExecutor.shutdown();
        threadPoolExecutor.awaitTermination(1, TimeUnit.HOURS);
    }

    @GetMapping("oom2")
    public void oom2() throws InterruptedException {
        ThreadPoolExecutor threadPoolExecutor
                = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        printStats(threadPoolExecutor);
        for (int i = 0; i < 100000000; i++) {
            threadPoolExecutor.execute(() -> {
                String payload = IntStream.rangeClosed(1, 100000).mapToObj(__ -> "a").collect(Collectors.joining(",")) + UUID.randomUUID().toString();
                try {
                    TimeUnit.HOURS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            });
        }
        threadPoolExecutor.shutdown();
        threadPoolExecutor.awaitTermination(1, TimeUnit.HOURS);
    }

    @GetMapping("right")
    public int right() throws InterruptedException {
        AtomicInteger atomicInteger = new AtomicInteger();
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
                2, 5,
                5, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(10),
                new ThreadFactoryBuilder().setNameFormat("demo1-Thread-%").get(),
                new ThreadPoolExecutor.AbortPolicy());
        //创建线程池马上启动所有核心线程
        threadPool.prestartAllCoreThreads();
        //KeepAliveTime之后也关闭核心线程
        threadPool.allowCoreThreadTimeOut(true);
        printStats(threadPool);
        IntStream.rangeClosed(1, 20).forEach(i -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int id = atomicInteger.incrementAndGet();
            try {
                threadPool.submit(() -> {
                    log.info("{} started", id);
                    try {
                        TimeUnit.SECONDS.sleep(10);
                    } catch (InterruptedException e) {
                    }
                    log.info("{} finished", id);
                });
            } catch (Exception ex) {
                log.error("error submitting task {}", id, ex);
                atomicInteger.decrementAndGet();
            }
        });

        TimeUnit.SECONDS.sleep(60);
        return atomicInteger.intValue();
    }

    @GetMapping("better")
    public int better() throws InterruptedException {
        AtomicInteger atomicInteger = new AtomicInteger();
        BlockingQueue<Runnable> queue = new LinkedBlockingQueue<Runnable>(10) {
            @Override
            public boolean offer(Runnable e) {
                return false;
            }
        };

        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
                2, 5,
                5, TimeUnit.SECONDS,
                queue, new ThreadFactoryBuilder().setNameFormat("demo1-threadpool-%d").get(),
                (r, executor) -> {
            try {
                //executor.getQueue().put(r);
                if (!executor.getQueue().offer(r, 0, TimeUnit.SECONDS)) {
                    throw new RejectedExecutionException("ThreadPool queue full, failed to offer " + r.toString());
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        printStats(threadPool);
        IntStream.rangeClosed(1, 20).forEach(i -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int id = atomicInteger.incrementAndGet();
            try {
                threadPool.submit(() -> {
                    log.info("{} started", id);
                    try {
                        TimeUnit.SECONDS.sleep(10);
                    } catch (InterruptedException e) {
                    }
                    log.info("{} finished", id);
                });
            } catch (Exception ex) {
                log.error("error submitting task {}", id, ex);
                atomicInteger.decrementAndGet();
            }
        });

        TimeUnit.SECONDS.sleep(60);
        return atomicInteger.intValue();
    }
}
