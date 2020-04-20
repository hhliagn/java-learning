package com.javalearning.demo.leetcode.linkedlist.test.flatten;

import lombok.AllArgsConstructor;

import java.util.ArrayDeque;
import java.util.Deque;

@AllArgsConstructor
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
}
public class flatten {
    public Node flatten(Node head) {
        if (head == null) return head;
        Node presudohead = new Node(0, null, head, null);
        flatten_dfs(presudohead, head);

        presudohead.next.prev = null;
        return presudohead.next;

    }

    private Node flatten_dfs(Node prev, Node curr) {
        if (curr == null) return prev;
        prev.next = curr;
        curr.prev = prev;

        Node tempnext = curr.next;

        Node tail = flatten_dfs(curr, curr.child);
        curr.child = null;

        return flatten_dfs(tail,tempnext);
    }


    public Node flatten2(Node head){

        if (head == null) return head;
        Node presudohead  = new Node(0, null, head, null);
        Node curr, prev = presudohead;

        Deque<Node> stack = new ArrayDeque<>();
        stack.push(head);

        while (!stack.isEmpty()){
            curr = stack.pop();
            prev.next = curr;
            curr.prev = prev;

            if (curr.next!= null) stack.push(curr.next);

            if (curr.child  != null) {
                stack.push(curr.child);
                curr.child = null;
            }

            prev = curr;
        }

        presudohead.next.prev = null;
        return presudohead.next;
    }


}
