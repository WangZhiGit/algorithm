package com.example.algorithm.leetcode.solution;

public class 回文子串 {
    public int countSubstrings(String s) {
        char[] arr = s.toCharArray();
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            // i为中心
            // i和i+1为中心
            sum = sum + numberOfPalindrome(arr, i, i) + numberOfPalindrome(arr, i, i + 1);
        }

        return sum;
    }

    public int numberOfPalindrome(char[] arr, int left, int right) {
        int count = 0;
        while (left >= 0 && right < arr.length && arr[left] == arr[right]) {
            left--;
            right++;
            count++;
        }

        return count;
    }
}
