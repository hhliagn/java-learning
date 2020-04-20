package com.javalearning.demo.leetcode.linkedlist.classic.test;

import com.javalearning.demo.leetcode.linkedlist.ListNode;

public class removeElements {

    public static ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pred = dummy, cur = head;
        while (cur!= null){
            if (cur.val == val){
                pred.next = cur.next;
            }else {
                pred = cur;
            }
            cur = cur.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode node0 = new ListNode(1);
        ListNode node1 = new ListNode(1);

        node0.next = node1;

        removeElements(node0,1);
    }
}
