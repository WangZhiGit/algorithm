package com.example.algorithm.leetcode.solution;

import java.util.Stack;

public class 删除字符串中的所有相邻重复项II {
    public String removeDuplicates(String s, int k) {
        if (s == null || s.length() < k) {
            return s;
        }

        //重复元素
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while (index < s.length()) {
            char c = s.charAt(index++);
            sb.append(c);
            if (stack.isEmpty() || stack.peek() == c) {
                stack.push(c);
            } else {
                stack.clear();
                stack.push(c);
            }

            if (stack.size() == k) {
                stack.clear();
                sb.delete(sb.length() - k, sb.length());
            }
        }

        String temp = sb.toString();
        //跳出递归的条件：未删除元素
        if (temp.equals(s)) {
            return temp;
        } else {
            return removeDuplicates(temp, k);
        }
    }
}
