package com.javalearning.demo.commonmistakes.concurrenttool.concurrenthashmapperformance;

import lombok.extern.slf4j.Slf4j;
import org.omg.CORBA.MARSHAL;
import org.springframework.util.Assert;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
@RequestMapping("/fres")
@Slf4j
public class fres {

    private static int ITEM_COUNT = 1000;
    private static int LOOP_COUNT = 10000000;
    private static int THREAD_COUNT = 10;

    //10个线程并发执行，循环1000W次
    public Map<String, Long> normaluse() throws InterruptedException {
        ConcurrentHashMap<String,Long> fres = new ConcurrentHashMap<>(ITEM_COUNT);
        ForkJoinPool forkJoinPool = new ForkJoinPool(THREAD_COUNT);
        forkJoinPool.execute(()-> IntStream.rangeClosed(1,LOOP_COUNT).parallel().forEach(i->{
            synchronized (fres){
                String key = "item" + ThreadLocalRandom.current().nextInt(ITEM_COUNT);getClass();
                if (fres.containsKey(key)){
                    fres.put(key, fres.get(key) +1);
                }else {
                    fres.put(key, 1L);
                }
            }
        }));

        forkJoinPool.shutdown();
        forkJoinPool.awaitTermination(1, TimeUnit.HOURS);

        return fres;
    }

    public Map<String, Long> gooduse() throws InterruptedException {
        ConcurrentHashMap<String,LongAdder> fres = new ConcurrentHashMap<>(ITEM_COUNT);
        ForkJoinPool forkJoinPool = new ForkJoinPool(THREAD_COUNT);
        forkJoinPool.execute(()-> IntStream.rangeClosed(1,LOOP_COUNT).parallel().forEach(i->{
            String key = "item" + ThreadLocalRandom.current().nextInt(ITEM_COUNT);getClass();
            fres.computeIfAbsent(key, k -> new LongAdder()).increment();
        }));

        forkJoinPool.shutdown();
        forkJoinPool.awaitTermination(1, TimeUnit.HOURS);

        return fres.entrySet().stream().collect(Collectors.toMap(
                e -> e.getKey(),
                e -> e.getValue().longValue()
        ));
    }

    @GetMapping("good")
    public String good() throws InterruptedException {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("normaluse");
        Map<String, Long> normaluse = normaluse();
        stopWatch.stop();
        //校验元素数量
        Assert.isTrue(normaluse.size() == ITEM_COUNT, "normaluse size error");
        //校验累计总数
        Assert.isTrue(normaluse.entrySet().stream()
                        .mapToLong(item -> item.getValue()).reduce(0, Long::sum) == LOOP_COUNT
                , "normaluse count error");
        stopWatch.start("gooduse");
        Map<String, Long> gooduse = gooduse();
        stopWatch.stop();
        Assert.isTrue(gooduse.size() == ITEM_COUNT, "gooduse size error");
        Assert.isTrue(gooduse.entrySet().stream()
                        .mapToLong(item -> item.getValue())
                        .reduce(0, Long::sum) == LOOP_COUNT
                , "gooduse count error");
        log.info(stopWatch.prettyPrint());
        return "OK";
    }

}
