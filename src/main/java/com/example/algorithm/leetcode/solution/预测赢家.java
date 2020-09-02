package com.example.algorithm.leetcode.solution;

public class 预测赢家 {
    public boolean PredictTheWinner(int[] nums) {
        return total(nums, 0, nums.length - 1) >= 0;
    }

    //先手turn为正，后手turn为负
    public int total(int[] nums, int start, int end) {
        if (start == end) {
            return nums[start];
        }

        int scoreStart = nums[start] - total(nums, start + 1, end);
        int scoreEnd = nums[end] - total(nums, start, end - 1);
        return Math.max(scoreStart, scoreEnd);
    }
}
