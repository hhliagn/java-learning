package com.javalearning.demo.leetcode.linkedlist.test;

import com.javalearning.demo.leetcode.linkedlist.ListNode;

public class reverseList {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null, tmp = null;
        ListNode cur =head;
        while ( cur!= null){
            tmp  =cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }
        return prev;
    }
}
