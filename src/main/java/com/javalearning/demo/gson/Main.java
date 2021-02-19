package com.javalearning.demo.gson;

import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static Gson gson = new Gson();

    public static void main(String[] args) {
        ArrayList<String> strings = Lists.newArrayList("aaa", "bbb", "ccc");
        String s = gson.toJson(strings);
        List<String> list = gson.fromJson(s, new TypeToken<List<String>>(){}.getType());
        System.out.println(list);
    }
}
