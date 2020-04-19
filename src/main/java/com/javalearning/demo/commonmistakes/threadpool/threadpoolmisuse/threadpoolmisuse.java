package com.javalearning.demo.commonmistakes.threadpool.threadpoolmisuse;


import jodd.util.concurrent.ThreadFactoryBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalTime;
import java.util.Collections;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.nio.charset.StandardCharsets.UTF_8;
import static java.nio.file.StandardOpenOption.CREATE;
import static java.nio.file.StandardOpenOption.TRUNCATE_EXISTING;

@Slf4j
@RequestMapping("threadpoolmisuse")
@RestController
public class threadpoolmisuse {

    private static ThreadPoolExecutor fileThreadPool = new ThreadPoolExecutor(
            2,2,
            1,TimeUnit.HOURS,
            new ArrayBlockingQueue<>(100),
            new ThreadFactoryBuilder().setNameFormat("batchfileprocess-threadpool-%d").get(),
            new ThreadPoolExecutor.CallerRunsPolicy());

    private static ThreadPoolExecutor ayncThreadPool = new ThreadPoolExecutor(
            200,200,
            1,TimeUnit.HOURS,
            new ArrayBlockingQueue<>(100),
            new ThreadFactoryBuilder().setNameFormat("aync-threadpool-%d").get());


    public Callable<Integer> calcTask(){
        return ()->{
            TimeUnit.MILLISECONDS.sleep(10);
            return 1;
        };
    }

    @GetMapping("/wrong")
    public void wrong() throws ExecutionException, InterruptedException {
        fileThreadPool.submit(calcTask()).get();
    }

    @GetMapping("/right")
    public void right() throws ExecutionException, InterruptedException {
        ayncThreadPool.submit(calcTask()).get();
    }

    @PostConstruct
    public void init(){
//        printStats(fileThreadPool);

        String payload = IntStream.rangeClosed(1,1_000_000)
                .mapToObj(__->"a")
                .collect(Collectors.joining(""));

        new Thread(()->{
            while (true){
                fileThreadPool.execute(()->{
                    try {
                        Files.write(Paths.get("demo.txt"), Collections.singletonList(LocalTime.now().toString() + ":" + payload), UTF_8, CREATE, TRUNCATE_EXISTING);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            }
        }).start();

    }


//    private void printStats(ThreadPoolExecutor threadPool) {
//        Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(() -> {
//            log.info("=========================");
//            log.info("Pool Size: {}", threadPool.getPoolSize());
//            log.info("Active Threads: {}", threadPool.getActiveCount());
//            log.info("Number of Tasks Completed: {}", threadPool.getCompletedTaskCount());
//            log.info("Number of Tasks in Queue: {}", threadPool.getQueue().size());
//
//            log.info("=========================");
//        }, 0, 1, TimeUnit.SECONDS);
//    }

}
