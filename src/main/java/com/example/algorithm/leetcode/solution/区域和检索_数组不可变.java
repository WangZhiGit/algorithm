package com.example.algorithm.leetcode.solution;

public class 区域和检索_数组不可变 {
    private int[] preSum;

    public 区域和检索_数组不可变(int[] nums) {
        final int N = nums.length;
        preSum = new int[N + 1];

        for (int i = 0; i < N; ++i) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        return preSum[right + 1] - preSum[left];
    }
}
