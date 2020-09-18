package com.example.algorithm.leetcode.solution;

import java.util.Arrays;

public class 冗余连接II {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int[] path = new int[edges.length + 1];
        Arrays.fill(path, -1);
        int path2 = -1;
        for (int i = 0; i < edges.length; i++) {
            if (path[edges[i][1]] != -1) {
                path2 = i;
            } else {
                path[edges[i][1]] = i;
            }
        }

        //边中出现了入度为2的点
        if (path2 != -1) {
            int node = edges[path2][1];
            int firstEdge = path[node];
            int temp = firstEdge;
            while (temp != -1) {
                int index = edges[temp][0];
                temp = path[index];
                if (index == node) {
                    //找到第一条边引发的环
                    return edges[firstEdge];
                }
            }

            //前一条边无环则直接删除后一条边
            return edges[path2];
        }

        //所有点的入度为1，必有环，要删除环中最后输入的边
        boolean[] visited = new boolean[edges.length + 1];
        Arrays.fill(visited, false);
        int index = 1;
        while (!visited[index]) {
            visited[index] = true;
            int firstEdge = path[index];
            index = edges[firstEdge][0];
        }

        int result = path[index];
        int temp = edges[result][0];
        int edgeNum = 0;
        while (temp != index) {
            edgeNum = path[temp];
            result = Math.max(result, edgeNum);
            temp = edges[edgeNum][0];
        }

        return edges[result];
    }
}
