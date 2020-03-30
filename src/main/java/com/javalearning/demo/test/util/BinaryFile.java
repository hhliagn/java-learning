package com.javalearning.demo.test.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class BinaryFile {

    public static byte[] read(File file) throws FileNotFoundException {
        BufferedInputStream in = new BufferedInputStream(new FileInputStream(file));
        try {
            byte[] data = new byte[in.available()];
            in.read(data);
            return data;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public static byte[] read(String file) throws FileNotFoundException {
        return read(new File(file).getAbsoluteFile());
    }
}
