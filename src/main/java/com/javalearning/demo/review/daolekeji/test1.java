package com.javalearning.demo.review.daolekeji;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test1 {

    //1
    @GetMapping("/sum")
    public void sum(@RequestParam("price") Double price, @RequestParam("num") Integer num){
        double total = (price * num) * 0.75;
        System.out.println(total);
    }

    //2
    public static void printNum(){
        String str="i,j,6,k,2,p,h";
        String[] split = str.split(",");
        List<Integer> posList = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            boolean b = isNumberic2(split[i]);
            if (b){
                posList.add(i);
            }
        }
        System.out.println(posList);
    }

    private static boolean isNumberic2(String s) {
        Pattern pattern = Pattern.compile("-?[0-9]+\\.?[0-9]*");
        Matcher isNum = pattern.matcher(s);
        if (!isNum.matches()) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        printNum();
    }

    private static boolean isNumberic1(String s) {
        try {
            int i = Integer.parseInt(s);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
