package com.example.algorithm.leetcode.solution;

public class 有多少小于当前数字的数字 {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] < nums[i]) {
                    count += 1;
                }
            }

            result[i] = count;
        }

        return result;
    }
}
