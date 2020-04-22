package com.javalearning.demo.commonmistakes.equals.lombokequals;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("lombokequals")
public class LombokEquealsController {

    @GetMapping("test1")
    public void test1(){
        Person p1 = new Person("001", "myx");
        Person p2 = new Person("001", "myz");
        log.info("p1 equals p2? {}", p1.equals(p2));
    }

    @GetMapping("test2")
    public void test2(){
        Employee p1 = new Employee("001", "myx", "baidu.com");
        Employee p2 = new Employee("002", "myz", "baidu.com");
        log.info("p1 equals p2? {}", p1.equals(p2));
    }

    @Data
    class Person{
        String identity;
        @EqualsAndHashCode.Exclude
        String name;

        public Person(String identity, String name){
            this.identity = identity;
            this.name = name;
        }
    }

    @Data
    @EqualsAndHashCode(callSuper = true)
    class Employee extends Person{
        private String company;

        public Employee(String identity, String name, String company) {
            super(identity, name);
            this.company = company;
        }
    }
}
