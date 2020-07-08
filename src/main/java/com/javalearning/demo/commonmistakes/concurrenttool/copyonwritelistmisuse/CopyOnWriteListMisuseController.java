package com.javalearning.demo.commonmistakes.concurrenttool.copyonwritelistmisuse;

import lombok.extern.slf4j.Slf4j;
import org.omg.CORBA.INTERNAL;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
@RequestMapping("copyonwritelistmisuse")
@Slf4j
public class CopyOnWriteListMisuseController {

    @GetMapping("write")
    public String testWrite() {
        List<Integer> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        List<Integer> synchronizedArrayList = Collections.synchronizedList(new ArrayList<>());
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("Write:copyOnWriteArrayList");
        IntStream.rangeClosed(1, 100000).forEach(i -> copyOnWriteArrayList.add(ThreadLocalRandom.current().nextInt(100)));
        stopWatch.stop();
        stopWatch.start("Write:synchronizedArrayList");
        IntStream.rangeClosed(1, 100000).forEach(i -> synchronizedArrayList.add(ThreadLocalRandom.current().nextInt(100)));
        stopWatch.stop();
        log.info(stopWatch.prettyPrint());
        return "OK";
    }

    private void addAll(List<Integer> list) {
        list.addAll(IntStream.rangeClosed(1, 1000000).boxed().collect(Collectors.toList()));
    }

    @GetMapping("read")
    public String testRead() {
        List<Integer> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        List<Integer> synchronizedArrayList = Collections.synchronizedList(new ArrayList<>());
        addAll(copyOnWriteArrayList);
        addAll(synchronizedArrayList);
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("Read:copyOnWriteArrayList");
        IntStream.rangeClosed(1, 1000000).forEach(i -> copyOnWriteArrayList.get(ThreadLocalRandom.current().nextInt(100)));
        stopWatch.stop();
        stopWatch.start("Read:synchronizedArrayList");
        IntStream.rangeClosed(1, 1000000).forEach(i -> synchronizedArrayList.get(ThreadLocalRandom.current().nextInt(100)));
        stopWatch.stop();
        log.info(stopWatch.prettyPrint());
        return "OK";
    }
}
