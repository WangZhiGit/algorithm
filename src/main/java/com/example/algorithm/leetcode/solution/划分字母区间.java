package com.example.algorithm.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

public class 划分字母区间 {
    public List<Integer> partitionLabels(String S) {
        //记录每个字母出现位置的最大值
        int[] ans = new int[26];
        for (int i = 0; i < S.length(); i++) {
            ans[S.charAt(i) - 'a'] = i;
        }

        int j = 0;
        //记录每一区间的首字母位置
        int start = 0;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < S.length(); i++) {
            j = Math.max(j, ans[S.charAt(i) - 'a']);
            if (i == j) {
                result.add(j + 1 - start);
                start = i + 1;
            }
        }

        return result;
    }
}
