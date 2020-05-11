package com.javalearning.demo.commonmistakes.io.filebufferperformance;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StopWatch;

import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.nio.charset.StandardCharsets.UTF_8;
import static java.nio.file.StandardOpenOption.*;

@Slf4j
public class CommonMistakesApplication {

    public static void main(String[] args) throws IOException {

        StopWatch stopWatch = new StopWatch();
        init();
        stopWatch.start("perByteOperation");
//        perByteOperation();
        stopWatch.stop();
        stopWatch.start("bufferOperationWith100Buffer");
        bufferOperationWith100Buffer();
        stopWatch.stop();
        stopWatch.start("bufferedStreamByteOperation");
        bufferedStreamByteOperation();
        stopWatch.stop();
        stopWatch.start("bufferedStreamBufferOperation");
        bufferedStreamBufferOperation();
        stopWatch.stop();
        stopWatch.start("largerBufferOperation");
        largerBufferOperation();
        stopWatch.stop();
        stopWatch.start("fileChannelOperation");
        fileChannelOperation();
        stopWatch.stop();
        log.info(stopWatch.prettyPrint());
    }

    private static void init() throws IOException {

        Files.write(Paths.get("src.txt"),
                IntStream.rangeClosed(1, 1000000).mapToObj(i -> UUID.randomUUID().toString()).collect(Collectors.toList())
                , UTF_8, CREATE, TRUNCATE_EXISTING);
    }

    private static void perByteOperation() throws IOException {
        Files.deleteIfExists(Paths.get("dest.txt"));

        try (FileInputStream fileInputStream = new FileInputStream("src.txt");
             FileOutputStream fileOutputStream = new FileOutputStream("dest.txt")) {
            int i;
            while ((i = fileInputStream.read()) != -1) {
                fileOutputStream.write(i);
            }
        }
    }

    private static void bufferOperationWith100Buffer() throws IOException {
        Files.deleteIfExists(Paths.get("dest.txt"));
        try(
                FileInputStream inputStream = new FileInputStream("src.txt");
                FileOutputStream outputStream = new FileOutputStream("dest.txt");
                ) {
            byte[] buf = new byte[100];
            int length = 0;
            while ((length = inputStream.read(buf)) != -1){
                outputStream.write(buf, 0, length);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void bufferedStreamByteOperation() throws IOException {
        Files.deleteIfExists(Paths.get("dest.txt"));
        try(
                BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("src.txt"));
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("dest.txt"));
        ) {
            int i;
            while ((i = bufferedInputStream.read()) != -1){
                bufferedOutputStream.write(i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void bufferedStreamBufferOperation() throws IOException {
        Files.deleteIfExists(Paths.get("dest.txt"));
        try(
                BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("src.txt"));
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("dest.txt"));
        ) {
            byte[] buf = new byte[8124];
            int i;
            while ((i = bufferedInputStream.read(buf)) != -1){
                bufferedOutputStream.write(buf, 0, i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void largerBufferOperation() throws IOException {
        Files.deleteIfExists(Paths.get("dest.txt"));
        try(
                FileInputStream fileInputStream = new FileInputStream("src.txt");
                FileOutputStream fileOutputStream = new FileOutputStream("dest.txt");
        ) {
            byte[] buf = new byte[8124];
            int i;
            while ((i = fileInputStream.read(buf)) != -1){
                fileOutputStream.write(buf, 0, i);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void fileChannelOperation() throws IOException {
        Files.deleteIfExists(Paths.get("dest.txt"));
        FileChannel in = FileChannel.open(Paths.get("src.txt"), READ);
        FileChannel out = FileChannel.open(Paths.get("dest.txt"), CREATE, WRITE);
        in.transferTo(0, in.size(), out);
    }


}

