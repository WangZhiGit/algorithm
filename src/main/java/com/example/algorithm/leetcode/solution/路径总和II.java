package com.example.algorithm.leetcode.solution;

import com.example.algorithm.leetcode.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class 路径总和II {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, sum, result, new ArrayList<>());
        return result;
    }

    private void dfs(TreeNode root, int sum, List<List<Integer>> result, List<Integer> path) {
        if (root == null) {
            return;
        }

        sum -= root.val;
        path.add(root.val);
        if (root.left == null && root.right == null) {
            if (sum == 0) {
                result.add(new ArrayList<>(path));
            }
        } else {
            dfs(root.left, sum, result, path);
            dfs(root.right, sum, result, path);
        }

        path.remove(path.size() - 1);
    }
}
