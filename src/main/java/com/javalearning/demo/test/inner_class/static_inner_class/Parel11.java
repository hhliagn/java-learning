package com.javalearning.demo.test.inner_class.static_inner_class;

import com.javalearning.demo.test.inner_class.upcase.Contents;
import com.javalearning.demo.test.inner_class.upcase.Destination;

public class Parel11 {
    private static class PContents implements Contents{
        private int id;
        private PContents(int id){
            this.id = id;
        }
        @Override
        public int value() {
            return id;
        }
    }
    private static class PDestination implements Destination{
        private String label;

        private PDestination(String label){
            this.label = label;
        }

        @Override
        public String readLabel() {
            return label;
        }

        public static void f(){

        }

        static int i = 10;

        static class AnthorLevel{
            static void f(){

            }
            static int x = 20;
        }
    }

    public static Contents contents(){
        return new PContents(10);
    }

    public static Destination destination(String s){
        return new PDestination(s);
    }

    public static void main(String[] args) {
        Contents contents = contents();
        Destination destination = destination("i am working");
    }
}
