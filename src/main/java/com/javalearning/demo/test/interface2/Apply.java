package com.javalearning.demo.test.interface2;

public class Apply {
    private Processor processor;
    public Apply(Processor processor){
        this.processor = processor;
    }
    public static void process(Processor p, Object o){
        System.out.println(p.name());
        System.out.println(p.process(o));
    }

    public static void main(String[] args) {
        String s = "i am A hero";
        process(new UpperProcessor(), s);
        process(new LowerProcessor(), s);
        process(new ArrayProcessor(), s);
    }
}
