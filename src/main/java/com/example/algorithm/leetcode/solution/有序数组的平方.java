package com.example.algorithm.leetcode.solution;

public class 有序数组的平方 {
    public int[] sortedSquares(int[] A) {
        int[] result = new int[A.length];
        int start = 0;
        int end = A.length - 1;
        int index = end;
        while (index >= 0) {
            result[index--] = A[start] * A[start] >= A[end] * A[end] ? A[start] * A[start++] : A[end] * A[end--];
        }

        return result;
    }
}
