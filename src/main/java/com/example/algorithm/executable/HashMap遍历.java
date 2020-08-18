package com.example.algorithm.executable;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMap遍历 {
    //迭代器 EntrySet
    @Test
    public void testEntrySet() {
        //创建并赋值HashMap
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Java");
        map.put(2, "JDK");
        map.put(3, "Spring Framework");
        map.put(4, "MyBatis framework");
        map.put(5, "Java中文社群");

        //遍历
        Iterator<Map.Entry<Integer, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, String> entry = iterator.next();
            System.out.println(entry.getKey() + ", " + entry.getValue());
        }
    }

    //迭代器 KeySet
    @Test
    public void testKeySet() {
        //创建并赋值HashMap
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Java");
        map.put(2, "JDK");
        map.put(3, "Spring Framework");
        map.put(4, "MyBatis framework");
        map.put(5, "Java中文社群");

        //遍历
        Iterator<Integer> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            Integer key = iterator.next();
            System.out.println(key + ", " + map.get(key));
        }
    }

    //ForEach EntrySet
    @Test
    public void testForEachEntrySet() {
        //创建并赋值HashMap
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Java");
        map.put(2, "JDK");
        map.put(3, "Spring Framework");
        map.put(4, "MyBatis framework");
        map.put(5, "Java中文社群");

        //遍历
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ", " + entry.getValue());
        }
    }

    //ForEach KeySet
    @Test
    public void testForEachKeySet() {
        //创建并赋值HashMap
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Java");
        map.put(2, "JDK");
        map.put(3, "Spring Framework");
        map.put(4, "MyBatis framework");
        map.put(5, "Java中文社群");

        //遍历
        for (Integer key : map.keySet()) {
            System.out.println(key + ", " + map.get(key));
        }
    }

    //Lambda
    @Test
    public void testLambda() {
        //创建并赋值HashMap
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Java");
        map.put(2, "JDK");
        map.put(3, "Spring Framework");
        map.put(4, "MyBatis framework");
        map.put(5, "Java中文社群");

        //遍历
        map.forEach((key, value) -> {
            System.out.println(key + ", " + value);
        });
    }

    //Streams API 单线程
    @Test
    public void testStreamsAPISingle() {
        //创建并赋值HashMap
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Java");
        map.put(2, "JDK");
        map.put(3, "Spring Framework");
        map.put(4, "MyBatis framework");
        map.put(5, "Java中文社群");

        //遍历
        map.entrySet().stream().forEach((entry) -> {
            System.out.println(entry.getKey() + ", " + entry.getValue());
        });
    }

    //Streams API 多线程
    @Test
    public void testStreamsAPIMulti() {
        //创建并赋值HashMap
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Java");
        map.put(2, "JDK");
        map.put(3, "Spring Framework");
        map.put(4, "MyBatis framework");
        map.put(5, "Java中文社群");

        //遍历
        map.entrySet().parallelStream().forEach((entry) -> {
            System.out.println(entry.getKey() + ", " + entry.getValue());
        });
    }
}
