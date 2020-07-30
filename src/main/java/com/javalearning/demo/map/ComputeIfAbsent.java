package com.javalearning.demo.map;

import org.apache.ibatis.annotations.Mapper;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ComputeIfAbsent {

    public static void main(String[] args) throws InterruptedException {
        Map<String, LongAdder> freqs = new ConcurrentHashMap<>();
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        forkJoinPool.execute(() -> {
            IntStream.rangeClosed(1, 1000).parallel().forEach(i -> {
                String key = ThreadLocalRandom.current().nextInt(10000) + "";
                freqs.computeIfAbsent(key, k -> new LongAdder()).increment();
            });
        });

        forkJoinPool.shutdown();
        forkJoinPool.awaitTermination(1, TimeUnit.HOURS);

        Map<String, Long> resMap = freqs.entrySet().stream().collect(Collectors.toMap(
                k -> k.getKey(),
                k -> k.getValue().longValue()
        ));

        System.out.println(resMap);
    }
}
