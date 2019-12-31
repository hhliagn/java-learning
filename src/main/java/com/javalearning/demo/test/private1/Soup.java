package com.javalearning.demo.test.private1;

/**
 * 访问权限 和 单例模式
 */
public class Soup {
    private Soup(){
    }
    private static Soup s = new Soup();
    public static Soup access(){
        return s;
    }
}
