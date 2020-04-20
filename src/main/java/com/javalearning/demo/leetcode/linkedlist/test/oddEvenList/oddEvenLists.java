package com.javalearning.demo.leetcode.linkedlist.test.oddEvenList;

import com.javalearning.demo.leetcode.linkedlist.ListNode;

public class oddEvenLists {

    public ListNode oddEvenList(ListNode head) {
        if (head == null) return head;
        ListNode even = head.next;
        ListNode evenHead = even;

        ListNode odd = head;

        while (even!= null && even.next != null){
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }

        odd.next = evenHead;
        return head;
    }
}
