package com.javalearning.demo.suanfa.chpt1_jichu;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack<Item> {
    private Node<Item> first;     // top of stack
    private int n;                // size of the stack

    // helper linked hash class
    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    public Stack() {
        first = null;
        n = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return n;
    }

    public void push(Item item) {
        Node<Item> oldfirst = first;
        first = new Node<Item>();
        first.item = item;
        first.next = oldfirst;
        n++;
    }

    public Item pop() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        Item item = first.item;        // save item to return
        first = first.next;            // delete first node
        n--;
        return item;                   // return the saved item
    }

    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        return first.item;
    }

    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();
        stack.push("aaa");
        stack.push("bbb");
        stack.push("ccc");
        stack.push("ddd");

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
