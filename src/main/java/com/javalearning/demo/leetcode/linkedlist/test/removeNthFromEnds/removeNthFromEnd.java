package com.javalearning.demo.leetcode.linkedlist.test.removeNthFromEnds;

import com.javalearning.demo.leetcode.linkedlist.ListNode;

public class removeNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        ListNode rs= dummy;
        dummy.next = head;

        ListNode curr = head;
        int length =0;
        while (curr!= null){
            curr = curr.next;
            length++;
        }

        length -= n;

        ListNode prev = dummy;
        while (length > 0){
            prev = prev.next;
            length --;
        }

        prev.next = prev.next.next;
        return rs.next;
    }


}
