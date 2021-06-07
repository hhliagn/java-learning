package com.javalearning.demo.suanfa.chpt1_jichu;

import java.util.NoSuchElementException;

public class Queue<Item> {
    private Node<Item> first;    // beginning of queueandstack
    private Node<Item> last;     // end of queueandstack
    private int n;               // number of elements on queueandstack

    // helper linked hash class
    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    public Queue() {
        first = null;
        last  = null;
        n = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return n;
    }

    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        return first.item;
    }

    public void enqueue(Item item) {
        Node<Item> oldlast = last;
        last = new Node<Item>();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last;
        else           oldlast.next = last;
        n++;
    }

    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        Item item = first.item;
        first = first.next;
        n--;
        if (isEmpty()) last = null;   // to avoid loitering
        return item;
    }

    public static void main(String[] args) {
        Queue<String> queue = new Queue<String>();
        queue.enqueue("aaa");
        queue.enqueue("bbb");
        queue.enqueue("ccc");
        queue.enqueue("ddd");
        queue.enqueue("eee");

        while (!queue.isEmpty()) {
            System.out.println(queue.dequeue());
        }
    }
}

