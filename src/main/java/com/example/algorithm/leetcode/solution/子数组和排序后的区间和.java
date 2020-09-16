package com.example.algorithm.leetcode.solution;

import java.util.Arrays;

public class 子数组和排序后的区间和 {
    public int rangeSum(int[] nums, int n, int left, int right) {
        int sumsLength = n * (n + 1) / 2;
        int modulo = 1000000007;
        int[] sums = new int[sumsLength];
        int index = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                sums[index++] = sum;
            }
        }

        Arrays.sort(sums);
        int result = 0;
        for (int i = left - 1; i < right; i++) {
            result = (result + sums[i]) % modulo;
        }
        return result;
    }
}
