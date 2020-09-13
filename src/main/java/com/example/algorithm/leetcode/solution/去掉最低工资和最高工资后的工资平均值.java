package com.example.algorithm.leetcode.solution;

public class 去掉最低工资和最高工资后的工资平均值 {
    public double average(int[] salary) {
        double sum = 0;
        double maxValue = Integer.MIN_VALUE;
        double minValue = Integer.MAX_VALUE;
        for (int num : salary) {
            sum += num;
            maxValue = Math.max(maxValue, num);
            minValue = Math.min(minValue, num);
        }

        return (sum - maxValue - minValue) / (salary.length - 2);
    }
}
