package com.javalearning.demo.test.containers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountedString {

    private static List<String> created = new ArrayList<>();
    private String s;
    private int id;

    public CountedString(String s){
        this.s = s;
        created.add(s);
        for (String s1 : created) {
            if (s1.equals(s)){
                id ++;
            }
        }
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof CountedString &&
                (s.equals(((CountedString) obj).s) &&
                        (id == ((CountedString) obj).id));
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 37 * result + s.hashCode();
        result = 37 * result + id;
        return result;
    }

    @Override
    public String toString() {
        return "String: " + s + " id: " + id + " hashCode(): " + hashCode();
    }

    public static void main(String[] args) {
        Map<CountedString, Integer> map = new HashMap<>();
        CountedString[] cs = new CountedString[5];
        for (int i = 0; i < cs.length; i++) {
            cs[i] = new CountedString("hi");

            map.put(cs[i] , i);
        }

        System.out.println(map);

        for (CountedString c : cs) {
            System.out.println("looking for " + c);
            System.out.println(map.get(c));
        }
    }
}
