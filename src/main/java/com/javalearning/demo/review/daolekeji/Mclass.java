package com.javalearning.demo.review.daolekeji;

import com.javalearning.demo.test.util.Stack;

public class Mclass {
    static Stack<Integer> stack = new Stack<>();
    public static int print(int m){
        int temp = m-1;
        if (m != 1){
            m *= print(temp);
            stack.push(m);
        }else {
            stack.push(m);
            return m;
        }
        return m;
    }

    public static void main(String[] args) {
        int print = print(4);
        System.out.println(print);
        while (!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }
    }
}
