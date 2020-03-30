package com.javalearning.demo.test.io;

import java.io.*;

public class StoringAndRecoveringData {

    public static void main(String[] args) throws IOException {
        DataOutputStream out = new DataOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream("Data.txt")
                )
        );

        out.writeDouble(1.45);
        out.writeUTF("what was that?");
        out.writeDouble(1.25);
        out.writeUTF("xxx get c");
        out.close();

        DataInputStream in = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream("Data.txt")));

        System.out.println(in.readDouble());
        System.out.println(in.readUTF());
        System.out.println(in.readDouble());
        System.out.println(in.readUTF());
    }
}
