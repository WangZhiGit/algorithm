package com.example.algorithm.leetcode.solution;

import com.example.algorithm.leetcode.entity.TreeNode;

public class 二叉树的最小深度 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        int leftDepth = Integer.MAX_VALUE;
        int rightDepth = Integer.MAX_VALUE;
        if (root.left != null) {
            leftDepth = minDepth(root.left);
        }

        if (root.right != null) {
            rightDepth = minDepth(root.right);
        }

        return Math.min(leftDepth, rightDepth) + 1;
    }
}
