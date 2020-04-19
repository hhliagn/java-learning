package com.javalearning.demo.commonmistakes.threadpool.threadpoolreuse;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j
@RequestMapping("threadpoolreuse")
@RestController
public class threadpoolreuse {


    @GetMapping("/wrong")
    public void wrong() {
        ThreadPoolExecutor threadPool = ThreadPoolHelper.getThreadPool();
        IntStream.rangeClosed(1,10).forEach(i->{
            threadPool.execute(()->{
                String payload = IntStream.rangeClosed(1,1000000)
                        .mapToObj(__->"a")
                        .collect(Collectors.joining("")) + UUID.randomUUID().toString();
                try {
                    TimeUnit.SECONDS.sleep(10);
                }catch (InterruptedException e){

                }
                log.debug(payload);
            });
        });
    }


    static class ThreadPoolHelper{
        private static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                10,20,
                10, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(100),
                new ThreadPoolExecutor.AbortPolicy());

        public static ThreadPoolExecutor getThreadPool(){
            return (ThreadPoolExecutor) Executors.newCachedThreadPool();
        }

        public static ThreadPoolExecutor getRightThreadPool(){
            return threadPoolExecutor;
        }
    }
}
