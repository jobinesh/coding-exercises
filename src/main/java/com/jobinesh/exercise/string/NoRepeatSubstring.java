package com.jobinesh.exercise.string;

import java.util.HashMap;

/**
 * Given a string, find the length of the longest substring, which has no repeating characters.
 */
public class NoRepeatSubstring {
    public static int findLength(String str) {
        // TODO: Write your code here
        HashMap<Character, Integer> map = new HashMap<>();
        int beg = 0;
        int len = 0;
        for (int i = 0; i < str.length(); i++) {
            Character current = str.charAt(i);
            if (map.containsKey(current)) {
                beg = map.get(current)+1;
            } else {
                map.put(current, i);
                len = Math.max(len, i - beg +1);
            }
        }
        return len;
    }

    public static void main(String[] args) {
        System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("aabccbb"));
        System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("abbbb"));
        System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("abccde"));
    }
}
