package com.javalearning.demo.test.io;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

public class TestEOF {

    public static void main(String[] args) throws IOException {
        DataInputStream in = new DataInputStream(
                new ByteArrayInputStream(
                        BufferedInputFile.read("G:\\my_workspace\\java-learning\\src\\main\\java\\com\\javalearning\\demo\\test\\io\\TestEOF.java").getBytes()));

        while (in.available() != 0){
            System.out.println((char) in.readByte());
        }
    }
}
