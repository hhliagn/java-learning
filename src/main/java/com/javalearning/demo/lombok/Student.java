package com.javalearning.demo.lombok;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
public class Student extends Fu{

    private String name;
}
