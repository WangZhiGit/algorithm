package com.example.algorithm.executable;

public class 最长公共子串 {
    public static String maxSubString(String strOne, String strTwo) {
        String max = strOne.length() > strTwo.length() ? strOne : strTwo;
        String min = strOne.length() > strTwo.length() ? strTwo : strOne;
        String current = new String();
        for (int i = 0; i < min.length(); i++) {
            for (int begin = 0, end = min.length() - i; end <= min.length(); begin++, end++) {
                current = min.substring(begin, end);
                if (max.contains(current)) {
                    return current;
                }
            }
        }

        return null;
    }

    public static void main(String[] args) {
        String strOne = "abcdefg";
        String strTwo = "adefgwgeweg";
        String result = maxSubString(strOne, strTwo);
        System.out.println(result);
    }
}
