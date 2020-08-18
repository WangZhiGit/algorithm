package com.example.algorithm.leetcode.solution;

import java.util.Stack;

public class 删除字符串中的所有相邻重复项III {
    public String removeDuplicates(String s, int k) {
        if (s == null || s.length() < k) {
            return s;
        }

        //重复元素的个数
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < sb.length(); i++) {
            if (i == 0 || sb.charAt(i) != sb.charAt(i - 1)) {
                stack.push(1);
            } else {
                int incremented = stack.pop() + 1;
                if (incremented == k) {
                    sb.delete(i - k + 1, i + 1);
                    i = i - k;
                } else {
                    stack.push(incremented);
                }
            }
        }

        return sb.toString();
    }
}
