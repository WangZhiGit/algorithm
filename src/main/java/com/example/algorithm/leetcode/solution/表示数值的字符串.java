package com.example.algorithm.leetcode.solution;

public class 表示数值的字符串 {
    public boolean isNumber(String s) {
        boolean numSeen = false;
        boolean dotSeen = false;
        boolean eSeen = false;

        char[] str = s.trim().toCharArray();
        for (int i = 0; i < str.length; i++) {
            if (str[i] >= '0' && str[i] <= '9') {
                numSeen = true;
            } else if (str[i] == '.') {
                if (dotSeen == true || eSeen == true) {
                    return false;
                }
                dotSeen = true;
            } else if (str[i] == 'e' || str[i] == 'E') {
                if (eSeen == true || numSeen == false) {
                    return false;
                }
                eSeen = true;
                numSeen = false;
            } else if (str[i] == '+' || str[i] == '-') {
                if (i != 0 && str[i - 1] != 'e' && str[i - 1] != 'E') {
                    return false;
                }
            } else {
                return false;
            }
        }

        return numSeen;
    }
}
