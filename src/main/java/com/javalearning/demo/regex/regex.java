package com.javalearning.demo.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class regex {

    public static boolean regex(String regex, String string){
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(string);
        boolean matches = m.matches();
        System.out.println(matches);
        return matches;
    }

    public static void main(String[] args) {
        String regex = "sales.";
//        String str = "sales.";
        String str = "sales1";



        regex(regex, str);
    }
}
