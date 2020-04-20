package com.javalearning.demo.leetcode.linkedlist.demo;

import com.javalearning.demo.leetcode.linkedlist.ListNode;

public class rotateRight {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        if (head.next == null) return head;

        int n;
        ListNode oldTail = head;
        for(n = 1; oldTail.next!= null;n++){
            oldTail = oldTail.next;
        }
        oldTail.next = head;

        ListNode newTail = head;
        for(int i = 0; i < n - k%n -1; i++){
            newTail = newTail.next;
        }

        ListNode newHead = newTail.next;
        newTail.next = null;
        return newHead;
    }
}
