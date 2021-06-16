package com.javalearning.demo.concurrency.completeableFuture;

import com.sun.xml.internal.ws.util.CompletedFuture;
import io.lettuce.core.protocol.CompleteableCommand;
import io.netty.util.concurrent.CompleteFuture;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.concurrent.*;

/**
 * @author lhh
 * @date 2021/3/29
 */
public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //otherStaticMethod();

        //instanceMethod();

        whenMethod();

        ExecutorService executorService = Executors.newCachedThreadPool();

        //executorService.submit(new Callable<Object>() {
        //    @Override
        //    public Object call() throws Exception {
        //        System.out.println("executorService 是否为守护线程 :" + Thread.currentThread().isDaemon());
        //        return null;
        //    }
        //});

        //final CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
        //    System.out.println("this is lambda supplyAsync");
        //    System.out.println("supplyAsync 是否为守护线程 " + Thread.currentThread().isDaemon());
        //    //try {
        //    //    TimeUnit.SECONDS.sleep(2);
        //    //} catch (InterruptedException e) {
        //    //    e.printStackTrace();
        //    //}
        //    System.out.println("this lambda is executed by forkJoinPool");
        //    return "result1";
        //});

        //final CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
        //    System.out.println("this is lambda supplyAsync");
        //    System.out.println("supplyAsync 是否为守护线程 " + Thread.currentThread().isDaemon());
        //
        //    try (BufferedWriter writer = new BufferedWriter
        //            (new OutputStreamWriter(new FileOutputStream(new File("C:/Users/lhh/Desktop/out.txt"))))) {
        //        writer.write("this is completableFuture daemon test");
        //    } catch (Exception e) {
        //        System.out.println("exception find");
        //    }
        //
        //    System.out.println("this lambda is executed by forkJoinPool");
        //    return "result1";
        //
        //});
        //
        //TimeUnit.SECONDS.sleep(3);

        //final CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
        //    System.out.println("this is task with executor");
        //    System.out.println("supplyAsync 使用executorService 时是否为守护线程 : " + Thread.currentThread().isDaemon());
        //    return "result2";
        //}, executorService);


        //System.out.println(completableFuture.get());
        //System.out.println(future.get());

        executorService.shutdown();
    }

    public static void otherStaticMethod() throws ExecutionException, InterruptedException {
        final CompletableFuture<String> futureOne = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                System.out.println("futureOne InterruptedException");
            }
            return "futureOneResult";
        });

        final CompletableFuture<String> futureTwo = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(600);
            } catch (InterruptedException e) {
                System.out.println("futureTwo InterruptedException");
            }
            return "futureTwoResult";
        });

        TimeUnit.SECONDS.sleep(1);

        //CompletableFuture future = CompletableFuture.allOf(futureOne, futureTwo);
        //System.out.println(future.get());
        CompletableFuture completableFuture = CompletableFuture.anyOf(futureOne, futureTwo);
        System.out.println(completableFuture.get());
    }

    public static void instanceMethod() throws InterruptedException {
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("one task..");
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }

            return "result";
        });

        completableFuture.join();
        System.out.println("instanceMethod");
        //String now = completableFuture.getNow("Now");
        //System.out.println(now);
    }

    public static void whenMethod() throws InterruptedException {
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("first task...");
            //int A = 1 / 0;
            return "result";
        });

        // whenComplete 会阻塞主线程
        //completableFuture.whenComplete((s, e) -> {
        //
        //    try {
        //        Thread.sleep(3000);
        //    } catch (InterruptedException e1) {
        //        e1.printStackTrace();
        //    }
        //
        //    System.out.println("s: " + s);
        //    System.out.println("e: " + e);
        //});


        // whenCompleteAsync 不会阻塞主线程
        completableFuture.whenCompleteAsync((s, e) -> {

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }

            System.out.println("s: " + s);
            System.out.println("e: " + e);
        });

        System.out.println("end");
        Thread.sleep(4000);
    }
}
