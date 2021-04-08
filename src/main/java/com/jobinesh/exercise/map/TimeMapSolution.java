package com.jobinesh.exercise.map;

/**
 * Write a map implementation with a get function that lets you retrieve the value of a key at a particular time.
 * <p>
 * It should contain the following methods:
 * <p>
 * set(key, value, time): sets key to value for t = time.
 * get(key, time): gets the key at t = time.
 * The map should work like this. If we set a key at a particular time, it will maintain that value forever or until
 * it gets set at a later time. In other words, when we get a key at a time, it should return the value that was
 * set for that key set at the most recent time.
 * <p>
 * Consider the following examples:
 * Consider the following examples:
 * <p>
 * d.set(1, 1, 0) # set key 1 to value 1 at time 0
 * d.set(1, 2, 2) # set key 1 to value 2 at time 2
 * d.get(1, 1) # get key 1 at time 1 should be 1
 * d.get(1, 3) # get key 1 at time 3 should be 2
 */

import java.io.*;
import java.util.*;

import org.junit.*;
import org.junit.runner.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */
class TimeMapImpl {
    Map<String, TreeMap<Integer, String>> keyValue = new HashMap();

    public void set(String key, String value, int time) {
        TreeMap timeMap = keyValue.get(key);
        if (timeMap == null) {
            timeMap = new TreeMap();
        }
        timeMap.put(time, value);
        keyValue.put(key, timeMap);
    }

    public String get(String key, int timestamp) {
        TreeMap<Integer, String> timeMap = keyValue.get(key);
        if (timeMap == null) {
            return "";
        }
        Integer t = timeMap.floorKey(timestamp);
        if (t == null) {
            return "";
        }
        return timeMap.get(t);
    }

}

public class TimeMapSolution {
    @Test
    public void testTimeMapSize() {
        TimeMap map = new TimeMap();
        map.set("1", "1", 0);
        map.set("1", "2", 2);
        map.set("3", "2", 2);
        Assert.assertEquals(2, map.keyValue.entrySet().size());
    }

    @Test
    public void testTimeMapReadWithExactMatch() {
        TimeMap map = new TimeMap();
        map.set("1", "1", 0);
        map.set("1", "2", 3);
        Assert.assertEquals("1", map.get("1", 0));
    }

    @Test
    public void testTimeMapReadWithRecent() {
        TimeMap map = new TimeMap();
        map.set("1", "1", 0);
        map.set("1", "2", 2);
        Assert.assertEquals("2", map.get("1", 3));
    }

    public static void main(String[] args) {
        JUnitCore.main(TimeMapSolution.class.getName());
    }
}