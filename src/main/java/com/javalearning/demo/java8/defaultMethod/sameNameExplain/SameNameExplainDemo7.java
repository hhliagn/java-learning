package com.javalearning.demo.java8.defaultMethod.sameNameExplain;

/**
 * @author lhh
 * @date 2021/6/16
 */
public class SameNameExplainDemo7 {

    public static void main(String[] args) {

        // 菱形继承
        //new D7().hello();

        //new D8().hello();

        new D9().hello();
    }
}




interface A7 {
    default void hello () {
        System.out.println("Hello from A");
    }
}

interface B7 extends A7 {

}

interface C7 extends A7 {

}

class D7 implements B7, C7 {
}


/**
 * 其中一个接口重写了方法
 */
interface B8 extends A7 {

    @Override
    default void hello() {
        System.out.println("Hello from B8");
    }
}

interface C8 extends A7 {

}

class D8 implements B8, C8 {
}






/**
 * 两个接口都重写了方法
 */
interface B9 extends A7 {

    @Override
    default void hello() {
        System.out.println("Hello from B9");
    }
}

interface C9 extends A7 {

    @Override
    void hello ();
}

/**
 * 不实现无法编译
 */
class D9 implements B9, C9 {

    @Override
    public void hello() {
        System.out.println("Hello from C");
    }
}