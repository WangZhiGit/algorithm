package com.example.algorithm.leetcode.solution;

import com.example.algorithm.leetcode.entity.ListNode;

public class 删除链表的倒数第N个节点 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;

        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        if (fast == null) {
            //处理第一个节点
            return head.next;
        } else {
            // 当fast走到链表末端时，slow正好指向倒数第K个节点的前驱
            while (fast.next != null) {
                fast = fast.next;
                slow = slow.next;
            }

            //处理最后一个节点
            if (slow.next.next == null) {
                slow.next = null;
            } else {
                slow.next = slow.next.next;
            }
        }

        return head;
    }
}
