package com.example.algorithm.leetcode.solution;

import java.util.*;

public class 重新安排行程 {
    private List<String> result = new ArrayList<>();
    private Map<String, PriorityQueue<String>> map = new HashMap<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> pair : tickets) {
            String key = pair.get(0);
            String value = pair.get(1);

            if (!map.containsKey(key)) {
                PriorityQueue<String> priorityQueue = new PriorityQueue<>();
                priorityQueue.add(value);
                map.put(key, priorityQueue);
            } else {
                map.get(key).add(value);
            }
        }

        getPath("JFK");
        return result;
    }

    private void getPath(String begin) {
        while (map.containsKey(begin) && map.get(begin).size() != 0) {
            getPath(map.get(begin).poll());
        }

        result.add(0, begin);
    }
}
