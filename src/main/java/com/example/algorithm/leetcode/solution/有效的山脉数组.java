package com.example.algorithm.leetcode.solution;

public class 有效的山脉数组 {
    public boolean validMountainArray(int[] A) {
        int index = 1;
        while (index < A.length && A[index - 1] < A[index]) {
            index++;
        }

        if (index == 1 || index == A.length) {
            return false;
        }

        while (index < A.length && A[index - 1] > A[index]) {
            index++;
        }

        if (index != A.length) {
            return false;
        }

        return true;
    }
}
