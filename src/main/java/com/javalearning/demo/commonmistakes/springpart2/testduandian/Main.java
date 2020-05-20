package com.javalearning.demo.commonmistakes.springpart2.testduandian;

/**
 * @author lhh
 * @date 2020/5/19
 */
public class Main {

    public static void main(String[] args) {
        God god = new God();
        Person person = god.makePerson();
    }
}
