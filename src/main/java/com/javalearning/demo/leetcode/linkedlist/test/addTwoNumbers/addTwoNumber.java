package com.javalearning.demo.leetcode.linkedlist.test.addTwoNumbers;

import com.javalearning.demo.leetcode.linkedlist.ListNode;

public class addTwoNumber {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode rs = new ListNode(0);
        ListNode dummy = rs;

        int carry = 0;
        while (l1 != null || l2!=null){
            int v1 = l1==null?0:l1.val;
            int v2 = l2==null?0:l2.val;
            int sum = v1 + v2 + carry;

            carry = sum / 10;

            dummy.next = new ListNode(sum % 10);
            dummy = dummy.next;

            l1 = l1==null ? null:l1.next;
            l2 = l2==null ? null:l2.next;
        }
        if (carry==1){
            dummy.next = new ListNode(1);
        }
        return rs.next;
    }
}
