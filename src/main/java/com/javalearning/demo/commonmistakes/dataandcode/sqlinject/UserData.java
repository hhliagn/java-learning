package com.javalearning.demo.commonmistakes.dataandcode.sqlinject;

import lombok.Data;

@Data
public class UserData {
    private Long id;
    private String name;
    private String password;
}