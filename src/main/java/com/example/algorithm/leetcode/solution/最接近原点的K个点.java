package com.example.algorithm.leetcode.solution;

import java.util.Arrays;
import java.util.Comparator;

public class 最接近原点的K个点 {
    public int[][] kClosest(int[][] points, int K) {
        Arrays.sort(points, Comparator.comparing(p -> p[0] * p[0] + p[1] * p[1]));
        return Arrays.copyOfRange(points, 0, K);
    }
}
