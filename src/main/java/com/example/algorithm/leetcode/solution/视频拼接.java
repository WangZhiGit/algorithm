package com.example.algorithm.leetcode.solution;

public class 视频拼接 {
    public int videoStitching(int[][] clips, int T) {
        //左端点相同时，右端点越远越好
        int[] maxRight = new int[T];
        for (int[] clip : clips) {
            if (clip[0] < T) {
                maxRight[clip[0]] = Math.max(maxRight[clip[0]], clip[1]);
            }
        }

        int pre = 0;
        int last = 0;
        int result = 0;
        for (int i = 0; i < T; i++) {
            last = Math.max(last, maxRight[i]);
            //如果更新后last==i，那么说明下一个位置无法被覆盖，我们无法完成目标。
            if (last == i) {
                return -1;
            }

            //我们用完了一个被使用的子区间，这种情况下我们让result+1，并更新pre即可。
            if (pre == i) {
                result++;
                pre = last;
            }
        }

        return result;
    }
}
