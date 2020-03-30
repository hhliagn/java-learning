package com.javalearning.demo.test.io;

import java.io.*;
import java.util.Date;

public class Logon implements Serializable{

    private Date date = new Date();
    private String username;
    private transient String password;

    public Logon(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Logon{" +
                "date=" + date +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Logon a = new Logon("zhangsan", "mylittlelove");
        System.out.println("Logon a: " + a);

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("logon.out"));
        out.writeObject(a);
        out.close();

        ObjectInputStream in = new ObjectInputStream(new FileInputStream("logon.out"));
        a = (Logon) in.readObject();
        System.out.println("Logon a: " + a);
    }
}
