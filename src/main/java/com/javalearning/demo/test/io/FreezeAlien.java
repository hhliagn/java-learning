package com.javalearning.demo.test.io;

import java.io.*;

public class FreezeAlien {

    public static void main(String[] args) throws IOException {
        ObjectOutput out = new ObjectOutputStream(new FileOutputStream(new File("G:\\my_workspace\\java-learning\\X.file")));
        Alien alien = new Alien();
        out.writeObject(alien);
    }
}
