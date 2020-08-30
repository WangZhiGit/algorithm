package com.example.algorithm.leetcode.solution;

public class 反转字符串中的单词III {
    public String reverseWords(String s) {
        StringBuilder result = new StringBuilder();
        String[] strs = s.split(" ");
        for (String str : strs) {
            result.append(new StringBuilder(str).reverse()).append(" ");
        }

        return result.toString().trim();
    }
}
