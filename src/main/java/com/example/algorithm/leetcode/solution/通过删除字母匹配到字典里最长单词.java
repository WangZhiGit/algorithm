package com.example.algorithm.leetcode.solution;

import java.util.List;

public class 通过删除字母匹配到字典里最长单词 {
    public String findLongestWord(String s, List<String> d) {
        String result = new String();
        for (String str : d) {
            if (isSubStr(s, str)) {
                if (result.length() == 0) {
                    result = str;
                } else {
                    if (str.length() > result.length() || (str.length() == result.length() && str.compareTo(result) < 0)) {
                        result = str;
                    }
                }
            }
        }

        return result;
    }

    //判断是否是子序列
    private boolean isSubStr(String str, String subStr) {
        int i = 0;
        int j = 0;

        while (i < str.length() && j < subStr.length()) {
            if (str.charAt(i) == subStr.charAt(j)) {
                j++;
            }
            i++;
        }

        return j == subStr.length();
    }
}
