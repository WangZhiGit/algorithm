package com.example.algorithm.leetcode.solution;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 单词接龙 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String temp = queue.poll();
                if (temp.equals(endWord)) {
                    return steps + 1;
                }

                Iterator<String> iterator = wordList.iterator();
                while (iterator.hasNext()) {
                    String current = iterator.next();
                    if (canTransform(temp, current)) {
                        queue.offer(current);
                        iterator.remove();
                    }
                }
            }

            steps++;
        }

        return 0;
    }

    boolean canTransform(String word1, String word2) {
        int count = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                count++;
            }
        }

        return count == 1;
    }
}
