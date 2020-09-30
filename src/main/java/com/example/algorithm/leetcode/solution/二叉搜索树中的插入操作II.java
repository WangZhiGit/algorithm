package com.example.algorithm.leetcode.solution;

import com.example.algorithm.leetcode.entity.TreeNode;

public class 二叉搜索树中的插入操作II {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode current = root;
        while (current != null) {
            if (current.val > val) {
                if (current.left == null) {
                    current.left = new TreeNode(val);
                    return root;
                } else {
                    current = current.left;
                }
            }

            if (current.val < val) {
                if (current.right == null) {
                    current.right = new TreeNode(val);
                    return root;
                } else {
                    current = current.right;
                }
            }
        }

        return new TreeNode(val);
    }
}
