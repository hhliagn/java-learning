package com.javalearning.demo.test.io;

import java.io.*;
import java.util.Enumeration;
import java.util.zip.*;

public class ZipCompress {
    public static void main(String[] args) throws IOException {

        FileOutputStream f = new FileOutputStream("test.zip");
        CheckedOutputStream csum = new CheckedOutputStream(f, new Adler32());
        ZipOutputStream zos = new ZipOutputStream(csum);
        BufferedOutputStream out = new BufferedOutputStream(zos);

        zos.setComment("A test of Java Zipping");
        for (String arg : args) {
            System.out.println("Writing file " + arg);

            BufferedReader in = new BufferedReader(new FileReader(arg));
            zos.putNextEntry(new ZipEntry(arg));

            int c;
            while ((c = in.read()) != -1){
                out.write(c);
            }
            in.close();
            out.flush();
        }

        out.close();

        System.out.println("Checksum: " + csum.getChecksum().getValue());

        System.out.println("reading file");

        FileInputStream fi  = new FileInputStream("test.zip");
        CheckedInputStream csumi = new CheckedInputStream(fi, new Adler32());
        ZipInputStream in2 = new ZipInputStream(csumi);
        BufferedInputStream bis = new BufferedInputStream(in2);

        ZipEntry ze;
        while ((ze = in2.getNextEntry()) != null){
            System.out.println("Reading file: " + ze);
            int x;
            while ((x = bis.read()) != -1){
                System.out.write(x);
            }
        }

        if (args.length == 1){
            System.out.println("Checksum " + csumi.getChecksum().getValue());

        }

        bis.close();

        //解压文件的另一种方法
        ZipFile zf = new ZipFile("test.zip");
        Enumeration<? extends ZipEntry> entries = zf.entries();
        while (entries.hasMoreElements()){
            ZipEntry zipEntry = entries.nextElement();
            System.out.println("File: " + zipEntry);
        }

    }
}
