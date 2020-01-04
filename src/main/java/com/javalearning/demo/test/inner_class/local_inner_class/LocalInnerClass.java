package com.javalearning.demo.test.inner_class.local_inner_class;

public class LocalInnerClass {
    private int count = 0;
    Counter getCounter1(final String name){
        class LocalCounter implements Counter{
            public LocalCounter(){
                System.out.println("local counter");
            }
            @Override
            public int next() {
                System.out.print(name);
                return count ++;
            }
        }

        return new LocalCounter();
    }

    Counter getCounter2(final String name){
        return new Counter() {
            {
                System.out.println("counter");
            }
            @Override
            public int next() {
                System.out.print(name);
                return count ++;
            }
        };
    }
}
