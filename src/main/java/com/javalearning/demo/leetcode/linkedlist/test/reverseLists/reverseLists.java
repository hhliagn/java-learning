package com.javalearning.demo.leetcode.linkedlist.test.reverseLists;

import com.javalearning.demo.leetcode.linkedlist.ListNode;

public class reverseLists {

    public ListNode reverseList(ListNode head) {
        ListNode prev = null,temp = null;
        ListNode curr = head;
        while (curr!= null){

            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }
}
