package com.javalearning.demo.test.io;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class GetChannel {

    private static final int BSIZE = 1024;

    public static void main(String[] args) throws IOException {
        FileChannel fc = new FileOutputStream("data.txt").getChannel();
        fc.write(ByteBuffer.wrap("Some text ".getBytes()));
        fc.close();

        fc = new RandomAccessFile("data.txt", "rw").getChannel();
        fc.position(fc.size());
        fc.write(ByteBuffer.wrap("Some more".getBytes()));
        fc.close();

        fc = new FileInputStream(new File("data.txt")).getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(BSIZE);
        fc.read(buffer);
        buffer.flip();
        while (buffer.hasRemaining()){
            System.out.print((char) buffer.get());
        }
        fc.close();
    }
}
