package com.example.algorithm.leetcode.solution;

import com.example.algorithm.leetcode.entity.ListNode;

public class 回文链表II {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null){
            return true;
        }

        ListNode slow = head;
        ListNode quick = head;
        while (quick.next != null && quick.next.next != null){
            slow = slow.next;
            quick = quick.next.next;
        }

        ListNode reverseHead = reverseList(slow.next);
        while (head != null && reverseHead != null){
            if (head.val != reverseHead.val){
                return false;
            }
            head = head.next;
            reverseHead = reverseHead.next;
        }

        return true;
    }

    public ListNode reverseList(ListNode head){
        if (head == null || head.next ==null){
            return head;
        }

        ListNode result = null;
        ListNode temp;
        while (head != null){
            temp = head.next;
            head.next = result;
            result = head;
            head = temp;
        }

        return result;
    }
}
