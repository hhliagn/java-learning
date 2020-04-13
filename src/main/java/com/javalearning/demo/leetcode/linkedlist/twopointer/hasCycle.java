package com.javalearning.demo.leetcode.linkedlist.twopointer;

import com.javalearning.demo.leetcode.linkedlist.ListNode;

public class hasCycle {

    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null){
            return false;
        }
        ListNode slow = head, fast = head.next;
        while (slow != fast){

            if (fast == null || fast.next == null) return false;

            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode ListNode0 = new ListNode(3);
        ListNode ListNode1 = new ListNode(2);
        ListNode ListNode2 = new ListNode(0);
        ListNode ListNode3 = new ListNode(-4);

        ListNode0.next = ListNode1;
        ListNode1.next = ListNode2;
        ListNode2.next = ListNode3;
        ListNode3.next = ListNode1;

        boolean b = hasCycle(ListNode0);
        System.out.println(b);
    }
}
