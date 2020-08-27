package com.example.algorithm.leetcode.solution;

import java.util.*;

public class 前K个高频元素 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue = new PriorityQueue<>(k, Comparator.comparingInt(entry -> entry.getValue()));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            priorityQueue.add(entry);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = priorityQueue.poll().getKey();
        }

        return result;
    }
}
