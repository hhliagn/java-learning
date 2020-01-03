package com.javalearning.demo.test.inner_class.upcase.inner_class_in_method;

import com.javalearning.demo.test.inner_class.upcase.Destination;

public class Parel5 {
    public Destination destination(String s){
        class PDestionation implements Destination{
            private String label;
            private PDestionation(String label){
                this.label = label;
            }
            @Override
            public String readLabel() {
                return label;
            }
        }
        return new PDestionation(s);
    }

    public static void main(String[] args) {
        Parel5 parel5 = new Parel5();
        Destination i_am_ok = parel5.destination("i am ok");
        String s = i_am_ok.readLabel();
        System.out.println(s);
    }
}
