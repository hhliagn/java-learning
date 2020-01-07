package com.javalearning.demo.test.strings;

public class WitherStringBuilder {
    public static void main(String[] args) {

    }

    public String implicit(String[] fields){
        String result = "";
        for (String field : fields) {
            result += field;
        }
        return result;
    }
    public String explicit(String[] fields){
        StringBuilder result = new StringBuilder();
        for (String field : fields) {
            result.append(field);
        }
        return result.toString();
    }
}
