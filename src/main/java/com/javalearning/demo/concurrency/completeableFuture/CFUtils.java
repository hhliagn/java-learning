package com.javalearning.demo.concurrency.completeableFuture;

import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

/**
 * @author lhh
 * @date 2021/3/30
 */
public class CFUtils {

    private static ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();

    public static <T> List<T> query(List<Supplier<List<T>>> tasks, Integer secs){

        Assert.isTrue(!CollectionUtils.isEmpty(tasks), "tasks can not be empty.");
        List<T> results = new ArrayList<>();

        CompletableFuture[] completableFutures = new CompletableFuture[tasks.size()];
        for (int i = 0; i < tasks.size(); i++) {
            completableFutures[i] = CompletableFuture.supplyAsync(tasks.get(i), forkJoinPool);
        }

        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.allOf(completableFutures);
        voidCompletableFuture.whenComplete((s, e) -> {
            if (Objects.isNull(e)){
                for (CompletableFuture completableFuture : completableFutures) {
                    try {
                        List<T> list = (List<T>) completableFuture.get(secs, TimeUnit.SECONDS);
                        if (!CollectionUtils.isEmpty(list)){
                            results.addAll(list);
                        }
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                }
            }
        }).join();

        return results;
    }
}
