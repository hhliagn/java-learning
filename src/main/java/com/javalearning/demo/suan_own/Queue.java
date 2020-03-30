package com.javalearning.demo.suan_own;

public class Queue<T> {

    private Node<T> first;
    private Node<T> last;
    private int n;

    private class Node<T>{
        T item;
        Node<T> next;
    }

    public Queue(){
        first = null;
        last = null;
        n = 0;
    }

    public void enqueue(T item){
        Node oldlast = last;
        last = new Node<>();
        last.item = item;
        last.next = null;
        if (isEmpty()){
            first = last;
        }else {
            oldlast.next = last;
        }
        n ++;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public T dequeue(){
        assert isEmpty();
        T item = first.item;
        first = first.next;
        if (isEmpty()) last = null;
        n --;
        return item;
    }

    public int size(){
        return n;
    }

    public T peek(){
        assert isEmpty();
        return first.item;
    }

    public static void main(String[] args) {

    }



}
