package com.example.algorithm.leetcode.solution;

import com.example.algorithm.leetcode.entity.ListNode;

public class 两两交换链表中的节点 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode preNode = dummy;

        while (head != null && head.next != null) {
            ListNode slow = head;
            ListNode fast = head.next;

            preNode.next = fast;
            slow.next = fast.next;
            fast.next = slow;

            preNode = slow;
            head = slow.next;
        }

        return dummy.next;
    }
}
