package com.javalearning.demo.leetcode.queueandstack.queue.circlequeue;

/**
 * MyCircularQueue(k): 构造器，设置队列长度为 k 。
 * Front: 从队首获取元素。如果队列为空，返回 -1 。
 * Rear: 获取队尾元素。如果队列为空，返回 -1 。
 * enQueue(value): 向循环队列插入一个元素。如果成功插入则返回真。
 * deQueue(): 从循环队列中删除一个元素。如果成功删除则返回真。
 * isEmpty(): 检查循环队列是否为空。
 * isFull(): 检查循环队列是否已满。
 */

class Node{
    int val;
    Node nextNode;

    Node(int val){
        this.val = val;
    }
}
public class MyCircularQueue { //会有线程安全问题，入队出队方法要加上同步关键字

    private Node head, tail;
    private int count;
    private int size;

    public MyCircularQueue(int size){
        this.size = size;
    }

    public synchronized boolean enQueue(int val){
        if (isFull()){
            return false;
        }
        Node newNode = new Node(val);
        if (isEmpty()){
            head = tail = newNode;
        }else {
            tail.nextNode = newNode;
            tail = newNode;
        }
        count++;
        return true;
    }

    public synchronized boolean deQueue(){
        if (isEmpty()){
            return false;
        }
        count--;
        head = head.nextNode;
        return true;
    }

    public int Front(){
        if (isEmpty()){
            return -1;
        }else {
            return head.val;
        }
    }

    public int Rear(){
        if (isEmpty()){
            return -1;
        }else {
            return tail.val;
        }
    }

    public boolean isEmpty(){
        return this.count == 0;
    }

    public boolean isFull(){
        return this.count == this.size;
    }
}
