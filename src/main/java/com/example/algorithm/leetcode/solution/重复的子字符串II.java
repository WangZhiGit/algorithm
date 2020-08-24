package com.example.algorithm.leetcode.solution;

public class 重复的子字符串II {
    public boolean repeatedSubstringPattern(String s) {
        if (s.length() == 1) {
            return false;
        }

        for (int i = 1; i <= s.length() / 2; i++) {
            if (s.length() % i == 0) {
                String temp = s.substring(0, i);
                if (s.split(temp).length == 0) {
                    return true;
                }
            }
        }

        return false;
    }
}
