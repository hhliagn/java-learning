package com.javalearning.demo.leetcode.linkedlist.classic.test;

import com.javalearning.demo.leetcode.linkedlist.ListNode;

public class reverseList {
    public static ListNode reverseList(ListNode head) {
        ListNode pre = null , tmp = null;
        ListNode cur = head;
        while (cur!= null){
            tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode ListNode0 = new ListNode(1);
        ListNode ListNode1 = new ListNode(2);
        ListNode ListNode2 = new ListNode(3);
        ListNode ListNode3 = new ListNode(4);
        ListNode ListNode4 = new ListNode(5);

        ListNode0.next = ListNode1;
        ListNode1.next = ListNode2;
        ListNode2.next = ListNode3;
        ListNode3.next = ListNode4;
        ListNode4.next = null;

        ListNode result = reverseList(ListNode0);
        while (result != null){
            System.out.println(result.val);
            result = result.next;
        }
    }
}
