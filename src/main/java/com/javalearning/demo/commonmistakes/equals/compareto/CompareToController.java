package com.javalearning.demo.commonmistakes.equals.compareto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.comparator.Comparators;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("compareto")
public class CompareToController {

    @GetMapping("wrong")
    public void wrong(){
        List<Student> studentList = new ArrayList<>();
        Student a = new Student(1, "liang");
        Student b = new Student(2, "wang");
        studentList.add(a);
        studentList.add(b);
        Student c = new Student(2, "liu");
        log.info("index of c: {}", studentList.indexOf(c));
        Collections.sort(studentList);
        log.info("binary search c：{}", Collections.binarySearch(studentList, c));
    }

    @GetMapping("right")
    public void right(){
        List<StudentRight> list = new ArrayList<>();
        list.add(new StudentRight(1, "zhang"));
        list.add(new StudentRight(2, "wang"));
        StudentRight student = new StudentRight(2, "li");

        log.info("ArrayList.indexOf");
        int index1 = list.indexOf(student);
        Collections.sort(list);
        log.info("Collections.binarySearch");
        int index2 = Collections.binarySearch(list, student);

        log.info("index1 = " + index1);
        log.info("index2 = " + index2);
    }

    @AllArgsConstructor
    class Student implements Comparable<Student> {
        int id;
        String name;

        @Override
        public int compareTo(Student that) {
            int compare = Integer.compare(id, that.id);
            if (compare == 0){
                log.info("this {} == that {}", this, that);
            }
            return compare;
        }
    }

    @AllArgsConstructor
    @Data
    class StudentRight implements Comparable<StudentRight>{
        int id;
        String name;

        @Override
        public int compareTo(StudentRight other) {
            return Comparator.comparing(StudentRight::getName)
                    .thenComparingInt(StudentRight::getId)
                    .compare(this, other);
        }
    }
}
