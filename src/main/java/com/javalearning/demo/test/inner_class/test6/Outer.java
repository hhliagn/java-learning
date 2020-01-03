package com.javalearning.demo.test.inner_class.test6;

public class Outer {
    private class Inner implements Swim{
        private String id;
        private Inner(String id){
            this.id = id;
        }
        public String get(){
            return id;
        }

        @Override
        public void swim() {
            System.out.println("inner swim");
        }
    }

    public Swim getSomeOneWhoCanSwim() {
        return new Inner("i can swim");
    }
}
