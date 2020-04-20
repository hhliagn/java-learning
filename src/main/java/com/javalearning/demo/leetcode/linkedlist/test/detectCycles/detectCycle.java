package com.javalearning.demo.leetcode.linkedlist.test.detectCycles;

import com.javalearning.demo.leetcode.linkedlist.ListNode;

public class detectCycle {

    public ListNode detectCycle(ListNode head) {
        if (head == null) return head;

        ListNode oldTail = getInsection(head);

        if (oldTail!= null){
            ListNode pA = head, pB = oldTail;
            while (pA!= pB){
                pA = pA.next;
                pB = pB.next;
            }
            return pA;
        }

        return null;
    }

    private ListNode getInsection(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast!= null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return slow;
        }

        return null;
    }
}
