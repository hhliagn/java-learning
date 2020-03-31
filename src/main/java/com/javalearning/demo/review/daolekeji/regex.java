package com.javalearning.demo.review.daolekeji;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class regex {

    public static boolean check(String str){
        Pattern p = Pattern.compile("\\d{3}-\\d{3}-\\d{3}");
        Matcher m = p.matcher(str);
        return m.matches();
    }

    public static void main(String[] args) {
        boolean check = check("123-456-789");
        System.out.println(check);
    }
}
