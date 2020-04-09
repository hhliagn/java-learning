package com.javalearning.demo.leetcode.linkedlist;

/**
 * get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
 * addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
 * addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
 * addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val  的节点。如果 index 等于链表的长度，则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
 * deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
 *
 * MyLinkedList linkedList = new MyLinkedList();
 * linkedList.addAtHead(1);
 * linkedList.addAtTail(3);
 * linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
 * linkedList.get(1);            //返回2
 * linkedList.deleteAtIndex(1);  //现在链表是1-> 3
 * linkedList.get(1);            //返回3
 */
public class MyLinkedList {

    static class Node{
        int val;
        Node next;
        Node(int val){
            this.val = val;
        }
    }

    Node head;
    int size;

    /** Initialize your data structure here. */
    public MyLinkedList() {
        this.size = 0;
        this.head = new Node(0);
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index<0 || index>=size) return -1;
        Node cur = head;
        for (int i = 0; i < index+1; i++) {
            cur = cur.next;
        }
        return cur.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node newHead = new Node(val);
        newHead.next = head;
        head = newHead;
        size++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node tmp = head;
        while (true){
            if (tmp.next == null){
                Node tail = new Node(val);
                tmp.next = tail;
                break;
            }else {
                tmp = tmp.next;
            }
        }
        size++;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index==size){
            addAtTail(val);
        }else if (index>size){
            return;
        }else if (index<=0){
            addAtHead(val);
        }
        Node tmp = head;
        for (int i = 1; i <=index; i++) {
            Node next = tmp.next;
            tmp = next;
        }
        Node add = new Node(val);
        tmp.next = add;
        size++;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index<0 || index>=size){
            return;
        }
        Node tmp = head;
        Node pre = null;
        Node newNext = null;
        for (int i = 1; i <= index; i++) {
            Node next = tmp.next;
            if (i == index){
                pre = tmp;
            }
            tmp = next;
        }
        newNext = tmp;
        pre.next = newNext;
        size--;
    }
}
