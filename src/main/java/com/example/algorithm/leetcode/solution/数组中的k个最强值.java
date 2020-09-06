package com.example.algorithm.leetcode.solution;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 数组中的k个最强值 {
    public int[] getStrongest(int[] arr, int k) {
        int len = arr.length;
        Arrays.sort(arr);
        int mid = arr[(len - 1) / 2];
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                int a = Math.abs(i1 - mid);
                int b = Math.abs(i2 - mid);
                if (a == b) {
                    return i1 - i2;
                } else {
                    return a - b;
                }
            }
        });

        for (int val : arr) {
            priorityQueue.add(val);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }

        int[] result = new int[k];
        for (int i = 0; i < k; ++i) {
            result[i] = priorityQueue.poll();
        }
        return result;
    }
}
