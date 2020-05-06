package com.javalearning.demo.commonmistakes.io.filestreamoperationneedclose;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @description cc
 * @date 2020/5/5
 */
@Slf4j
public class CommonMistake {

    public static void main(String[] args) throws IOException {
        readWrong();
        readRight();

    }

    public static void readWrong() throws IOException {
        Files.readAllLines(Paths.get("hello.txt"));
        log.info("lines {}", Files.readAllLines(Paths.get("hello2.txt")).size());
    }

    public static void readRight() throws IOException {
        AtomicLong atomicLong = new AtomicLong();
        Files.lines(Paths.get("hello2.txt")).forEach(line-> atomicLong.incrementAndGet());
        log.info("lines: {}", atomicLong.get());

    }
}
