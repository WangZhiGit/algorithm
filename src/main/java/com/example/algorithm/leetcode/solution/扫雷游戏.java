package com.example.algorithm.leetcode.solution;

public class 扫雷游戏 {
    public char[][] updateBoard(char[][] board, int[] click) {
        return visit(board, click[0], click[1]);
    }

    public static char[][] visit(char[][] board, int x, int y) {
        if (board[x][y] == 'M') {
            board[x][y] = 'X';
            return board;
        }

        int count = 0;
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (i >= 0 && i < board.length && j >= 0 && j < board[0].length) {
                    if (board[i][j] == 'M') {
                        count++;
                    }
                }
            }
        }

        if (count != 0) {
            board[x][y] = Character.forDigit(count, 10);
        } else {
            board[x][y] = 'B';
            for (int i = x - 1; i <= x + 1; i++) {
                for (int j = y - 1; j <= y + 1; j++) {
                    if (i >= 0 && i < board.length && j >= 0 && j < board[0].length) {
                        if (board[i][j] == 'E') {
                            visit(board, i, j);
                        }
                    }
                }
            }
        }

        return board;
    }
}
