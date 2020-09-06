package com.example.algorithm.leetcode.solution;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 数组中的k个最强值II {
    public int[] getStrongest(int[] arr, int k) {
        int len = arr.length;
        Arrays.sort(arr);
        int mid = arr[(len - 1) / 2];
        int left = 0;
        int right = len - 1;
        int[] result = new int[k];
        int index = 0;
        while (index < k) {
            if (mid - arr[left] > arr[right] - mid) {
                result[index++] = arr[left++];
            } else {
                result[index++] = arr[right--];
            }
        }

        return result;
    }
}
