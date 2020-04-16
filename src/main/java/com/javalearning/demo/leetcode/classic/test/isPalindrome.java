package com.javalearning.demo.leetcode.classic.test;

import com.javalearning.demo.leetcode.linkedlist.ListNode;

import java.util.ArrayList;
import java.util.List;

public class isPalindrome {

    public boolean isPalindrome(ListNode head) {
        List<Integer> vals = new ArrayList<>();

        // Convert LinkedList into ArrayList.
        ListNode currentNode = head;
        while (currentNode != null) {
            vals.add(currentNode.val);
            currentNode = currentNode.next;
        }

        // Use two-pointer technique to check for palindrome.
        int front = 0;
        int back = vals.size() - 1;
        while (front < back) {
            // Note that we must use ! .equals instead of !=
            // because we are comparing Integer, not int.
            if (!vals.get(front).equals(vals.get(back))) {
                return false;
            }
            front++;
            back--;
        }
        return true;
    }


    public boolean isPalindrome2(ListNode head) {
        if (head == null) return true;

        //快慢指针获取中间的结点
        ListNode firstHalfEnd = endOfHalf(head);
        ListNode secondHalfStart = reverseList(firstHalfEnd.next);

        ListNode p1 = head;
        ListNode p2 = secondHalfStart;
        boolean result = true;
        while (result && p2!= null){
            if (p1.val != p2.val) return false;
            p1 = p1.next;
            p2 = p2.next;
        }

        //恢复链表
        firstHalfEnd.next  = reverseList(secondHalfStart);

        return result;
    }

    public ListNode reverseList(ListNode head){
        ListNode prev = null, tmp = null, cur = head;
        while (cur != null){
            tmp  = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }
        return prev;
    }

    private ListNode endOfHalf(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }


}
