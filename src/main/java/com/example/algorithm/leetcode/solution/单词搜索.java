package com.example.algorithm.leetcode.solution;

public class 单词搜索 {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (dfs(board, word, row, col, 0, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String word, int row, int col, int index, boolean[][] visited) {
        if (index == word.length()) {
            return true;
        }

        if (row < 0 || row == board.length || col < 0 || col == board[0].length || word.charAt(index) != board[row][col] || visited[row][col]) {
            return false;
        }

        visited[row][col] = true;
        if (dfs(board, word, row, col + 1, index + 1, visited) || dfs(board, word, row, col - 1, index + 1, visited) || dfs(board, word, row + 1, col, index + 1, visited) || dfs(board, word, row - 1, col, index + 1, visited)) {
            return true;
        } else {
            visited[row][col] = false;
            return false;
        }
    }
}
