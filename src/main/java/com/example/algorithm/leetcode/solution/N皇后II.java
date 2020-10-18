package com.example.algorithm.leetcode.solution;

import java.util.HashSet;
import java.util.Set;

public class N皇后II {
    public int totalNQueens(int n) {
        Set<Integer> columns = new HashSet<>();
        Set<Integer> forwardSlashs = new HashSet<>();
        Set<Integer> backSlashs = new HashSet<>();
        return backstrace(n, 0, columns, forwardSlashs, backSlashs);
    }

    private int backstrace(int n, int row, Set<Integer> columns, Set<Integer> forwardSlashs, Set<Integer> backSlashs) {
        if (row == n) {
            return 1;
        } else {
            int count = 0;
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

                columns.add(col);
                forwardSlashs.add(row + col);
                backSlashs.add(row - col);
                count += backstrace(n, row + 1, columns, forwardSlashs, backSlashs);
                columns.remove(col);
                forwardSlashs.remove(row + col);
                backSlashs.remove(row - col);
            }

            return count;
        }
    }
}
