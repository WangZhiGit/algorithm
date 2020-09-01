package com.example.algorithm.leetcode.solution;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class 钥匙和房间 {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        //存储将要参观的房间
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        //存储已经参观过的房间
        Set<Integer> set = new HashSet<>();
        set.add(0);

        while (!stack.isEmpty()) {
            int current = stack.pop();
            for (Integer i : rooms.get(current)) {
                //避免循环
                if (!set.contains(i)) {
                    set.add(i);
                    stack.push(i);
                }

                if (rooms.size() == set.size()) {
                    return true;
                }
            }
        }

        return rooms.size() == set.size();
    }
}
