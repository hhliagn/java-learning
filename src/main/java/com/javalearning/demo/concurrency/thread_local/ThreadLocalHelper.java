package com.javalearning.demo.concurrency.thread_local;

public class ThreadLocalHelper {

    private static ThreadLocal<String> threadMap = ThreadLocal.withInitial(() -> null);

    public static void set(String str){
        threadMap.set(str);
    }

    public static String get(){
        return threadMap.get();
    }

    public static void remove(){
        threadMap.remove();
    }
}
