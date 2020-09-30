package com.example.algorithm.leetcode.solution;

import com.example.algorithm.leetcode.entity.Node;

import java.util.LinkedList;
import java.util.Queue;

public class 填充每个节点的下一个右侧节点指针II {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (queue.size() > 0) {
            int size = queue.size();
            for (int i = 1; i <= size; i++) {
                Node temp = queue.poll();
                if (i != size) {
                    temp.next = queue.peek();
                }

                if (temp.left != null) {
                    queue.offer(temp.left);
                }

                if (temp.right != null) {
                    queue.offer(temp.right);
                }
            }
        }

        return root;
    }
}
