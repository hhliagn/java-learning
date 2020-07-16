package com.javalearning.demo.commonmistakes.equals.lombokequals;

import io.swagger.models.auth.In;
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

    @GetMapping("/wrong")
    public void wrong(){
        Person person1 = new Person("aaa", 111);
        Person person2 = new Person("bbb", 111);
        log.info("p1 equals p2 {}", person1.equals(person2));
    }

    @GetMapping("/right")
    public void right(){
        Employee e1 = new Employee("zhang", 111, "bjk.com");
        Employee e2 = new Employee("wang", 222, "bjk.com");
        log.info("e1 equals e2 {}", e1.equals(e2));
    }

    @Data
    class Person{
        @EqualsAndHashCode.Exclude
        String name;
        Integer identity;

        Person(String name, Integer identity){
            this.name = name;
            this.identity = identity;
        }
    }

    @Data
    @EqualsAndHashCode(callSuper = true)
    class Employee extends Person{
        String company;

        public Employee(String name, Integer identity, String company) {
            super(name, identity);
            this.company = company;
        }
    }
}
