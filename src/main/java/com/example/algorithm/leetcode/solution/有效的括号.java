package com.example.algorithm.leetcode.solution;

import java.util.Stack;

public class 有效的括号 {
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : chars) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.empty() || stack.pop() != '(') {
                    return false;
                }
            } else if (c == ']') {
                if (stack.empty() || stack.pop() != '[') {
                    return false;
                }
            } else if (c == '}') {
                if (stack.empty() || stack.pop() != '{') {
                    return false;
                }
            } else {
                return false;
            }
        }

        return stack.empty();
    }
}
