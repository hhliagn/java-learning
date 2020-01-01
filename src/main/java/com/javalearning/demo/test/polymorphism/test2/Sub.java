package com.javalearning.demo.test.polymorphism.test2;

public class Sub extends Super {
    public int field = 1;

    public int getSuperField(){
        return super.field;
    }

    @Override
    public int getField() {
        return field;
    }

    @Override
    public void setField(int field) {
        this.field = field;
    }
}
