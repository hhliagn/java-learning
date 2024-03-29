package com.javalearning.demo.commonmistakes.oom.usernameautocomplete;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Data
public class UserDTO {
    private String name;
    @EqualsAndHashCode.Exclude
    private String payload;

    public UserDTO(String name) {
        this.name = name;
        this.payload = IntStream.rangeClosed(1, 10_000)
                .mapToObj(__ -> "A")
                .collect(Collectors.joining(""));
    }
}