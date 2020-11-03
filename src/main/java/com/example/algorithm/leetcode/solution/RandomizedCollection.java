package com.example.algorithm.leetcode.solution;

import java.util.*;

public class RandomizedCollection {
    //所有数字在列表中每一次出现的下标集合
    private Map<Integer, List<Integer>> map = new HashMap<>();
    //目标集合
    private List<Integer> list = new ArrayList<>();

    /**
     * Initialize your data structure here.
     */
    public RandomizedCollection() {

    }

    /**
     * Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
     */
    public boolean insert(int val) {
        list.add(val);
        List<Integer> temp = map.get(val);
        if (temp == null) {
            temp = new ArrayList<>();
            temp.add(list.size() - 1);
            map.put(val, temp);
            return true;
        } else {
            temp.add(list.size() - 1);
            return false;
        }
    }

    /**
     * Removes a value from the collection. Returns true if the collection contained the specified element.
     */
    public boolean remove(int val) {
        List<Integer> temp = map.get(val);
        if (temp == null) {
            return false;
        }

        //被移除元素在列表中的位置
        int item = temp.remove(0);
        if (temp.size() == 0) {
            map.remove(val);
        }

        if (list.size() - 1 == item) {
            list.remove(item);
        } else {
            //移除最后一个，然后把最后一个元素的值更新到需要删除值的位置
            Integer lastItem = list.remove(list.size() - 1);
            list.set(item, lastItem);
            temp = map.get(lastItem);
            temp.remove((Integer) list.size());
            temp.add(item);
        }

        return true;
    }

    /**
     * Get a random element from the collection.
     */
    public int getRandom() {
        Random random = new Random();
        return list.get(random.nextInt(list.size()));
    }
}
