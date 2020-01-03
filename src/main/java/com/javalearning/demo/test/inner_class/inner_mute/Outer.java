package com.javalearning.demo.test.inner_class.inner_mute;

public class Outer {
    private int field = 10;
    public int getField(){
        return field;
    }
    public void setField(int field) {
        this.field = field;
    }

    public class Inner{
        private int c = 20;
        public void mute(int field){
            setField(field);
            System.out.println(getField());
        }
    }

    public Inner inner(){
        return new Inner();
    }

    public int getInnerPrivate(){
        return inner().c;
    }
}
