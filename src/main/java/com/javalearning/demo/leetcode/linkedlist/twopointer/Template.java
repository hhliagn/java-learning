package com.javalearning.demo.leetcode.linkedlist.twopointer;

import com.javalearning.demo.leetcode.linkedlist.ListNode;

public class Template {

    /**
     * 提示：
     * 1. 在调用 next 字段之前，始终检查节点是否为空。
     * 获取空节点的下一个节点将导致空指针错误。例如，在我们运行 fast = fast.next.next 之前，需要检查 fast 和 fast.next 不为空。
     * 2. 仔细定义循环的结束条件。
     * 运行几个示例，以确保你的结束条件不会导致无限循环。在定义结束条件时，你必须考虑我们的第一点提示。
     *
     * 分析：
     * 在前面的查找循环示例中，假设我们每次移动较快的指针 2 步，每次移动较慢的指针 1 步。
     *  如果没有循环，快指针需要 N/2 次才能到达链表的末尾，其中 N 是链表的长度。
     *  如果存在循环，则快指针需要 M 次才能赶上慢指针，其中 M 是列表中循环的长度。
     */
    public boolean template(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
