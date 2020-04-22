package com.javalearning.demo.leetcode.queueandstack.queue.simplequeue_array;

import java.util.ArrayList;
import java.util.List;

public class MyQueue {

    private int start;
    private List<Integer> data;

    public MyQueue(){
        this.data = new ArrayList<>();
    }

    public boolean enQueue(int val){
        data.add(val);
        return true;
    }

    public boolean deQueue(){
        if (isEmpty()){
            return false;
        }
        start ++;
        return true;
    }

    public int Front(){
        if (isEmpty()){
            return -1;
        }
        return data.get(start);
    }

    public boolean isEmpty() {
        return start >= data.size();
    }
}

class Main {
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
