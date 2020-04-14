package com.javalearning.demo.leetcode.linkedlist.test;

import com.javalearning.demo.leetcode.linkedlist.ListNode;

public class getIntersectionNode {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pA = headA, pB = headB;
        while ( pA != pB){
            pA = pA == null? headB : pA.next;
            pB = pB == null? headA : pB.next;
        }
        return pA;
    }
}
