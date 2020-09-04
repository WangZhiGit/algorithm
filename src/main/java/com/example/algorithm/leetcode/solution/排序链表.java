package com.example.algorithm.leetcode.solution;

import com.example.algorithm.leetcode.entity.ListNode;

public class 排序链表 {
    private ListNode temp;

    //在O(nlogn)时间复杂度和常数级空间复杂度下，对链表进行排序。
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode right = sortList(slow.next);
        slow.next = null;
        ListNode left = sortList(head);
        //合并
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        while (left != null && right != null) {
            if (left.val < right.val) {
                temp.next = left;
                left = left.next;
            } else {
                temp.next = right;
                right = right.next;
            }
            temp = temp.next;
        }

        temp.next = left != null ? left : right;
        return dummy.next;
    }
}
