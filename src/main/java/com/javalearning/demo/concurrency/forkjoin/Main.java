package com.javalearning.demo.concurrency.forkjoin;

import java.util.concurrent.ForkJoinPool;

/**
 * @author lhh
 * @date 2021/3/29
 */
public class Main {

    public static void main(String[] args) {

        // 并行级别表示在传递到ForkJoinPool的任务上，你想要并发工作多少个线程或cpu
        ForkJoinPool forkJoinPool = new ForkJoinPool(4);

        // 您可以提交两种类型的任务。
        // 一个不返回任何结果的任务(“动作”)，以及一个返回结果的任务(“任务”)。
        // 这两种类型的任务由RecursiveAction和RecursiveTask类表示。

        MyRecursiveAction myRecursiveAction = new MyRecursiveAction(24);
        forkJoinPool.invoke(myRecursiveAction);

        MyRecursiveTask myRecursiveTask = new MyRecursiveTask(128);
        long mergedResult = forkJoinPool.invoke(myRecursiveTask);
        System.out.println("mergedResult = " + mergedResult);
    }
}
