package com.javalearning.demo.leetcode.linkedlist.twopointer;

import com.javalearning.demo.leetcode.linkedlist.ListNode;

public class detectCycle {
    //链表尾的元素到下一个元素的距离是1，从head到入环点的元素也是1
    public static ListNode detectCycle(ListNode head) {
        ListNode insert = getInsert(head);
        System.out.println(insert.val);
        if (insert!= null){
            ListNode tmp1 = head;
            ListNode tmp2 = insert;
            while ( tmp1 != tmp2){
                tmp1 = tmp1.next;
                tmp2 = tmp2.next;
            }
            return tmp1;
        }else {
            return null;
        }
    }

    //重点：找到链表尾的元素
    private static ListNode getInsert(ListNode head) {

        ListNode tortoise = head;
        ListNode hare = head;

        while (hare != null && hare.next != null) {
            tortoise = tortoise.next;
            hare = hare.next.next;
            if (tortoise == hare) {
                return tortoise;
            }
        }
        return null;

        //不能用下面检测环的方法，因为拿到的不是队尾的元素，也就无法正确得到入环点
//        ListNode slow = head, fast = head.next;
//        while (slow != fast){
//            if (fast == null || fast.next == null) return null;
//            slow = slow.next;
//            fast = fast.next.next;
//        }
//        return slow;
    }

    public static void main(String[] args) {
        ListNode ListNode0 = new ListNode(3);
        ListNode ListNode1 = new ListNode(2);
        ListNode ListNode2 = new ListNode(0);
        ListNode ListNode3 = new ListNode(-4);
        ListNode ListNode4 = new ListNode(8);

        ListNode0.next = ListNode1;
        ListNode1.next = ListNode2;
        ListNode2.next = ListNode3;
        ListNode3.next = ListNode4;
        ListNode4.next = ListNode1;

        detectCycle(ListNode0);
    }
}
