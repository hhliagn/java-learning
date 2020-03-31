package com.javalearning.demo.lambda;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Student{
    private String name;
    private int age;
    private  int score;

    public Student(String name, int age, int score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }
}
public class demo10 {

    /**
     * lambda 常用接口 Comparator
     */
    public static void main(String[] args) {
        List<Student> stus = new ArrayList<>();

        stus.add(new Student("张三",23,82));
        stus.add(new Student("李四",24,90));
        stus.add(new Student("王五",30,79));
        stus.add(new Student("赵六",18,65));

        Collections.sort(stus, (Student o1, Student o2) -> {
            return o1.getAge() - o2.getAge();
        });

        stus.forEach(student -> System.out.println(student));
    }
}
