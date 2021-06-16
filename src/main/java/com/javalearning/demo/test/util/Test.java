package com.javalearning.demo.test.util;

public class Test {
    public static void main(String[] args) {
        System.out.println((int)'+');
        System.out.println((int)'-');
        String s = "+U+n+c---+e+r+t---+A-+i-+n+t+y---+r+u--+l+e+s---";
        Stack myStack = new Stack();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length() - 1 || !myStack.isEmpty(); i++) {
            char c = s.charAt(i);
            if (c == '+'){
                char c1 = s.charAt(i + 1);
                myStack.push(c1);
            }else if (c == '-'){
                char c2 = (char) myStack.pop();
                System.out.print(c2 + "");
            }
        }
    }
}
