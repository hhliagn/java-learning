package com.javalearning.demo.leetcode.linkedlist.test.isPalindrome;

import com.javalearning.demo.leetcode.linkedlist.ListNode;

public class isPalindrome {

    public boolean isPalindrome(ListNode head) {
        if (head== null) return true;
        ListNode firstHalfEnd, secondHalfStart;
        firstHalfEnd = getFirstHalfEnd(head);
        secondHalfStart = firstHalfEnd.next;

        secondHalfStart = reverseList(secondHalfStart);

        ListNode pA = head, pB = secondHalfStart;
        while (pB != null){
            if (pA.val != pB.val) return false;
            pA = pA.next;
            pB = pB.next;
        }

        firstHalfEnd.next = reverseList(secondHalfStart);
        return true;
    }

    private ListNode reverseList(ListNode secondHalfStart) {
        ListNode prev = null, curr = secondHalfStart, temp = null;
        while (curr!= null){
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }


    private ListNode getFirstHalfEnd(ListNode head) {
        ListNode slow = head, fast = head.next;
        while (fast!= null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
