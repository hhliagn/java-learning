package com.javalearning.demo.leetcode.linkedlist.test;

import com.javalearning.demo.leetcode.linkedlist.ListNode;

public class detectCycle {

    public ListNode detectCycle(ListNode head) {
        ListNode insection = getInsection(head);
        if (insection!= null){
            ListNode pA = head;
            ListNode pB = insection;
            while (pA != pB){
                pA = pA.next;
                pB = pB.next;
            }
            return pA;
        }
        return null;
    }

    private ListNode getInsection(ListNode head) {
        ListNode slow = head, fast = head;
        while ( fast != null && fast.next != null){

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) return slow;
        }
        return null;
    }
}
