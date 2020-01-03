package com.javalearning.demo.test.inner_class.upcase;

public class Parel4 {
    private String label;
    private class PContens implements Contents{
        private int i = 11;
        @Override
        public int value() {
            return i;
        }
    }
    protected class PDestination implements Destination{
        private String label;
        public PDestination(String label){
            this.label = label;
        }
        @Override
        public String readLabel() {
            return label;
        }
    }

    public Contents contents(){
        return new PContens();
    }
    public Destination destination(String s){
        return new PDestination(s);
    }
}
