package com.example.algorithm.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

public class 组合总和 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        dfs(candidates, target, result, new ArrayList<>(), 0);
        return result;
    }

    private void dfs(int[] candidates, int target, List<List<Integer>> result, List<Integer> combine, int index) {
        if (target == 0) {
            result.add(new ArrayList<>(combine));
        } else if (target > 0) {
            for (int i = index; i < candidates.length; i++) {
                combine.add(candidates[i]);
                dfs(candidates, target - candidates[i], result, combine, i);
                combine.remove(combine.size() - 1);
            }
        }
    }
}
