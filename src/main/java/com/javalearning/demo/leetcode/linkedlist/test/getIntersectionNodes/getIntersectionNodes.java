package com.javalearning.demo.leetcode.linkedlist.test.getIntersectionNodes;

import com.javalearning.demo.leetcode.linkedlist.ListNode;

public class getIntersectionNodes {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode pA = headA, pB = headB;
        while (pA != pB){
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }

        return pA;
    }
}
