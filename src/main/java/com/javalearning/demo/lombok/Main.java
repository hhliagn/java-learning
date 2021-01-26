package com.javalearning.demo.lombok;

public class Main {

    public static void main(String[] args) {
        Student student = new Student();
        student.setName("aaa");
        student.setAge(12);
        System.out.println(student);
    }
}
