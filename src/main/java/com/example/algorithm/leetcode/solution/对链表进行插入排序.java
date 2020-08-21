package com.example.algorithm.leetcode.solution;

import com.example.algorithm.leetcode.entity.ListNode;

public class 对链表进行插入排序 {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        //哑结点：便于比较和交换
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        //指向已排序的最后一个节点
        ListNode preCurrent = head;
        //指向未排序的第一个节点
        ListNode current = head.next;
        while (current != null) {
            if (current.val < preCurrent.val) {
                //每次从已排序的第一个节点比较
                ListNode start = dummy;
                while (start.next.val < current.val) {
                    start = start.next;
                }

                ListNode temp = start.next;
                start.next = current;
                preCurrent.next = current.next;
                current.next = temp;
            } else {
                preCurrent = current;
            }

            current = preCurrent.next;
        }

        return dummy.next;
    }
}
