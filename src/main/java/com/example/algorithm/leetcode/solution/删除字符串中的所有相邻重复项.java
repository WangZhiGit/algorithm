package com.example.algorithm.leetcode.solution;

import java.util.Stack;

public class 删除字符串中的所有相邻重复项 {
    public String removeDuplicates(String S) {
        Stack<Character> stack = new Stack<>();
        for (int i=0; i<S.length(); i++){
            if (!stack.isEmpty() && stack.peek() == S.charAt(i)){
                stack.pop();
            } else {
                stack.push(S.charAt(i));
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()){
            stringBuilder.append(stack.pop());
        }

        return stringBuilder.reverse().toString();
    }
}
