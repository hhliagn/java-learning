package com.javalearning.demo.leetcode.linkedlist;

class Node{
    int val;
    Node next;
    Node prev;
    Node(int val){
        this.val = val;
    }
}
public class MyLinkedList {

    Node head;
    Node tail;
    int size;

    public MyLinkedList(){
        head = new Node(0);
        tail = new Node(0);
        //这两步不能省
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    public int get(int index) {
        if (index < 0 || index >= size) return -1;
        Node cur = head;
        if (index < size-index){
            for (int i = 0; i < index+1; i++) {
                cur = cur.next;
            }
        }else {
            cur = tail;
            for (int i = 0; i < size - index; i++) {
                cur = cur.prev;
            }
        }
        return cur.val;
    }

    public void addAtHead(int val) {
        Node pred = head, succ = head.next;
        Node toAdd = new Node(val);

        toAdd.prev = pred;
        toAdd.next = succ;
        pred.next = toAdd;
        succ.prev = toAdd;

        size++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node pred = tail.prev, succ = tail;
        Node toAdd = new Node(val);

        toAdd.prev = pred;
        toAdd.next = succ;
        pred.next = toAdd;
        succ.prev = toAdd;

        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index>size){
            return;
        }
        if (index<0){
            index = 0;
        }
        Node pred, succ;
        if (index < size - index){
            pred = head;
            for (int i = 0; i < index; i++) {
                pred = pred.next;
            }
            succ = pred.next;
        }else {
            succ = tail;
            for (int i = 0; i < size-index; i++) {
                succ = succ.prev;
            }
            pred = succ.prev;
        }

        Node toAdd = new Node(val);
        toAdd.next = succ;
        toAdd.prev = pred;
        pred.next = toAdd;
        succ.prev = toAdd;

        size++;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index <0 || index>=size){
            return;
        }

        Node pred, succ;
        if (index<size - index){
            pred = head;
            for (int i = 0; i < index; i++) {
                pred = pred.next;
            }
            succ = pred.next.next;
        }else {
            succ = tail;
            for (int i = 0; i < size-index-1; i++) {
                succ = succ.prev;
            }
            pred = succ.prev.prev;
        }

        pred.next = succ;
        succ.prev = pred;

        size--;
    }
}
