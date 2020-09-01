package com.example.algorithm.leetcode.solution;

public class 按奇偶排序数组II {
    public int[] sortArrayByParityII(int[] A) {
        //偶数
        int even = 0;
        //奇数
        int odd = 1;

        while (even < A.length) {
            if ((A[even] & 1) == 1) {
                while (odd < A.length) {
                    if ((A[odd] & 1) == 0) {
                        int temp = A[even];
                        A[even] = A[odd];
                        A[odd] = temp;
                        break;
                    }
                    odd = odd + 2;
                }
            }
            even = even + 2;
        }

        return A;
    }
}
