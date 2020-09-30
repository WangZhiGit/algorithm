package com.example.algorithm.leetcode.solution;

import com.example.algorithm.leetcode.entity.TreeNode;

public class 从中序与后序遍历序列构造二叉树 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length == 0 || postorder.length == 0) {
            return null;
        }

        return buildCore(inorder, postorder, postorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode buildCore(int[] inorder, int[] postorder, int postEnd, int inStart, int inEnd) {
        if (inStart > inEnd) {
            return null;
        }

        int rootValue = postorder[postEnd];
        TreeNode root = new TreeNode(rootValue);
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootValue) {
                root.left = buildCore(inorder, postorder, postEnd - (inEnd - i) - 1, inStart, i - 1);
                root.right = buildCore(inorder, postorder, postEnd - 1, i + 1, inEnd);
                return root;
            }
        }

        return null;
    }
}
