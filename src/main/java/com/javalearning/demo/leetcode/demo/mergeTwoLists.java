package com.javalearning.demo.leetcode.demo;

import com.javalearning.demo.leetcode.linkedlist.ListNode;

public class mergeTwoLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode rs = new ListNode(0);
        ListNode dummy = rs;

        while (l1 != null && l2 != null){
            if (l1.val <= l2.val) {
                dummy.next = l1;
                l1 = l1.next;
            }else {
                dummy.next = l2;
                l2 = l2.next;
            }
            dummy = dummy.next;
        }

        dummy.next = l1 == null ? l2:l1;
        return rs.next;
    }
}
