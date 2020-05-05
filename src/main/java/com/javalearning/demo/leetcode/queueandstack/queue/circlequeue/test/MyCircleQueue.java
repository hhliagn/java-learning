package com.javalearning.demo.leetcode.queueandstack.queue.circlequeue.test;

/**
 * @description cc
 * @date 2020/5/5
 */
public class MyCircleQueue {
    class Node{
        int val;
        Node next;
        Node(int val){
            this.val = val;
        }
    }

    Node head, tail;
    int size;
    int count;

    public MyCircleQueue(int size){
        this.size = size;
    }

    public void enQueue(int val){
        if (isFull()) return;
        Node toAdd = new Node(val);
        if (isEmpty()){
            head = tail = toAdd;
        }else {
            tail.next = toAdd;
            tail = toAdd;
        }
        count ++;
    }

    public int deQueue(){
        if (isEmpty()) return -1;
        int val = head.val;
        head = head.next;
        count --;
        return val;
    }

    public int Front(){
        if (isEmpty()) return -1;
        return head.val;
    }

    public boolean isFull(){
        return count == size;
    }

    public boolean isEmpty(){
        return count == 0;
    }
}
