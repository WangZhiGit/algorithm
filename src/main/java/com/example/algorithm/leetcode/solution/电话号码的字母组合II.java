package com.example.algorithm.leetcode.solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 电话号码的字母组合II {
    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();

        String[] dic = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        for (int i = 0; i < digits.length(); i++) {
            int index = Integer.parseInt(String.valueOf(digits.charAt(i))) - 2;
            if (combinations.size() == 0) {
                for (int j = 0; j < dic[index].length(); j++) {
                    combinations.add(String.valueOf(dic[index].charAt(j)));
                }
                continue;
            }

            List<String> temp = new ArrayList<>(combinations);
            combinations.clear();
            for (String str : temp) {
                for (int n = 0; n < dic[index].length(); n++) {
                    combinations.add(str + String.valueOf(dic[index].charAt(n)));
                }
            }
        }

        return combinations;
    }
}
