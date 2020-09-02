package com.example.algorithm.executable;

public class 最长公共子串II {
    public static String maxSubString(String A, String B) {
        int[][] dp = new int[A.length()][B.length()];
        int end_index = 0;
        int maxLength = 0;
        for (int i = 0; i < A.length(); i++) {
            for (int j = 0; j < B.length(); j++) {
                if (A.charAt(i) == B.charAt(j)) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }

                    if (dp[i][j] > maxLength) {
                        maxLength = dp[i][j];
                        end_index = j;
                    }
                }
            }
        }

        return B.substring(end_index + 1 - maxLength, end_index + 1);
    }

    public static void main(String[] args) {
        String strOne = "abcdefg";
        String strTwo = "adefgwgeweg";
        String result = maxSubString(strOne, strTwo);
        System.out.println(result);
    }
}
