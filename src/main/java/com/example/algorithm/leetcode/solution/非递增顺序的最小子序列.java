package com.example.algorithm.leetcode.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 非递增顺序的最小子序列 {
    public List<Integer> minSubsequence(int[] nums) {
        List<Integer> result = new ArrayList<>();
        Arrays.sort(nums);

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        int temp = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            temp += nums[i];
            result.add(nums[i]);
            if (temp > sum - temp) {
                break;
            }
        }

        return result;
    }
}
