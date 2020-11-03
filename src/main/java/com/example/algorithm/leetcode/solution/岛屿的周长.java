package com.example.algorithm.leetcode.solution;

public class 岛屿的周长 {
    public int islandPerimeter(int[][] grid) {
        int num = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    num = num + 4;
                    if (i > 0 && grid[i - 1][j] == 1) {
                        num = num - 2;
                    }

                    if (j > 0 && grid[i][j - 1] == 1) {
                        num = num - 2;
                    }
                }
            }
        }

        return num;
    }
}
