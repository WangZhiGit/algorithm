package com.example.algorithm.leetcode.solution;

import com.example.algorithm.leetcode.entity.TreeNode;

public class 翻转二叉树 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
