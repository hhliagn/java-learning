package com.javalearning.demo.annotation;

import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.util.Date;

@Data
@JsonNaming
public class MyClass {

    @MyLabel("姓名")
    private String name;

    @MyLabel("年龄")
    private Integer age;

    @MyLabel("生日")
    private Date birthday;
}
