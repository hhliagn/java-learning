package com.javalearning.demo.design_pattern.state.demo1;

public class Main {

    public static void main(String[] args) {

        Context context = new Context();

        context.setState(new UpperCaseState());

        context.write("School");

        context.setState(new LowerState());

        context.write("OnCall");
    }
}
