package com.example.algorithm.leetcode.solution;

import com.example.algorithm.leetcode.entity.ListNode;
import com.example.algorithm.leetcode.entity.TreeNode;

public class 有序链表转换二叉搜索树 {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null){
            return null;
        }

        if (head.next == null){
            return new TreeNode(head.val);
        }

        ListNode slowPre = head;
        ListNode slow = head.next;
        ListNode fast = head.next;
        while (fast.next != null && fast.next.next != null){
            slowPre = slowPre.next;
            slow = slow.next;
            fast = fast.next.next;
        }

        slowPre.next = null;
        TreeNode root = new TreeNode(slow.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(slow.next);
        return root;
    }
}
