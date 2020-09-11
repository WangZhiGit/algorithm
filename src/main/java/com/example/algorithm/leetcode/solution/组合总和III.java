package com.example.algorithm.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

public class 组合总和III {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(k, n, result, new ArrayList<>(), 1);
        return result;
    }

    private void dfs(int k, int n, List<List<Integer>> result, List<Integer> combine, int index) {
        if (n == 0 && k == 0) {
            result.add(new ArrayList<>(combine));
        }

        if (n < 0) {
            return;
        }

        for (int i = index; i <= 9; i++) {
            combine.add(i);
            dfs(k - 1, n - i, result, combine, i + 1);
            combine.remove(combine.size() - 1);
        }
    }
}
