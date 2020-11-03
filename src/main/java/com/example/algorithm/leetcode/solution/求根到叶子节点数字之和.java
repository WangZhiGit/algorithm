package com.example.algorithm.leetcode.solution;

import com.example.algorithm.leetcode.entity.TreeNode;

public class 求根到叶子节点数字之和 {
    private int sum = 0;

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }

        dfs(root, 0);
        return sum;
    }

    private void dfs(TreeNode root, int curSum) {
        curSum = curSum * 10 + root.val;
        if (root.left != null) {
            dfs(root.left, curSum);
        }

        if (root.right != null) {
            dfs(root.right, curSum);
        }

        if (root.left == null && root.right == null) {
            sum += curSum;
        }
    }
}
