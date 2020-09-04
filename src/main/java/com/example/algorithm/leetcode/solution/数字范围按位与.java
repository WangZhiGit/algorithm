package com.example.algorithm.leetcode.solution;

public class 数字范围按位与 {
    //给定范围[m, n]，其中0<=m<=n<=2147483647，返回此范围内所有数字的按位与（包含m, n两端点）。
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
