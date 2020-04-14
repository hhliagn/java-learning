package com.javalearning.demo.leetcode.linkedlist.test;

import com.javalearning.demo.leetcode.linkedlist.ListNode;

public class removeNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        int k = 0;
        ListNode cur = head;
        while (head!= null){
            cur = cur.next;
            k++;
        }

        k -= n;

        ListNode pred = dummy;
        while (k>0){
           pred = pred.next;
        }

        pred.next = pred.next.next;
        return dummy.next;
    }
}
