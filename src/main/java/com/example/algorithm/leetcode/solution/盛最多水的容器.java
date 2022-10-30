package com.example.algorithm.leetcode.solution;

public class 盛最多水的容器 {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int sum = 0;

        while (left < right) {
            int tempSum = Math.min(height[left], height[right]) * (right - left);
            sum = Math.max(sum, tempSum);
            if (height[left] < height[right]) {
                left = left + 1;
            } else {
                right = right - 1;
            }
        }
        return sum;
    }
}
