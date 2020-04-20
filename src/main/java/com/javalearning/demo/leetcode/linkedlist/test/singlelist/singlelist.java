package com.javalearning.demo.leetcode.linkedlist.test.singlelist;

class Node {
    int val;
    Node next;

    public Node(int val){
        this.val = val;
    }
}
public class singlelist {
    int size;
    Node head;

    public singlelist(){
        size = 0;
        head = new Node(0);
    }

    public int get(int index){
        if (index<0 || index>=size) return -1;
        Node curr = head;

        //这里要+1，因为要取当前那个
        for (int i = 0; i < index + 1; i++) {
            curr = curr.next;
        }
        return curr.val;
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

        Node prev = head;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }

        Node toAdd = new Node(val);
        toAdd.next = prev.next;
        prev.next = toAdd;

        size++;
    }

    public void deleteAtIndex(int index){
        if (index<0 || index>=size) return;

        Node prev = head;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }

        prev.next = prev.next.next;
        size--;
    }

}
