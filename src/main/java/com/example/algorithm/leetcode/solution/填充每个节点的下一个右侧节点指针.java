package com.example.algorithm.leetcode.solution;

import com.example.algorithm.leetcode.entity.Node;

import java.util.LinkedList;
import java.util.Queue;

public class 填充每个节点的下一个右侧节点指针 {
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Node current = null;
            while (size > 0) {
                Node node = queue.poll();
                if (node.right != null) {
                    queue.add(node.right);
                }

                if (node.left != null) {
                    queue.add(node.left);
                }

                node.next = current;
                current = node;
                size--;
            }
        }

        return root;
    }
}
