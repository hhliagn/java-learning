package com.javalearning.demo.leetcode.classic;

import com.javalearning.demo.leetcode.linkedlist.ListNode;

public class oddEvenList {

    public ListNode oddEvenList(ListNode head) {
        if(head == null) return head;
        ListNode odd = head, evenHead = head.next, even = evenHead;
        while (even != null && even.next != null){
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
