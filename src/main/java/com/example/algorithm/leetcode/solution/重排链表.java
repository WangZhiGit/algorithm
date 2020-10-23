package com.example.algorithm.leetcode.solution;

import com.example.algorithm.leetcode.entity.ListNode;

public class 重排链表 {
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode reverseNode = reverseList(slow.next);
        slow.next = null;
        ListNode dummy = new ListNode(0);
        while (reverseNode != null) {
            ListNode temp = head.next;
            head.next = reverseNode;
            reverseNode = reverseNode.next;
            if (temp == null) {
                break;
            }

            head.next.next = temp;
            head = temp;
        }

        head = dummy.next;
    }

    public ListNode reverseList(ListNode head) {
        ListNode result = null;
        ListNode temp;
        while (head != null) {
            temp = head.next;
            head.next = result;
            result = head;
            head = temp;
        }

        return result;
    }
}
