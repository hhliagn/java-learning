package com.javalearning.demo.test.inner_class.static_inner_class_interface;

public interface ClassInInterface {
    void play();
    class Test implements ClassInInterface{

        @Override
        public void play() {
            System.out.println("Howdy");
        }

        public static void main(String[] args) {
            new Test().play();
        }

        public static void track(ClassInInterface classInInterface){
            classInInterface.play();
        }
    }
}
