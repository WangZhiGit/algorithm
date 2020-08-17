package com.example.algorithm.leetcode.solution;

import com.example.algorithm.leetcode.entity.ListNode;

public class 删除链表中的节点 {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
