package com.example.algorithm.leetcode.solution;

public class 颜色分类 {
    //快排：小于1的左边，大于1的右边
    public void sortColors(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int i = 0;
        while (i <= end) {
            if (nums[i] == 0) {
                swap(nums, start++, i++);
            } else if (nums[i] == 2) {
                swap(nums, i, end--);
            } else {
                i++;
            }
        }

    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
