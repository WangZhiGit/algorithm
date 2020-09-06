package com.example.algorithm.leetcode.solution;

import java.util.*;

public class N皇后 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        //queens[i]的值为列数，i为行数
        int[] queens = new int[n];
        Set<Integer> columns = new HashSet<>();
        Set<Integer> forwardSlashs = new HashSet<>();
        Set<Integer> backSlashs = new HashSet<>();
        backstrace(result, queens, n, 0, columns, forwardSlashs, backSlashs);
        return result;
    }

    private void backstrace(List<List<String>> result, int[] queens, int n, int row, Set<Integer> columns, Set<Integer> forwardSlashs, Set<Integer> backSlashs) {
        if (row == n) {
            List<String> board = generateBoard(queens, n);
            result.add(board);
        } else {
            //遍历列
            for (int col = 0; col < n; col++) {
                if (columns.contains(col)) {
                    continue;
                }

                if (forwardSlashs.contains(row + col)) {
                    continue;
                }

                if (backSlashs.contains(row - col)) {
                    continue;
                }

                queens[row] = col;
                columns.add(col);
                forwardSlashs.add(row + col);
                backSlashs.add(row - col);
                backstrace(result, queens, n, row + 1, columns, forwardSlashs, backSlashs);
                columns.remove(col);
                forwardSlashs.remove(row + col);
                backSlashs.remove(row - col);
            }
        }
    }

    private List<String> generateBoard(int[] queens, int n) {
        List<String> board = new ArrayList<>();
        //遍历行
        for (int row = 0; row < n; row++) {
            StringBuilder sb = new StringBuilder();
            //遍历列
            for (int col = 0; col < n; col++) {
                if (queens[row] == col) {
                    sb.append("Q");
                } else {
                    sb.append(".");
                }
            }

            board.add(sb.toString());
        }

        return board;
    }
}
