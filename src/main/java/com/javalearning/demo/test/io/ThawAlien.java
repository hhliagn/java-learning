package com.javalearning.demo.test.io;

import java.io.*;

public class ThawAlien {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInput in = new ObjectInputStream(new FileInputStream(new File("G:\\my_workspace\\java-learning\\X.file")));
        Object o = in.readObject();
        System.out.println(o.getClass());
    }
}
