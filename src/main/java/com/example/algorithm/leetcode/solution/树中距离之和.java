package com.example.algorithm.leetcode.solution;

import java.util.*;

public class 树中距离之和 {
    int[] ans;
    int[] count;
    List<Set<Integer>> graph;
    int N;

    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        this.N = N;
        graph = new ArrayList<>();
        ans = new int[N];
        count = new int[N];
        Arrays.fill(count, 1);

        for (int i = 0; i < N; i++) {
            graph.add(new HashSet<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        dfs(0, -1);
        dfs2(0, -1);
        return ans;
    }

    private void dfs(int node, int parent) {
        for (int child : graph.get(node)) {
            if (child != parent) {
                dfs(child, node);
                //count[node]是以node为根的节点个数
                count[node] += count[child];
                //ans[node]是所有结点到node的距离
                ans[node] += ans[child] + count[child];
            }
        }
    }

    private void dfs2(int node, int parent) {
        for (int child : graph.get(node)) {
            if (child != parent) {
                ans[child] = ans[node] - count[child] + N - count[child];
                dfs2(child, node);
            }
        }
    }
}
