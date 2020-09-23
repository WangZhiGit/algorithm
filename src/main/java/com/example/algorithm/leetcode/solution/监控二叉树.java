package com.example.algorithm.leetcode.solution;

import com.example.algorithm.leetcode.entity.TreeNode;

public class 监控二叉树 {
    int result = 0;

    public int minCameraCover(TreeNode root) {
        if (dfs(root) == 0) {
            result++;
        }

        return result;
    }

    /*
    0 该节点没有被覆盖
    1 该节点上装有监控
    2 该节点已被覆盖
     */
    private int dfs(TreeNode root) {
        if (root == null) {
            return 2;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);

        //左右孩子其中有1个未被覆盖，那么父节点装监控
        if (left == 0 || right == 0) {
            result++;
            return 1;
        }

        //左右孩子都被覆盖，那么父节点未被覆盖
        if (left == 2 && right == 2) {
            return 0;
        }

        //左右孩子其中有1个装了监控，那么父节点是已被覆盖
        if (left == 1 || right == 1) {
            return 2;
        }

        return -1;
    }
}
