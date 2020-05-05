package com.javalearning.demo.leetcode.queueandstack.queue.circlequeue.test;

/**
 * @description cc
 * @date 2020/5/5
 */
public class MyCircleQueueArray {
    private int[] data;
    private int head, tail;
    private int size;
    private int count;

    public MyCircleQueueArray(int size){
        count = 0;
        this.size = size;
        data = new int[size];
    }

    public boolean enQueue(int val){
        if (isFull()) return false;
        if (isEmpty()) {
            head = 0;
            tail = -1;
        }
        tail = (tail +1)%size;
        data[tail] = val;
        count++;
        return true;
    }

    public boolean deQueue(){
        if (isEmpty()) return false;
        head = (head +1)%size;
        count --;
        return true;
    }

    public int Front(){
        if (isEmpty()) return -1;
        return data[head];
    }

    public int Rear(){
        if (isEmpty()) return -1;
        return data[tail];
    }

    public boolean isFull(){
        return count == size;
    }

    public boolean isEmpty(){
        return count == 0;
    }
}
