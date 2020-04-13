package com.javalearning.demo.leetcode.linkedlist.twopointer;

import com.javalearning.demo.leetcode.linkedlist.ListNode;

public class removeNthFromEnd {
    public static ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        int length = 0;
        ListNode cur = head;
        while (cur != null){
            cur = cur.next;
            length ++;
        }

        length-=n;
        ListNode pred = dummy;
        while (length>0){
            length--;
            pred = pred.next;
        }

        pred.next = pred.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode ListNode0 = new ListNode(1);
        ListNode ListNode1 = new ListNode(2);
        ListNode ListNode2 = new ListNode(3);
        ListNode ListNode3 = new ListNode(4);

        ListNode0.next = ListNode1;
        ListNode1.next = ListNode2;
        ListNode2.next = ListNode3;
        ListNode3.next = null;

        removeNthFromEnd(ListNode0, 2);
    }
}
