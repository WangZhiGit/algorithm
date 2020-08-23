package com.example.algorithm.leetcode.solution;

public class 数字范围按位与 {
    public int rangeBitwiseAnd(int m, int n) {
        if (m == 0 || m == n) {
            return m;
        }

        int result = m;
        for (int i = m + 1; i <= n; i++) {
            result = result & i;
            if (result == 0) {
                break;
            }
            //2147483647 + 1 =-2147483648
            if (i == Integer.MAX_VALUE) {
                break;
            }
        }

        return result;
    }
}
