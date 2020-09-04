package com.example.algorithm.leetcode.solution;

public class 最短回文串 {
    public String shortestPalindrome(String s) {
        StringBuilder sReverse = new StringBuilder(s).reverse();
        String str = s + "#" + sReverse;
        int[] next = getNext(str);
        String prefix = sReverse.substring(0, sReverse.length() - next[str.length()]);
        return prefix + s;
    }

    //KMP算法
    private int[] getNext(String pattern) {
        //最大值：已匹配前缀的下一个位置为pattern.length()
        int[] next = new int[pattern.length() + 1];
        //已匹配前缀的下一个位置
        int i = 2;
        //最长可匹配前缀子串的下一个位置
        int j = 0;
        //前缀不存在
        next[0] = 0;
        //前缀只有一个字符
        next[1] = 0;
        while (i < next.length) {
            if (pattern.charAt(i-1) == pattern.charAt(j)) {
                next[i++] = ++j;
            } else if (j == 0){
                i++;
            } else {
                j = next[j];
            }
        }

        return next;
    }
}
