package com.example.algorithm.leetcode.solution;

import java.util.Arrays;

public class 满足条件的子序列数目 {
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int mod = 1000000007;
        //提前算出2的n次幂，避免超出int界限
        int[] pow = new int[nums.length];
        pow[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            pow[i] = pow[i - 1] * 2;
            pow[i] %= mod;
        }

        int result = 0;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            if (nums[left] + nums[right] <= target) {
                result = (result + pow[right - left]) % mod;
                left++;
            } else {
                right--;
            }
        }

        return result;
    }
}
