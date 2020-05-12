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
    public void parallel1(){
        IntStream.rangeClosed(1,100).parallel().forEach(i -> {
            System.out.println(LocalDateTime.now() + ":" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    @Test
    public void test() throws InterruptedException, ExecutionException {
        int taskCount = 10000;
        int threadCount = 20;
        StopWatch stopWatch = new StopWatch();

//        stopWatch.start("thread1");
//        Assert.assertTrue(taskCount == thread1(threadCount, taskCount));
//        stopWatch.stop();
////
        stopWatch.start("threadPool1");
        Assert.assertTrue(taskCount == threadPool2(threadCount, taskCount));
        stopWatch.stop();

        stopWatch.start("forkjoinPool1");
        Assert.assertTrue(taskCount == forkjoinPool2(threadCount, taskCount));
        stopWatch.stop();

//        stopWatch.start("stream1");
//        Assert.assertTrue(taskCount == stream(threadCount, taskCount));
//        stopWatch.stop();

//        stopWatch.start("completableFuture1");
//        Assert.assertEquals(taskCount, completableFuture1(threadCount, taskCount));
//        stopWatch.stop();

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

    public int thread1(int threadCount, int taskCount) throws InterruptedException {
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

    //推荐
    public int threadPool1(int threadCount, int taskCount) throws InterruptedException {
        AtomicInteger atomicInteger = new AtomicInteger();
        ExecutorService executorService = Executors.newFixedThreadPool(threadCount);
        IntStream.rangeClosed(1, taskCount).forEach(i -> executorService.execute(() -> increment(atomicInteger)));
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.HOURS);
        return atomicInteger.get();
    }

    public int threadPool2(int threadCount, int taskCount) throws InterruptedException {
        AtomicInteger atomicInteger = new AtomicInteger();
        ExecutorService executorService = Executors.newFixedThreadPool(threadCount);
        IntStream.rangeClosed(1, taskCount)
                .forEach(i -> executorService.execute(() -> increment(atomicInteger)));
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

    //推荐
    public int forkjoinPool1(int threadCount, int taskCount) throws InterruptedException {
        AtomicInteger atomicInteger = new AtomicInteger();
        ForkJoinPool forkJoinPool = new ForkJoinPool(threadCount);
        forkJoinPool.execute(() -> IntStream.rangeClosed(1, taskCount).parallel().forEach(j -> increment(atomicInteger)));
        forkJoinPool.shutdown();
        forkJoinPool.awaitTermination(1, TimeUnit.HOURS);
        return atomicInteger.get();
    }

    public int forkjoinPool2(int threadCount, int taskCount) throws InterruptedException {
        AtomicInteger atomicInteger = new AtomicInteger();
        ForkJoinPool forkJoinPool = new ForkJoinPool(threadCount);
        forkJoinPool.execute(() -> IntStream.rangeClosed(1, taskCount)
                .parallel().forEach(i -> increment(atomicInteger)));
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

    public int stream1(int threadCount, int taskCount) throws InterruptedException {
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

    public int completableFuture1(int threadCount, int taskCount) throws InterruptedException, ExecutionException {
        AtomicInteger atomicInteger = new AtomicInteger();
        ForkJoinPool forkJoinPool = new ForkJoinPool(threadCount);
        CompletableFuture.runAsync(() ->
                IntStream.rangeClosed(1, taskCount).parallel()
                        .forEach(i -> increment(atomicInteger)),forkJoinPool).get();
        return atomicInteger.get();
    }

}
