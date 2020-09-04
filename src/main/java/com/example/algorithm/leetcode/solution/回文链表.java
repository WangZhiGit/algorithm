package com.example.algorithm.leetcode.solution;

import com.example.algorithm.leetcode.entity.ListNode;

import java.util.ArrayList;
import java.util.List;

public class 回文链表 {
    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();

        ListNode currentNode = head;
        //链表转换成列表，从头和尾依次对比
        while (currentNode != null) {
            list.add(currentNode.val);
            currentNode = currentNode.next;
        }

        int front = 0;
        int back = list.size() - 1;
        while (front < back) {
            if (!list.get(front).equals(list.get(back))) {
                return false;
            }

            front++;
            back--;
        }

        return true;
    }
}
