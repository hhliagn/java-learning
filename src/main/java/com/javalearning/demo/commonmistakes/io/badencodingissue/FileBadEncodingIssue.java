package com.javalearning.demo.commonmistakes.io.badencodingissue;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.Charsets;
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
        init();
        wrong1();
        right1();
        right2();
    }

    private static void init() throws IOException {
        Files.deleteIfExists(Paths.get("hello.txt"));
        Files.write(Paths.get("hello.txt"), "你好".getBytes(Charset.forName("GBK")));
        log.info("bytes: {}", Hex.toHexString(Files.readAllBytes(Paths.get("hello.txt"))).toUpperCase());

        Files.deleteIfExists(Paths.get("hello2.txt"));
        Files.write(Paths.get("hello2.txt"), "你好".getBytes(Charsets.UTF_8));
        log.info("bytes: {}", Hex.toHexString(Files.readAllBytes(Paths.get("hello2.txt"))).toUpperCase());
    }

    public static void wrong1() throws IOException {
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
        try (
                FileInputStream inputStream = new FileInputStream("hello.txt");
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("GBK"))
                ){
            int length = 0;
            while ((length = inputStreamReader.read(buf)) != -1){
                content += new String(buf, 0, length);
            }

            log.info("result: {}", content);
        }
    }

    public static void right2() throws IOException {
        log.info("result: {}", Files.readAllLines(Paths.get("hello.txt"), Charset.forName("GBK")).stream().findFirst().orElse(""));
    }

}
