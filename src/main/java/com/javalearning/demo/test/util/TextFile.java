package com.javalearning.demo.test.util;

import java.io.*;
import java.util.*;

public class TextFile extends ArrayList<String> {

    public static String read(String filename){
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader in = new BufferedReader(
                    new FileReader(new File(filename).getAbsoluteFile())
            );

            try {
                String s;
                while ((s = in.readLine()) != null){
                    sb.append(s);
                    sb.append("\n");
                }


            }finally {
                in.close();
            }

        }catch (Exception e){
            throw new RuntimeException(e);
        }

        return sb.toString();
    }

    public static void write(String filename, String text){
        try {
            PrintWriter out = new PrintWriter(new FileWriter(new File(filename).getAbsoluteFile()));

            try {
                out.print(text);
            }finally {
                out.close();
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }

    public TextFile(String filename, String splitter){

        super(Arrays.asList(read(filename).split(splitter)));

        if (get(0).equals("")){
            remove(0);
        }

    }

    public TextFile(String filename){
        this(filename, "\n");
    }

    public void write(String filename){
        try{
            PrintWriter out = new PrintWriter(new File(filename).getAbsoluteFile());

            try{
                for (String s : this) {
                    out.println(s);
                }
            }finally {
                out.close();
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        String file = read("G:\\my_workspace\\java-learning\\src\\main\\java\\com\\javalearning\\demo\\test\\util\\TextFile.java");

        write("Text.txt", file);

        TextFile text = new TextFile("Text.txt");

        text.write("Text2.txt");

        TreeSet<String> words = new TreeSet<>(new TextFile("G:\\my_workspace\\java-learning\\src\\main\\java\\com\\javalearning\\demo\\test\\util\\TextFile.java", "\\W+"));
        System.out.println(words.headSet("a"));
    }
}
