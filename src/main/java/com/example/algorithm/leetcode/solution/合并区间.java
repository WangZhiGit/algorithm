package com.example.algorithm.leetcode.solution;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class 合并区间 {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length < 2) {
            return intervals;
        }

        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        LinkedList<int[]> result = new LinkedList<>();
        for (int[] interval : intervals) {
            if (result.isEmpty() || result.peekLast()[1] < interval[0]) {
                result.add(interval);
            } else {
                result.peekLast()[1] = Math.max(result.peekLast()[1], interval[1]);
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}
