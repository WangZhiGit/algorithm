package com.example.algorithm.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

public class 二十四点游戏 {
    private static final int TRACE = 24;
    private static final double EPSILON = 1e-6;
    private static final int ADD = 0;
    private static final int MULTIPLY = 1;
    private static final int SUBTRACT = 2;
    private static final int DIVIDE = 3;

    public boolean judgePoint24(int[] nums) {
        List<Double> list = new ArrayList<>();
        for (int num : nums) {
            list.add((double) num);
        }

        return solve(list);
    }

    public static boolean solve(List<Double> list) {
        if (list.size() == 0) {
            return false;
        }

        if (list.size() == 1) {
            return Math.abs(list.get(0) - TRACE) < EPSILON;
        }

        int size = list.size();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i != j) {
                    List<Double> temp = new ArrayList<>();
                    for (int m = 0; m < size; m++) {
                        if (m != i && m != j) {
                            temp.add(list.get(m));
                        }
                    }

                    //遍历运算符
                    for (int n = 0; n < 4; n++) {
                        if (n < 2 && i > j) {
                            continue;
                        }

                        if (n == ADD) {
                            temp.add(list.get(i) + list.get(j));
                        } else if (n == MULTIPLY) {
                            temp.add(list.get(i) * list.get(j));
                        } else if (n == SUBTRACT) {
                            temp.add(list.get(i) - list.get(j));
                        } else if (n == DIVIDE) {
                            if (Math.abs(list.get(j)) < EPSILON) {
                                continue;
                            } else {
                                temp.add(list.get(i) / list.get(j));
                            }
                        }

                        if (solve(temp)) {
                            return true;
                        }

                        temp.remove(temp.size() - 1);
                    }
                }
            }
        }

        return false;
    }
}
