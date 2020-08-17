package com.example.algorithm.leetcode.solution;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class 合并区间 {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length < 2){
            return intervals;
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        LinkedList<int[]> result = new LinkedList<>();
        for (int i=0; i< intervals.length; i++){
            if (result.isEmpty() || result.peekLast()[1] < intervals[i][0]){
                result.add(intervals[i]);
            }else {
                result.peekLast()[1] = Math.max(result.peekLast()[1], intervals[i][1]);
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}
