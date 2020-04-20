package com.javalearning.demo.leetcode.linkedlist.test.rotateRights;

import com.javalearning.demo.leetcode.linkedlist.ListNode;

public class rotateRights {

    public ListNode rotateRight(ListNode head, int k) {
        ListNode oldTail = head;
        int n=1;
        while (oldTail.next!=null){
            oldTail = oldTail.next;
            n++;
        }

        //使链表成环
        oldTail.next = head;

        ListNode newTail  = head;
        for(int i = 0; i< n - k%n -1; i++){
            newTail = newTail.next;
        }

        ListNode newHead = newTail.next;
        //这一步是断开链表环
        newTail.next = null;

        return newHead;
    }
}
