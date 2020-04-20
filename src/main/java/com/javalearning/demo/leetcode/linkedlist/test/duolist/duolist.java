package com.javalearning.demo.leetcode.linkedlist.test.duolist;

class Node{

    int val;
    Node prev;
    Node next;

    Node(int val){
        this.val = val;
    }
}
public class duolist {

    int size;
    Node head;
    Node tail;

    public duolist(){
        size = 0;
        head = new Node(0);
        tail = new Node(0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int index){
        if (index < 0 || index>= size) return -1;
        Node prev;
        if (index>=size-index){
            prev = tail;
            for (int i = 0; i < size-index; i++) {
                prev = prev.prev;
            }
        }else {
            prev = head;
            for (int i = 0; i < index+1; i++) {
                prev = prev.next;
            }
        }

        return prev.val;
    }

    public void addAtHead(int val){

        Node toAdd = new Node(val);
        Node prev = head, succ = head.next;

        toAdd.prev = prev;
        toAdd.next = succ;
        prev.next = toAdd;
        succ.prev = toAdd;

        size++;
    }

    public void addAtTail(int val){
        Node toAdd = new Node(val);

        Node prev = tail.prev, succ = tail;
        toAdd.prev = prev;
        toAdd.next = succ;
        prev.next = toAdd;
        succ.prev = toAdd;

        size++;
    }

    public void addAtIndex(int index, int val){

        if (index<0) index = 0;
        if (index>size) return;

        Node prev, succ;
        if (index >= size-index){
            succ = tail;

            for (int i = 0; i < size-index; i++) {
                succ  =succ.prev;
            }

            prev = succ.prev;
        }else {
            prev = head;

            for (int i = 0; i < index; i++) {
                prev = prev.next;
            }

            succ = prev.next;
        }

        Node toAdd = new Node(val);
        toAdd.next = succ;
        toAdd.prev = prev;
        prev.next = toAdd;
        succ.prev = toAdd;

        size++;
    }

    public void deleteAtIndex(int index){
        if (index<0 || index >= size) return;

        Node prev,succ;
        if (index>=size-index){
            succ = tail;
            for (int i = 0; i < size-index-1; i++) {
                succ = succ.prev;
            }
            prev = succ.prev.prev;
        }else {
            prev = head;
            for (int i = 0; i < index; i++) {
                prev = prev.next;
            }
            succ = prev.next.next;
        }

        prev.next = succ;
        succ.prev = prev;

        size--;
    }
}
