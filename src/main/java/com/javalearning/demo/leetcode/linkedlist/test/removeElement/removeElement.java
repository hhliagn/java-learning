package com.javalearning.demo.leetcode.linkedlist.test.removeElement;

import com.javalearning.demo.leetcode.linkedlist.ListNode;

public class removeElement {

    public ListNode removeElements(ListNode head, int val) {
        ListNode curr = head;
        while (curr!= null && curr.next != null){
            if (curr.val == val){
                ListNode nextnext = curr.next.next;
                curr.next = nextnext;
                curr = nextnext;
            }else {
                curr = curr.next;
            }
        }
        return head;
    }
}
