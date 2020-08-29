package com.example.algorithm.leetcode.solution;

public class 最短回文串 {
    public String shortestPalindrome(String s) {
        StringBuilder sReverse = new StringBuilder(s).reverse();
        String str = s + "#" + sReverse;
        int[] next = next(str);
        String prefix = sReverse.substring(0, sReverse.length() - next[str.length()]);
        return prefix + s;
    }

    //KMP算法
    private int[] next(String P) {
        int[] next = new int[P.length() + 1];
        next[0] = -1;
        int k = -1;
        int i = 1;
        while (i < next.length) {
            if (k == -1 || P.charAt(k) == P.charAt(i - 1)) {
                next[i++] = ++k;
            } else {
                k = next[k];
            }
        }

        return next;
    }
}
