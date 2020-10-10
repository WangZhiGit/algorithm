package com.example.algorithm.leetcode.solution;

import java.util.HashSet;
import java.util.Set;

public class 宝石与石头 {
    public int numJewelsInStones(String J, String S) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < J.length(); i++) {
            set.add(J.charAt(i));
        }

        int count = 0;
        for (int i = 0; i < S.length(); i++) {
            if (set.contains(S.charAt(i))) {
                count++;
            }
        }

        return count;
    }
}
