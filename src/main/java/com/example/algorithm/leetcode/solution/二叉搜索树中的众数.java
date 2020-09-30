package com.example.algorithm.leetcode.solution;

import com.example.algorithm.leetcode.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class 二叉搜索树中的众数 {
    int preVal = 0;
    int curTimes = 0;
    int maxTimes = 0;
    List<Integer> list = new ArrayList<>();

    public int[] findMode(TreeNode root) {
        traversal(root);
        int size = list.size();
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = list.get(i);
        }

        return result;
    }

    //二叉搜索树中序遍历是递增顺序
    private void traversal(TreeNode root) {
        if (root == null) {
            return;
        }

        traversal(root.left);
        if (preVal == root.val) {
            curTimes++;
        } else {
            preVal = root.val;
            curTimes = 1;
        }

        if (curTimes > maxTimes) {
            list.clear();
            list.add(root.val);
            maxTimes = curTimes;
        } else if (curTimes == maxTimes) {
            list.add(root.val);
        }

        traversal(root.right);
    }
}
