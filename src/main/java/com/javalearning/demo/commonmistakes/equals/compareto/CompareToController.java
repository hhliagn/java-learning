package com.javalearning.demo.commonmistakes.equals.compareto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@Slf4j
@RequestMapping("compareto")
public class CompareToController {

    @GetMapping("/wrong")
    public void wrong(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "zhang"));
        students.add(new Student(2, "wang"));

        Student li = new Student(2, "li");
        int index1 = students.indexOf(li);
        int index2 = Collections.binarySearch(students, li);

        log.info("wrong - indexOf: {}", index1);
        log.info("wrong - binarySearch: {}", index2);
    }

    @GetMapping("/right")
    public void right(){
        List<StudentRight> students = new ArrayList<>();
        students.add(new StudentRight(1, "zhang"));
        students.add(new StudentRight(2, "wang"));

        StudentRight li = new StudentRight(2, "li");
        int index1 = students.indexOf(li);
        int index2 = Collections.binarySearch(students, li);

        log.info("right - indexOf: {}", index1);
        log.info("right - binarySearch: {}", index2);
    }


    @Data
    @AllArgsConstructor
    class Student implements Comparable<Student>{
        int age;
        String name;

        @Override
        public int compareTo(Student other) {
            int result = Integer.compare(age, other.age);
            if (result == 0){
               log.info("this {} == other {}", this, other);
            }
            return result;
        }
    }

    @Data
    @AllArgsConstructor
    class StudentRight implements Comparable<StudentRight>{

        int age;
        String name;

        @Override
        public int compareTo(StudentRight other) {
            return Comparator.comparing(StudentRight::getName)
                    .thenComparingInt(StudentRight::getAge)
                    .compare(this, other);
        }
    }


}
