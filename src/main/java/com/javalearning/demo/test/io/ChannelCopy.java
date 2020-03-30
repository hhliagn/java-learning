package com.javalearning.demo.test.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ChannelCopy {

    private static int BSIZE = 1024;
    public static void main(String[] args) throws IOException {

        if (args.length != 2){
            System.out.println("arguments: sourceFile destFile");
            System.exit(1);
        }

        FileChannel in = new FileInputStream(args[0]).getChannel();
        FileChannel out = new FileOutputStream(args[1]).getChannel();

        ByteBuffer buf = ByteBuffer.allocate(BSIZE);
        int i;
        while ((i = in.read(buf)) != -1){
            buf.flip();
            out.write(buf);
            buf.clear();
        }
    }
}
