package com.javalearning.demo.test.io;

import java.io.*;
import java.util.Random;

public class Worm implements Serializable{

    private static Random rand = new Random(47);
    private Data[] d = {
            new Data(rand.nextInt(10)),
            new Data(rand.nextInt(10)),
            new Data(rand.nextInt(10)),
    };

    private Worm next;
    private char c;

    public Worm(){
        System.out.println("Default Constructor");
    }
    public Worm(int i, char c){
        System.out.println("Worm Constructor: " + i);
        this.c = c;
        if (--i > 0){
            next = new Worm(i, (char) (c + i));
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(":");
        sb.append(c);
        sb.append("(");
        for (Data data : d) {
            sb.append(data);
        }
        sb.append(")");

        if (next != null){
            sb.append(next);
        }

        return sb.toString();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Worm w = new Worm(6, 'a');
        System.out.println("w: " + w);

        ObjectOutput out = new ObjectOutputStream(new FileOutputStream("worm.out"));
        out.writeObject("Worm Storage\n");
        out.writeObject(w);
        out.close();

        ObjectInputStream in = new ObjectInputStream(new FileInputStream("worm.out"));
        String o = (String) in.readObject();
        Worm w2 = (Worm) in.readObject();
        System.out.println("w2: " + w2);

        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        ObjectOutputStream out2 = new ObjectOutputStream(bout);
        out2.writeObject("Worm Storage\n");
        out2.writeObject(w);
        out2.flush();

        ByteArrayInputStream in0 = new ByteArrayInputStream(bout.toByteArray());
        ObjectInputStream in2 = new ObjectInputStream(in0);
//        String s2 = (String) in2.readObject();
        //Exception in thread "main" java.lang.ClassCastException: java.base/java.lang.String cannot be cast to com.javalearning.demo.test.io.Worm
        //	at com.javalearning.demo.test.io.Worm.main(Worm.java:69)

        Worm w3 = (Worm) in2.readObject();
        System.out.println("w3: " + w3);
    }
}

class Data implements Serializable {
    private int n;
    public Data(int n){
        this.n = n;
    }

    @Override
    public String toString() {
        return Integer.toString(n);
    }
}
