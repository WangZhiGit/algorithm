package com.example.algorithm.leetcode.solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 移除无效的括号 {
    public String minRemoveToMakeValid(String s) {
        List<Integer> removeIndexList = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                if (stack.isEmpty()) {
                    removeIndexList.add(i);
                } else {
                    stack.pop();
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (removeIndexList.contains(i) || stack.contains(i)) {
                continue;
            }
            sb.append(s.charAt(i));
        }

        return sb.toString();
    }
}
