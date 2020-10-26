package com.example.algorithm.leetcode.solution;

public class 数组中的最长山脉 {
    public int longestMountain(int[] A) {
        int len = A.length;
        //少于3个不能组成山脉
        if (len < 3) {
            return 0;
        }

        int maxLen = 0;
        //山脉需要两边都小于高点，所以从1开始，到倒数第二个结束
        for (int i = 1; i < len - 1; i++) {
            //如果任一边一开始就大于等于高点，进入下个循环
            if (A[i - 1] >= A[i] || A[i + 1] >= A[i]) {
                continue;
            }

            int leftLen = 0;
            int leftIndex = i - 1;
            while (leftIndex >= 0 && A[leftIndex] < A[leftIndex + 1]) {
                leftLen++;
                leftIndex--;
            }

            int rightLen = 0;
            int rightIndex = i + 1;
            while (rightIndex < len && A[rightIndex] < A[rightIndex - 1]) {
                rightLen++;
                rightIndex++;
            }

            maxLen = Math.max(maxLen, leftLen + rightLen + 1);
        }

        return maxLen;
    }
}
