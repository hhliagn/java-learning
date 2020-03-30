package com.javalearning.demo.test.io;

import java.io.*;

public class BasicFileOutput {

    static String file = "BasicFileOutput.out";

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(
                new StringReader(
                        BufferedInputFile.read("G:\\my_workspace\\java-learning\\src\\main\\java\\com\\javalearning\\demo\\test\\io\\BasicFileOutput.java")));
//        PrintWriter out = new PrintWriter(
//                new BufferedWriter(
//                        new FileWriter(file)));

        PrintWriter out = new PrintWriter(file); //你依旧使用了缓存，PrintWriter已经实现

        int lineCount = 0;
        String s;
        while ((s = in.readLine()) != null){
            out.println(lineCount ++ + " : " + s);
        }

        out.close();

        System.out.println(BufferedInputFile.read(file));
    }
}
