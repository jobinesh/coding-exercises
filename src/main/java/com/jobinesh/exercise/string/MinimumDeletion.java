package com.jobinesh.exercise.string;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Given string str, the task is to find the minimum count of characters that need to be deleted from the
 * string such that the frequency of each character of the string is unique.
 */
class Solution {
    Map<Character, Integer> charFreqMap = new HashMap<>();
    PriorityQueue<Integer> occurances = new PriorityQueue<>((x, y) -> Integer.compare(y, x));

    public int minDeletions(String s) {
        int freq = 0;
        if (s == null || s.trim().length() == 0) {
            return freq;
        }
        int len = s.length();
        int cnt = 0;
        while (cnt < len) {
            Character ch = s.charAt(cnt);
            if (charFreqMap.containsKey(ch)) {
                charFreqMap.put(ch, charFreqMap.get(ch) + 1);
            } else {
                charFreqMap.put(ch, 1);
            }
            cnt++;
        }
        charFreqMap.entrySet().forEach((entry) -> {
            occurances.add(entry.getValue());
        });
        while (!occurances.isEmpty()) {
            int top = occurances.remove();
            if (occurances.isEmpty()) {
                break;
            }
            int next = occurances.peek();
            if (top > 0 && top == next) {
                freq++;
                occurances.add(top - 1);
            }
        }
        return freq;
    }
}

public class MinimumDeletion {
    public static void main(String[] args) {
        int result = new Solution().minDeletions("ceabaacb");
        System.out.println(result);
        result = new Solution().minDeletions("aaabbbcc");
        System.out.println(result);
        result = new Solution().minDeletions("bbcebab");
        System.out.println(result);
    }
}
