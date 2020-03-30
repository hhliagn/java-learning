package com.javalearning.demo.test.io;

import java.io.*;

public class Redirecting {
    public static void main(String[] args) throws IOException {
        PrintStream console = System.out;

        BufferedInputStream in = new BufferedInputStream(
                new FileInputStream(
                        new File("G:\\my_workspace\\java-learning\\src\\main\\java\\com\\javalearning\\demo\\test\\io\\Redirecting.java")));

        PrintStream out = new PrintStream(new BufferedOutputStream(
                new FileOutputStream("test.txt")), true);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.setIn(in);
        System.setOut(out);
        System.setErr(out);

        String s;
        while ((s = br.readLine()) != null){
            System.out.println(s);
        }

        out.close();

        System.setOut(console);

    }
}
