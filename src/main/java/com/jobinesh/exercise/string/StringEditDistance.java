package com.jobinesh.exercise.string;

/**
 * Given two strings, find if they are one edit away from each other
 */
public class StringEditDistance {
    public boolean isOneEditAway(String st1, String st2) {
        if (Math.abs(st1.length() - st2.length()) > 1) {
            return false;
        }
        if (st1.length() == st2.length()) {
            return isEqualWithReplace(st1, st2);
        } else if (st1.length() < st2.length()) {
            return isEqualWithInsert(st1, st2);
        } else {
            return isEqualWithDelete(st1, st2);
        }

    }

    private boolean isEqualWithReplace(String st1, String st2) {
        boolean notEqual = false;
        for (int i = 0; i < st1.length(); i++) {
            if (st1.charAt(i) != st2.charAt(i)) {
                if (notEqual) {
                    return false;
                }
                notEqual = true;
            }
        }
        return true;
    }

    private boolean isEqualWithInsert(String st1, String st2) {
        int index1 = 0;
        int index2 = 0;
        int cnt = 0;
        while (index1 < st1.length() && index2 < st2.length()) {
            if (st1.charAt(index1) != st2.charAt(index2)) {
                cnt++;
                index2++;
            } else {
                index1++;
                index2++;
            }

            if (cnt > 1) {
                return false;
            }
        }
        if (cnt > 1) {
            return false;
        } else {
            return true;
        }
    }

    private boolean isEqualWithDelete(String st1, String st2) {
        return isEqualWithInsert(st2, st1);
    }

    public static void main(String[] args) {
        System.out.println(new StringEditDistance().isOneEditAway("apple", "akkkle"));
        System.out.println(new StringEditDistance().isOneEditAway("apple", "appl"));
        System.out.println(new StringEditDistance().isOneEditAway("apple", "applw"));
        System.out.println(new StringEditDistance().isOneEditAway("apple", "appple"));
        System.out.println(new StringEditDistance().isOneEditAway("apple", "aapple"));
    }
}

