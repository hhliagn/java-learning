package com.javalearning.demo.spel;

import lombok.Data;

/**
 * @author lhh
 * @date 2021/3/31
 */
@Data
public class Account {

    private String name;

    public Account(String name) {
        this.name = name;
    }
}
