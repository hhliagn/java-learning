package com.javalearning.demo.test.io;

import java.io.IOException;
import java.io.StringReader;

public class MemoryInput {

    public static void main(String[] args) throws IOException {
        StringReader in = new StringReader(BufferedInputFile.read("G:\\my_workspace\\java-learning\\src\\main\\java\\com\\javalearning\\demo\\test\\io\\MemoryInput.java"));
        int i;
        while ((i = in.read()) != -1){
            System.out.println((char) i);
        }
    }
}
