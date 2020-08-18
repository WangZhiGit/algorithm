package com.example.algorithm.leetcode.solution;

import java.util.Set;
import java.util.TreeSet;

public class 两个数组的交集 {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return null;
        }

        Set<Integer> set = new TreeSet<>();
        for (int nums : nums1) {
            set.add(nums);
        }

        Set<Integer> resultSet = new TreeSet<>();
        for (int nums : nums2) {
            if (set.contains(nums)) {
                resultSet.add(nums);
            }
        }

        int[] results = new int[resultSet.size()];
        int start = 0;
        for (int result : resultSet) {
            results[start++] = result;
        }

        return results;
    }
}
