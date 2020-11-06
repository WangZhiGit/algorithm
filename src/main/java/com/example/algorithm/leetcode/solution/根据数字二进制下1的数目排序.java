package com.example.algorithm.leetcode.solution;

import java.util.Arrays;

public class 根据数字二进制下1的数目排序 {
    public int[] sortByBits(int[] arr) {
        Integer[] nums = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            nums[i] = arr[i];
        }

        Arrays.sort(nums, (o1, o2) -> {
            int o1Bit = Integer.bitCount(o1);
            int o2Bit = Integer.bitCount(o2);
            if (o1Bit != o2Bit) {
                return o1Bit - o2Bit;
            } else {
                return o1 - o2;
            }
        });

        for (int i = 0; i < arr.length; i++) {
            arr[i] = nums[i];
        }

        return arr;
    }
}
