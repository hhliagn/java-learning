package com.javalearning.demo.test.io;

import java.io.*;

public class SerialCtl implements Serializable {
    private String a;
    private transient String b;

    public SerialCtl(String a, String b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public String toString() {
        return "SerialCtl{" +
                "a='" + a + '\'' +
                ", b='" + b + '\'' +
                '}';
    }

    private void writeObject(ObjectOutputStream outputStream) throws IOException {
        outputStream.defaultWriteObject();
        outputStream.writeObject(b);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        b = (String) objectInputStream.readObject();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        SerialCtl sc = new SerialCtl("thisX", "thisY");
        System.out.println("BEFORE: " + sc);

        ByteArrayOutputStream buf = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(buf);
        out.writeObject(sc);
        out.close();

        ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(buf.toByteArray()));
        sc = (SerialCtl) in.readObject();
        System.out.println("AFTER: " + sc);
    }
}
