package com.javalearning.demo.commonmistakes.concurrenttool.copyonwritelistmisuse;

import com.javalearning.demo.leetcode.linkedlist.ListNode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j
@RequestMapping("/copyonwritelistmisuse")
@RestController
public class CopyOnWriteListMisUse {

    //并发写用synchronizedList
    @GetMapping("/testWrite")
    public Map testWrite(){
        List<Integer> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        List<Integer> synchronizedList = Collections.synchronizedList(new ArrayList<>());
        int loopcount = 100000;
        StopWatch stopWatch = new StopWatch();

        stopWatch.start("Write: copyOnWriteArrayList");
        IntStream.rangeClosed(1,loopcount).parallel().forEach(i->copyOnWriteArrayList.add(ThreadLocalRandom.current().nextInt(loopcount)));
        stopWatch.stop();

        stopWatch.start("Write: synchronizedList");
        IntStream.rangeClosed(1,loopcount).parallel().forEach(i->synchronizedList.add(ThreadLocalRandom.current().nextInt(loopcount)));
        stopWatch.stop();

        log.info(stopWatch.prettyPrint());

        Map result = new HashMap();
        result.put("copyOnWriteArrayList", copyOnWriteArrayList.size());
        result.put("synchronizedList", synchronizedList.size());
        return result;
    }

    //并发读用copyonwritelist
    @GetMapping("/testRead")
    public Map testRead(){
        List<Integer> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        List<Integer> synchronizedList = Collections.synchronizedList(new ArrayList<>());
        addAll(copyOnWriteArrayList);
        addAll(synchronizedList);

        int loopcount = 100000;
        StopWatch stopWatch = new StopWatch();

        stopWatch.start("Read: copyOnWriteArrayList");
        IntStream.rangeClosed(1,loopcount).parallel().forEach(i->copyOnWriteArrayList.get(ThreadLocalRandom.current().nextInt(loopcount)));
        stopWatch.stop();

        stopWatch.start("Read: synchronizedList");
        IntStream.rangeClosed(1,loopcount).parallel().forEach(i->synchronizedList.get(ThreadLocalRandom.current().nextInt(loopcount)));
        stopWatch.stop();

        log.info(stopWatch.prettyPrint());

        Map result = new HashMap();
        result.put("copyOnWriteArrayList", copyOnWriteArrayList.size());
        result.put("synchronizedList", synchronizedList.size());
        return result;
    }

    //帮助方法用来填充List
    private void addAll(List<Integer> list) {
        list.addAll(IntStream.rangeClosed(1, 1000000).boxed().collect(Collectors.toList()));
    }
}
