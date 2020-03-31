package com.javalearning.demo.suan_own;

public class Stack<T> {

    private int n;
    private Node<T> first;

    private class Node<T>{
        T item;
        Node<T> next;
    }

    public Stack(){
        this.n = 0;
        this.first = null;
    }

    public void push(T item){
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        n ++;
    }

    public T pop(){
        T item = first.item;
        first = first.next;
        n --;
        return item;
    }

    public T peek(){
        T item = first.item;
        return item;
    }

    public int size(){
        return n;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public static void main(String[] args) {
        Stack<String> stringStack = new Stack<>();
        stringStack.push("aaa");
        stringStack.push("bbb");
        stringStack.push("ccc");
        stringStack.push("ddd");
        stringStack.push("eee");

        while (!stringStack.isEmpty()){
            System.out.println(stringStack.pop());
        }
    }
}
