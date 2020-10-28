package com.example.algorithm.leetcode.solution;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 有多少小于当前数字的数字II {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int len = nums.length;
        int[] temp = Arrays.copyOf(nums, len);
        Arrays.sort(temp);
        Map<Integer, Integer> map = new HashMap<>();
        map.put(temp[0], 0);
        for (int i = 1; i < len; i++) {
            if (temp[i] > temp[i - 1]) {
                map.put(temp[i], i);
            } else {
                map.put(temp[i], map.get(temp[i - 1]));
            }
        }

        for (int j = 0; j < len; j++) {
            temp[j] = map.get(nums[j]);
        }

        return temp;
    }
}
