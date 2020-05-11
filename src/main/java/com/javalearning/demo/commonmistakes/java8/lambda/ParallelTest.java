package com.javalearning.demo.commonmistakes.java8.lambda;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.util.StopWatch;

import java.time.LocalDateTime;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
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

    @Test
    public void test() throws InterruptedException, ExecutionException {
        int taskCount = 10000;
        int threadCount = 20;
        StopWatch stopWatch = new StopWatch();

//        stopWatch.start("thread");
//        Assert.assertTrue(taskCount == thread(threadCount, taskCount));
//        stopWatch.stop();
//
//        stopWatch.start("threadPool");
//        Assert.assertTrue(taskCount == threadPool(threadCount, taskCount));
//        stopWatch.stop();
//
//        stopWatch.start("forkjoinPool");
//        Assert.assertTrue(taskCount == forkjoinPool(threadCount, taskCount));
//        stopWatch.stop();
//
//        stopWatch.start("stream");
//        Assert.assertTrue(taskCount == stream(threadCount, taskCount));
//        stopWatch.stop();

        stopWatch.start("completableFuture");
        Assert.assertTrue(taskCount == completableFuture(threadCount, taskCount));
        stopWatch.stop();

        log.info("{}", stopWatch.prettyPrint());
    }

    private void increment(AtomicInteger atomicInteger){
        atomicInteger.incrementAndGet();
        try {
            TimeUnit.MILLISECONDS.sleep(10);
        } catch (InterruptedException e) {

        }
    }

    public int thread(int threadCount, int taskCount) throws InterruptedException {
        AtomicInteger atomicInteger = new AtomicInteger();
        CountDownLatch countDownLatch = new CountDownLatch(threadCount);
        IntStream.rangeClosed(1, threadCount).mapToObj(i -> new Thread(() -> {
            IntStream.rangeClosed(1, taskCount / threadCount).forEach(j -> increment(atomicInteger));
            countDownLatch.countDown();
        })).forEach(Thread::start);
        countDownLatch.await();
        return atomicInteger.get();
    }

    public int threadPool(int threadCount, int taskCount) throws InterruptedException {
        AtomicInteger atomicInteger = new AtomicInteger();
        ExecutorService executorService = Executors.newFixedThreadPool(threadCount);
        IntStream.rangeClosed(1, taskCount).forEach(i -> executorService.execute(() -> increment(atomicInteger)));
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.HOURS);
        return atomicInteger.get();
    }

    public int forkjoinPool(int threadCount, int taskCount) throws InterruptedException {
        AtomicInteger atomicInteger = new AtomicInteger();
        ForkJoinPool forkJoinPool = new ForkJoinPool(threadCount);
        forkJoinPool.execute(() -> IntStream.rangeClosed(1, taskCount).parallel().forEach(j -> increment(atomicInteger)));
        forkJoinPool.shutdown();
        forkJoinPool.awaitTermination(1, TimeUnit.HOURS);
        return atomicInteger.get();
    }

    public int stream(int threadCount, int taskCount) throws InterruptedException {
        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", String.valueOf(threadCount));
        AtomicInteger atomicInteger = new AtomicInteger();
        IntStream.rangeClosed(1, taskCount).parallel().forEach(i -> increment(atomicInteger));
        return atomicInteger.get();
    }

    public int completableFuture(int threadCount, int taskCount) throws InterruptedException, ExecutionException {
        AtomicInteger atomicInteger = new AtomicInteger();
        ForkJoinPool forkJoinPool = new ForkJoinPool(threadCount);
        CompletableFuture.runAsync(() ->
                IntStream.rangeClosed(1, taskCount).parallel().forEach(i -> increment(atomicInteger)), forkJoinPool).get();
        return atomicInteger.get();
    }
}
