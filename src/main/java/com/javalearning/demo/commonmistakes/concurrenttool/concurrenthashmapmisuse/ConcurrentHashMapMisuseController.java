package com.javalearning.demo.commonmistakes.concurrenttool.concurrenthashmapmisuse;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

@RestController
@RequestMapping("/concurrent")
@Slf4j
public class ConcurrentHashMapMisuseController {

    private static int THREAD_COUNT = 10;
    private static int ITEM_COUNT = 1000;

    private ConcurrentHashMap<String, Long> getData(int count) {
        return LongStream.rangeClosed(1, count)
                .boxed()
                .collect(Collectors.toConcurrentMap(i -> UUID.randomUUID().toString(), Function.identity(),
                        (o1, o2) -> o1, ConcurrentHashMap::new));
    }

    @GetMapping("/wrong")
    public Integer wrong() throws InterruptedException {
        ConcurrentHashMap<String, Long> freqs = getData(ITEM_COUNT - 100);
        ForkJoinPool forkJoinPool  =new ForkJoinPool(THREAD_COUNT);
        forkJoinPool.execute(() -> IntStream.rangeClosed(1, 10).parallel().forEach(i -> {
            int gap = ITEM_COUNT - freqs.size();
            log.info("gap size: {}", gap);
            freqs.putAll(getData(gap));
        }));
        forkJoinPool.shutdown();
        forkJoinPool.awaitTermination(1, TimeUnit.HOURS);
        return freqs.size();
    }

    @GetMapping("/right")
    public Integer right() throws InterruptedException {
        ConcurrentHashMap<String, Long> freqs = getData(ITEM_COUNT - 100);
        ForkJoinPool forkJoinPool  =new ForkJoinPool(THREAD_COUNT);
        forkJoinPool.execute(() -> IntStream.rangeClosed(1, 10).parallel().forEach(i -> {
            synchronized (freqs){
                int gap = ITEM_COUNT - freqs.size();
                log.info("gap size: {}", gap);
                freqs.putAll(getData(gap));
            }
        }));
        forkJoinPool.shutdown();
        forkJoinPool.awaitTermination(1, TimeUnit.HOURS);
        return freqs.size();
    }

}
