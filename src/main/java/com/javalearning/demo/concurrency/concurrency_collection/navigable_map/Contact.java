package com.javalearning.demo.concurrency.concurrency_collection.navigable_map;

import lombok.Data;

@Data
public class Contact {

    private String name;
    private String phone;

    public Contact(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }
}
