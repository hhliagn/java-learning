package com.javalearning.demo.test.generics;

public class LinkedStack<T> {
    private static class Node<T>{
        T item;
        Node<T> next;
        public Node(T item, Node<T> next){
            this.item = item;
            this.next = next;
        }
        public Node(){
            this.item = null;
            this.next = null;
        }
        public boolean end(){
            return item == null && next == null;
        }
    }
    private Node<T> top = new Node<T>();
    public void push(T item){
        top = new Node<T>(item, top);
    }
    public T pop(){
        T result = top.item;
        if (!top.end()){
            top = top.next;
        }
        return result;
    }


    public static void main(String[] args) {
        LinkedStack<String> stringLinkedStack = new LinkedStack<>();
        for (String s : "Phasers on stan!".split(" ")) {
            stringLinkedStack.push(s);
        }
        String s = "";
        while ((s = stringLinkedStack.pop()) != null){
            System.out.println(s);
        }
    }
}
