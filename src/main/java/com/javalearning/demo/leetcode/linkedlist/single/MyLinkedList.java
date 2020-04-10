package com.javalearning.demo.leetcode.linkedlist.single;

class Node{
    int val;
    Node next;
    Node(int x){
        val = x;
    }
}
public class MyLinkedList {
    Node head;
    int size;

    public MyLinkedList(){
        size = 0;
        head = new Node(0);
    }

    public int get(int index){
        if (index<0 || index>=size){
            return -1;
        }
        Node cur= head;
        for (int i = 0; i < index+1; i++) {
            cur = cur.next;
        }
        return cur.val;
    }

    public void addAtHead(int val){
        addAtIndex(0, val);
    }

    public void addAtTail(int val){
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val){
        if (index<0) index = 0;
        if (index>size) return;
        Node cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        Node succ = cur.next;
        Node toAdd = new Node(val);
        toAdd.next = succ;
        cur.next = toAdd;
        size++;
    }

    public void deleteAtIndex(int index){
        if (index<0||index>=size)return;
        Node cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        size--;
    }
}
