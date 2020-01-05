package com.javalearning.demo.test.inner_class.callback;

public class Callee2 extends MyIncrement {
    private int i = 0;

    @Override
    public void increment() {
        super.increment();
        i ++;
        System.out.println(i);
    }

    private class Closure implements Incrementable{

        @Override
        public void increment() {
            Callee2.this.increment();
        }
    }

    public Incrementable getCallBackReference(){
        return new Closure();
    }
}
