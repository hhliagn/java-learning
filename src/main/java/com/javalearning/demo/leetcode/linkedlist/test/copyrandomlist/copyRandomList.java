package com.javalearning.demo.leetcode.linkedlist.test.copyrandomlist;

import lombok.AllArgsConstructor;
import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
class Node{
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
public class copyRandomList {

    Map<Node, Node> visited= new HashMap<>();
    public Node copyRandomList(Node head) {

        if (head == null) return head;

        Node oldnode =head;
        Node newnode = new Node(head.val, null, null);

        this.visited.put(oldnode, newnode);

        while (oldnode!= null){
            newnode.next = getNodeVisited(oldnode.next);
            newnode.random = getNodeVisited(oldnode.random);

            oldnode = oldnode.next;
            newnode = newnode.next;
        }

        return this.visited.get(head);
    }

    private Node getNodeVisited(Node node) {
        if (node!= null){
            if (!this.visited.containsKey(node)){
                this.visited.put(node, new Node(node.val, null, null));
            }

            return this.visited.get(node);
        }

        return null;
    }
}
