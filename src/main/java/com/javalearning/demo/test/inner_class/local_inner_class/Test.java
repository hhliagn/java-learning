package com.javalearning.demo.test.inner_class.local_inner_class;

public class Test {
    public static void main(String[] args) {
        LocalInnerClass lic = new LocalInnerClass();
        Counter local_inner = lic.getCounter1("Local inner");
        Counter anoymous_inner = lic.getCounter2("Anoymous inner");
        for (int i = 0; i < 5; i++) {
            System.out.println(local_inner.next());
        }
        for (int i = 0; i < 5; i++) {
            System.out.println(anoymous_inner.next());
        }
    }
}
