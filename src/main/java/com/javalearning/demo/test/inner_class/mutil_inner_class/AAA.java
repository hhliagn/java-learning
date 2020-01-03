package com.javalearning.demo.test.inner_class.mutil_inner_class;

public class AAA {
    private void aaa(){
        System.out.println("aaa");
    }
    class BBB{
        private void bbb(){
            System.out.println("bbb");
        }
        class CCC{
            void ccc(){
                aaa();
                bbb();
                System.out.println("ccc");
            }
        }
    }
}
