package com.example.algorithm.leetcode.solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 查找常用字符 {
    public List<String> commonChars(String[] A) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < A[0].length(); i++) {
            char c = A[0].charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int i = 1; i < A.length; i++) {
            Map<Character, Integer> temp = new HashMap<>();
            for (int j = 0; j < A[i].length(); j++) {
                char c = A[i].charAt(j);
                if (map.containsKey(c) && map.get(c) > 0) {
                    temp.put(c, temp.getOrDefault(c, 0) + 1);
                    map.put(c, map.get(c) - 1);
                }
            }

            map = temp;
            if (map.size() == 0) {
                break;
            }
        }

        List<String> result = new ArrayList<>();
        for (Character c : map.keySet()) {
            for (int k = 0; k < map.get(c); k++) {
                result.add("" + c);
            }
        }

        return result;
    }
}
