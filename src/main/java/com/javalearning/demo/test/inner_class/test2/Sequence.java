package com.javalearning.demo.test.inner_class.test2;

public class Sequence {
    private Object[] items;
    private int next = 0;
    public Sequence(int size){
        items = new Object[size];
    }
    public void add(Object x){
        if (next < items.length){
            items[next ++] = x;
        }
    }
    public Selector selector(){
        return new SelectiveSelecor();
    }
    private class SelectiveSelecor implements Selector{

        private int i = 0;

        @Override
        public boolean end() {
            return i == items.length;
        }

        @Override
        public Object current() {
            return items[i];
        }

        @Override
        public void next() {
            if (i < items.length) i++;
        }
    }
}
