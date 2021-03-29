package com.javalearning.demo.optional.npefix;

import java.util.Objects;
import java.util.Optional;

/**
 * @author lhh
 * @date 2021/3/22
 */
public class Npefix {

    public static Optional<User> getUser(){

        User user = new User();
        user.setName("can do");
        System.out.println(user);
        return Optional.of(user);
    }

    public static Optional<User> getUser1(){

        User user = new User();
        System.out.println(user);
        return Optional.of(user);
    }

    public static Optional<User> getUser2(){
        return Optional.ofNullable(null);
    }

    public static void main(String[] args) {

        Optional<User> user = getUser();
        Optional<User> user1 = getUser1();
        Optional<User> user2 = getUser2();

        System.out.println(user.map(User::getName).map(Objects::toString).orElse("-"));
        System.out.println(user1.map(User::getName).map(Objects::toString).orElse("-"));
        System.out.println(user2.map(User::getName).map(Objects::toString).orElse("-"));
    }
}
