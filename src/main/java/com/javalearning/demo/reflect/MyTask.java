package com.javalearning.demo.reflect;

import java.lang.reflect.Method;
import java.util.TimerTask;

/**
 * @author lhh
 * @date 2021/3/30
 */
public class MyTask extends TimerTask {

    @SuppressWarnings(value = "unchecked")
    @Override
    public void run() {

        try {
            Class<A> a1 = (Class<A>) Class.forName("com.javalearning.demo.reflect.A");
            A a = a1.newInstance();
            Method f1 = a1.getDeclaredMethod("f1");
            if (!f1.isAccessible()) {
                f1.setAccessible(true);
            }

            f1.invoke(a);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
