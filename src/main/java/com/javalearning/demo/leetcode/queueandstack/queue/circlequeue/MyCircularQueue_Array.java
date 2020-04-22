package com.javalearning.demo.leetcode.queueandstack.queue.circlequeue;

public class MyCircularQueue_Array {

    private int[] queue;
    private int count;
    private int size;
    private int headIndex;

    public MyCircularQueue_Array(int size){
        this.size = size;
        this.count = 0;
        this.queue = new int[size];
        this.headIndex = 0;
    }

    public boolean enQueue(int val){
        if (isFull()){
            return false;
        }
        int tailIndex = (this.headIndex + this.count) % this.size;
        this.queue[tailIndex] = val;
        this.count ++;
        return true;
    }

    public boolean deQueue(){
        if (isEmpty()){
            return false;
        }
        this.headIndex = (this.headIndex + 1) % this.size;
        this.count --;
        return true;
    }

    public int Front(){
        if (isEmpty()){
            return -1;
        }
        return this.queue[headIndex];
    }

    public int Rear(){
        if (isEmpty()){
            return -1;
        }
        int tailIndex = (this.headIndex + count - 1) % this.size;
        return this.queue[tailIndex];
    }

    public boolean isEmpty() {
        return (this.count == 0);
    }

    public boolean isFull() {
        return (this.count == this.size);
    }
}
