package com.example.algorithm.leetcode.solution;

public class 重复的子字符串 {
    public boolean repeatedSubstringPattern(String s) {
        return (s + s).indexOf(s, 1) != s.length();
    }
}
