package com.example.algorithm.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

public class 第k个排列 {
    public String getPermutation(int n, int k) {
        List<Integer> candidates = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            candidates.add(i);
        }

        StringBuilder result = new StringBuilder();
        k--;
        while (n > 0) {
            int factorials = 1;
            for (int i = 1; i < n; i++) {
                factorials *= i;
            }

            int index = k / factorials;
            result.append(candidates.get(index));
            candidates.remove(index);
            k = k % factorials;
            n--;
        }

        return result.toString();
    }
}
