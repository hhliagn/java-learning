package com.javalearning.demo.test.combine_and_extend;

public class Test {
    public static void main(String[] args) {
        //状态模式：在运行时改变引用指向的对象，以获得不同的行为，依赖多态
        Stage stage = new Stage();
        stage.play();
        stage.change(new SadActor());
        stage.play();
    }
}
