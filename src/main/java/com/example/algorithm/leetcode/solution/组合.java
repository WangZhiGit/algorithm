package com.example.algorithm.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

public class 组合 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, new ArrayList<>(), n, k, 1);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> temp, int n, int k, int index) {
        if (k == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = index; i <= n; i++) {
            temp.add(i);
            dfs(result, temp, n, k - 1, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}
