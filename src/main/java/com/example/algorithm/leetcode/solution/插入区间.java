package com.example.algorithm.leetcode.solution;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class 插入区间 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int len = intervals.length;
        int newStart = newInterval[0];
        int newEnd = newInterval[1];
        LinkedList<int[]> output = new LinkedList<int[]>();

        int index = 0;
        while (index < len && newStart > intervals[index][0]) {
            output.add(intervals[index++]);
        }

        int[] interval = new int[2];
        if (output.isEmpty() || output.getLast()[1] < newStart) {
            output.add(newInterval);
        } else {
            interval = output.removeLast();
            interval[1] = Math.max(interval[1], newEnd);
            output.add(interval);
        }

        while (index < len) {
            interval = intervals[index++];
            int start = interval[0];
            int end = interval[1];
            if (output.getLast()[1] < start) {
                output.add(interval);
            } else {
                interval = output.removeLast();
                interval[1] = Math.max(interval[1], end);
                output.add(interval);
            }
        }

        return output.toArray(new int[output.size()][2]);
    }
}
