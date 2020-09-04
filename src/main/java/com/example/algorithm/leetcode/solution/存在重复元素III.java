package com.example.algorithm.leetcode.solution;

import java.util.TreeSet;

public class 存在重复元素III {
    /**
     * @param nums 整数数组nums
     * @param k nums[i]和nums[j]的差的绝对值小于等于 t
     * @param t i和j的差的绝对值小于等于ķ
     * @return 在整数数组nums中，是否存在两个下标i和j，使得nums[i]和nums[j]的差的绝对值小于等于t，且满足i和j的差的绝对值也小于等于ķ。
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            //返回集合中大于或者等于给定元素的最小元素
            Integer s = set.ceiling(nums[i]);
            if (s != null && s <= nums[i] + t){
                return true;
            }

            //返回集合中小于或者等于给定元素的最大元素
            Integer g = set.floor(nums[i]);
            if (g != null && nums[i] <= g + t){
                return true;
            }

            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }

        return false;
    }
}
