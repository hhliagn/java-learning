package com.javalearning.demo.test.inner_class.test2;

public class Test {
    public static void main(String[] args) {
        Sequence sequence = new Sequence(10);
        for (int i = 0; i < 10; i++) {
            sequence.add(Integer.toString(i));
        }
        Selector selector = sequence.selectiveSelecor();
        while (!selector.end()){
            System.out.println(selector.current() + "");
            selector.next();
        }
        Selector selector1 = sequence.reverseSelector();
        while (!selector1.end()){
            System.out.println(selector1.current() + "");
            selector1.next();
        }
    }
}
