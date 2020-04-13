package com.javalearning.demo.leetcode.linkedlist.twopointer;

import com.javalearning.demo.leetcode.linkedlist.ListNode;

public class getIntersectionNode {

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA != pB){
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}
