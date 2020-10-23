package com.example.algorithm.leetcode.solution;

public class 长按键入 {
    public boolean isLongPressedName(String name, String typed) {
        int i = 0;
        int j = 0;
        while (i < name.length()) {
            if (j >= typed.length()) {
                return false;
            }

            if (name.charAt(i) == typed.charAt(j)) {
                i++;
                j++;
            } else if (i > 0 && name.charAt(i - 1) == typed.charAt(j)) {
                j++;
            } else {
                return false;
            }
        }

        while (j < typed.length()) {
            if (name.charAt(i - 1) == typed.charAt(j)) {
                j++;
            } else {
                return false;
            }
        }

        return true;
    }
}
