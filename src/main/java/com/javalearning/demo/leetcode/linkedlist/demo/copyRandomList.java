package com.javalearning.demo.leetcode.linkedlist.demo;

import lombok.AllArgsConstructor;

import java.util.HashMap;

@AllArgsConstructor
class Node1 {
    int val;
    Node1 next;
    Node1 random;

    public Node1(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
public class copyRandomList {

    HashMap<Node1, Node1> visited = new HashMap<>();

    public Node1 getClonedNode(Node1 node) {
        if (node != null) {
            if (this.visited.containsKey(node)) {
                return this.visited.get(node);
            } else {
                this.visited.put(node, new Node1(node.val, null, null));
                return this.visited.get(node);
            }
        }
        return null;
    }

    public Node1 copyRandomList(Node1 head) {

        if (head == null) {
            return null;
        }

        Node1 oldNode = head;
        Node1 newNode = new Node1(oldNode.val);
        this.visited.put(oldNode, newNode);

        while (oldNode != null) {
            newNode.random = this.getClonedNode(oldNode.random);
            newNode.next = this.getClonedNode(oldNode.next);

            oldNode = oldNode.next;
            newNode = newNode.next;
        }
        return this.visited.get(head);
    }
}
