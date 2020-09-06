package com.example.algorithm.leetcode.solution;

import com.example.algorithm.leetcode.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class 二叉树的所有路径 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        solve(root, "", result);
        return result;
    }

    private void solve(TreeNode root, String current, List<String> result) {
        if (root == null) {
            return;
        }

        current = current + root.val;
        if (root.left == null && root.right == null) {
            result.add(current);
        } else {
            solve(root.left, current + "->", result);
            solve(root.right, current + "->", result);
        }
    }
}
