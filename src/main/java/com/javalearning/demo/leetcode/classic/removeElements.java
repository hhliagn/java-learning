package com.javalearning.demo.leetcode.classic;

import com.javalearning.demo.leetcode.linkedlist.ListNode;

public class removeElements {

    public static ListNode removeElements(ListNode head, int val) {
        ListNode cur = head;
        while (cur!=null && cur.next!= null){
            if (cur.next.val == val){
                ListNode next1 = cur.next.next;
                cur.next = next1;
                cur = next1;
            }else {
                cur = cur.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {

    }
}
