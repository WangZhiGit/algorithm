package com.example.algorithm.leetcode.solution;

import java.util.Deque;
import java.util.LinkedList;

public class 滑动窗口最大值 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length + 1 - k];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            //当前元素大于队尾元素，删除队尾元素
            while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()]) {
                deque.removeLast();
            }

            deque.addLast(i);

            if (!deque.isEmpty() && deque.peekFirst() == i - k) {
                deque.removeFirst();
            }

            if (i + 1 - k >= 0) {
                result[i + 1 - k] = nums[deque.peekFirst()];
            }
        }

        return result;
    }
}
