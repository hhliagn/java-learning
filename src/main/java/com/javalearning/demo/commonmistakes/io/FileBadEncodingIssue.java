package com.javalearning.demo.commonmistakes.io;

import lombok.extern.slf4j.Slf4j;
import org.bouncycastle.util.encoders.Hex;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @description cc
 * @date 2020/5/5
 */
@Slf4j
public class FileBadEncodingIssue {

    public static void main(String[] args) throws IOException {
//        wrong1();
//        wrong2();
//        right1();
        right2();
    }

    public static void wrong1() throws IOException {
        Files.deleteIfExists(Paths.get("hello.txt"));
        Files.write(Paths.get("hello.txt"), "你好".getBytes(Charset.forName("GBK")));
        log.info("bytes: {}", Hex.toHexString(Files.readAllBytes(Paths.get("hello.txt"))).toUpperCase());

        Files.deleteIfExists(Paths.get("hello2.txt"));
        Files.write(Paths.get("hello2.txt"), "你好".getBytes(Charset.forName("UTF-8")));
        log.info("utf-8 bytes: {}", Hex.toHexString(Files.readAllBytes(Paths.get("hello2.txt"))).toUpperCase());
    }

    public static void wrong2() throws IOException {
        log.info("default charset: {}", Charset.defaultCharset());

        char[] buf = new char[10];
        String content = "";
        try(FileReader fileReader = new FileReader("hello.txt")){
            int length = 0;
            while ( (length = fileReader.read(buf)) != -1 ){
                content += new String(buf, 0, length);
            }
        }

        log.info("result: {}", content);
    }

    public static void right1() throws IOException {
        char[] buf = new char[10];
        String content = "";
        try (FileInputStream in = new FileInputStream("hello.txt")){
            InputStreamReader isr = new InputStreamReader(in, Charset.forName("GBK"));
            int length = 0;
            while ((length = (isr.read(buf))) != -1){
                content += new String(buf, 0, length);
            }
        }
        log.info("result: {}", content);
    }

    public static void right2() throws IOException {
        log.info("result: {}", Files.readAllLines(Paths.get("hello.txt"), Charset.forName("GBK")).stream().findFirst().orElse(""));
    }

}
