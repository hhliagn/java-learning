package com.javalearning.demo.aop;

import com.google.common.collect.Lists;
import org.springframework.util.CollectionUtils;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;

public class Main {



    public static final String NAME = "Jack";
    public static final String JOE = "Joe";
    private static String joe;

    public static void main(String[] args) {
        System.out.println(2);
        int x = 1;
        System.out.println(x);

        String a = "aa";
        String b = "bb";

        // command option c
        System.out.println(JOE);
        System.out.println(NAME);
        System.out.println(NAME);
        System.out.println(NAME);
        System.out.println(NAME);
        System.out.println(NAME);
        System.out.println(NAME);
        System.out.println(NAME);
        try {
            controllRe(NAME, x);
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<Object> objects = Lists.newArrayList();
        consume(objects);

        if (CollectionUtils.isEmpty(objects)) {
            System.out.println();
        }

        if (CollectionUtils.isEmpty(objects)) {

        }


        int m = 0;
        int i = 20;
        m += i;
        System.out.println("My age is " + i);

        int g = 20;
        String bruce = "Bruce";
        String name = "Zoe";

        HttpServletRequest httpServletRequest = null;
        try {
            ServletInputStream inputStream = httpServletRequest.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Object o = new Object();
        String k = "";
        k= ((String) o);

        boolean b1 = true;
        if (b1) {
            System.out.println(b1);
        }

        System.out.println(String.format("%d %d %d", 10, 20, 30));

        throw new RuntimeException();

    }

    private static void consume(ArrayList<Object> objects) {

    }

    private static int controllRe(String name, Integer age) throws IOException {
        if (name != null) {
            System.out.println(name);
        }

        return 10;
    }


}
