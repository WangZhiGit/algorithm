package com.example.algorithm.leetcode.solution;

import java.util.*;

public class 递增子序列 {
    //给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是2
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        findSubsequences(result, nums, 0, new LinkedList<>());
        return new LinkedList<>(result);
    }

    public void findSubsequences(Set<List<Integer>> result, int[] nums, int startIndex, LinkedList<Integer> subSequence) {
        if (subSequence.size() >= 2) {
            result.add(new LinkedList<>(subSequence));
        }

        for (int i = startIndex; i < nums.length; i++) {
            if (subSequence.size() == 0 || subSequence.peekLast() <= nums[i]) {
                subSequence.add(nums[i]);
                findSubsequences(result, nums, i + 1, subSequence);
                subSequence.removeLast();
            }
        }
    }
}
