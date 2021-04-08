package com.jobinesh.exercise.map;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
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
 *
 * d.set(1, 1, 0) # set key 1 to value 1 at time 0
 * d.set(1, 2, 2) # set key 1 to value 2 at time 2
 * d.get(1, 1) # get key 1 at time 1 should be 1
 * d.get(1, 3) # get key 1 at time 3 should be 2
 * d.set(1, 1, 5) # set key 1 to value 1 at time 5
 * d.get(1, 0) # get key 1 at time 0 should be null
 * d.get(1, 10) # get key 1 at time 10 should be 1
 * d.set(1, 1, 0) # set key 1 to value 1 at time 0
 * d.set(1, 2, 0) # set key 1 to value 2 at time 0
 * d.get(1, 0) # get key 1 at time 0 should be 2
 */
public class TimeMap {
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
    public static void main(String[] args) {
        /*
        d.set(1, 1, 0) # set key 1 to value 1 at time 0
        d.set(1, 2, 2) # set key 1 to value 2 at time 2
        d.get(1, 1) # get key 1 at time 1 should be 1
        d.get(1, 3) # get key 1 at time 3 should be 2
         */
        TimeMap map = new TimeMap();
        map.set("1", "1", 0);
        map.set("1", "2", 2);
        System.out.println(map.get("1", 1));
        System.out.println(map.get("1", 3));
    }
}
