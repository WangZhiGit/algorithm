package com.example.algorithm.leetcode.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 两个数组的交集II {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return null;
        }

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> list = new ArrayList<>();
        for (int i = 0, j = 0; i < nums1.length && j < nums2.length; ) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums2[j] < nums1[i]) {
                j++;
            } else {
                list.add(nums1[i]);
                i++;
                j++;
            }
        }

        int[] target = new int[list.size()];
        for (int i = 0; i < target.length; i++) {
            target[i] = list.get(i);
        }

        return target;
    }
}
