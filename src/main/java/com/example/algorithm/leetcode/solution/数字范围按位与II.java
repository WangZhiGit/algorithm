package com.example.algorithm.leetcode.solution;

public class 数字范围按位与II {
    public int rangeBitwiseAnd(int m, int n) {
        //公共前缀
        while (m < n) {
            n = n & (n - 1);
        }

        return n;
    }
}
