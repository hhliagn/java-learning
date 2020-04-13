package com.javalearning.demo.leetcode.linkedlist;

public class MyLinkedList {
    ListNode head;
    int size;

    public MyLinkedList(){
        size = 0;
        head = new ListNode(0);
    }

    public int get(int index){
        if (index<0 || index>=size){
            return -1;
        }
        ListNode cur= head;
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
        ListNode cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        ListNode succ = cur.next;
        ListNode toAdd = new ListNode(val);
        toAdd.next = succ;
        cur.next = toAdd;
        size++;
    }

    public void deleteAtIndex(int index){
        if (index<0||index>=size)return;
        ListNode cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        size--;
    }
}

