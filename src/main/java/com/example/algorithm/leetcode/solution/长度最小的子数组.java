package com.example.algorithm.leetcode.solution;

public class 长度最小的子数组 {
    public int minSubArrayLen(int target, int[] nums) {
        int temp = 0;
        int left = 0;
        int right = 0;
        int min_res = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            temp += nums[i];
            right = i;
            while (temp >= target) {
                temp -= nums[left];
                min_res = Math.min(min_res, right - left + 1);
                left++;
            }
        }

        return min_res == Integer.MAX_VALUE ? 0 : min_res;
    }
}
