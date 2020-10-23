package com.example.algorithm.leetcode.solution;

import java.util.Stack;

public class 比较含退格的字符串 {
    public boolean backspaceCompare(String S, String T) {
        return build(S).equals(build(T));
    }

    private String build(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c != '#') {
                stack.push(c);
            } else {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
        }

        return String.valueOf(stack);
    }
}
