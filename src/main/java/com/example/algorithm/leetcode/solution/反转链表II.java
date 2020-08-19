package com.example.algorithm.leetcode.solution;

import com.example.algorithm.leetcode.entity.ListNode;

public class 反转链表II {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode temp = head.next;
        ListNode result = reverseList(head.next);
        temp.next = head;
        head.next = null;
        return result;
    }
}
