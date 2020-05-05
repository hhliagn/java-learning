package com.javalearning.demo.leetcode.queueandstack.queue.simplequeue_array.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @description cc
 * @date 2020/5/5
 */
public class MyQueue {

    private int start;
    private List<Integer> data;

    public MyQueue(){
        this.start = 0;
        this.data = new ArrayList<>();
    }

    public void enQueue(int val){
        this.data.add(val);
    }

    public boolean isEmpty(){
        return this.start >= data.size();
    }

    public int deQueue(){
        if (isEmpty()) return -1;
        int head = data.get(start);
        start ++;
        return head;
    }

    public int Front(){
        return data.get(start);
    }
}

class Main{
    public static void main(String[] args) {
        MyQueue q = new MyQueue();
        q.enQueue(5);
        q.enQueue(3);
        if (q.isEmpty() == false) {
            System.out.println(q.Front());
        }
        q.deQueue();
        if (q.isEmpty() == false) {
            System.out.println(q.Front());
        }
        q.deQueue();
        if (q.isEmpty() == false) {
            System.out.println(q.Front());
        }
    }
}
