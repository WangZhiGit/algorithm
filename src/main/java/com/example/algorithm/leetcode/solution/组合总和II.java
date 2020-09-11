package com.example.algorithm.leetcode.solution;

import java.util.*;

public class 组合总和II {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(candidates);
        dfs(candidates, target, result, new ArrayList<>(), 0);
        return new ArrayList<>(result);
    }

    private void dfs(int[] candidates, int target, Set<List<Integer>> result, List<Integer> combine, int index) {
        if (target == 0) {
            result.add(new ArrayList<>(combine));
        } else if (target > 0) {
            for (int i = index; i < candidates.length; i++) {
                combine.add(candidates[i]);
                dfs(candidates, target - candidates[i], result, combine, i + 1);
                combine.remove(combine.size() - 1);
            }
        }
    }
}
