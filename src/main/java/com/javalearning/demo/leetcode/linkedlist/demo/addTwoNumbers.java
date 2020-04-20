package com.javalearning.demo.leetcode.linkedlist.demo;

import com.javalearning.demo.leetcode.linkedlist.ListNode;

public class addTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummy = new ListNode(0);
        ListNode rs  = dummy;
        while (l1!= null || l2!= null){
            int i1 = l1 != null ? l1.val:0;
            int i2 = l2 != null ? l2.val:0;
            int sum = i1+i2+carry;
            carry = sum/10;
            dummy.next = new ListNode(sum % 10);
            dummy = dummy.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry>0){
            dummy.next = new ListNode(carry);
        }
        return rs.next;
    }
}
