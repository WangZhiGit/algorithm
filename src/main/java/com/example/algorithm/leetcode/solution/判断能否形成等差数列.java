package com.example.algorithm.leetcode.solution;

import java.util.Arrays;

public class 判断能否形成等差数列 {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i] * 2 != arr[i - 1] + arr[i + 1]) {
                return false;
            }
        }

        return true;
    }
}
