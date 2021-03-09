package com.jobinesh.exercise.string;

import java.util.Arrays;

/**
 * Given a string, determine if the string has all unique characters without additional datastructures
 */
public class UniqueCharString {
    public boolean isUnique1(String str) {
        boolean[] parsed = new boolean[128];
        for (int i = 0; i < str.length(); i++) {
            int index = str.charAt(i);
            if (parsed[index]) {
                return false;
            } else {
                parsed[index] = true;
            }
        }
        return true;
    }

    public boolean isUnique2(String str) {
        char[] inp = str.toCharArray();
        Arrays.sort(inp);
        for (int i = 0; i < inp.length - 1; i++) {

            if (inp[i] == inp[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public boolean isUnique3(String str) {
        int checker = 0;
        char[] inp = str.toCharArray();
        for (int i = 0; i < inp.length - 1; i++) {
            int index = inp[i] - 'a';
            if ((checker & 1 << index) > 0) {
                return false;
            }
            checker = checker | 1 << index;
        }
        return true;
    }

    public static void main(String[] arg) {
        System.out.println(new UniqueCharString().isUnique3("abcdefg"));
    }
}
