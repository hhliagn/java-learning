package com.javalearning.demo.commonmistakes.logging.delay;

import lombok.extern.log4j.Log4j2;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@Log4j2
@RequestMapping("logging")
@RestController
public class LoggingController {

    @GetMapping
    public void index() {
        StopWatch sw = new StopWatch();
        sw.start("task1");
        log.debug("slow string task1" + slowString());
        sw.stop();
        sw.start("task2");
        log.debug("slow string task2: {}", slowString() );
        sw.stop();
        sw.start("task3");
        if (log.isDebugEnabled()){
            log.debug("slow string task3: {}", slowString());
        }
        sw.stop();
        sw.start("task4");
        log.debug("slow string task4: {}", ()-> slowString());
        sw.stop();
        log.info(sw.prettyPrint());
    }

    private String slowString() {
        System.out.println("slow string ");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "OK";
    }
}
