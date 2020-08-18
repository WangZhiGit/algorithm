package com.example.algorithm.leetcode.solution;

import com.example.algorithm.leetcode.entity.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class 二叉树的后序遍历II {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if (root == null){
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode temp = stack.pop();
            if (temp.left != null){
                stack.push(temp.left);
            }

            if (temp.right != null){
                stack.push(temp.right);
            }

            //逆序添加节点
            result.add(0, temp.val);
        }

        return result;
    }
}
