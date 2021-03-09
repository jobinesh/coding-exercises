package com.jobinesh.exercise.string;

/**
 * Assume you have a method isSubstring which checks if one word is a substring of another. Given two strings, s1 and s2,
 * write code to check if s2 is a rotation of s1 using only one call to isSubstring
 * (i.e., “waterbottle” is a rotation of “erbottlewat”).
 */
public class StringRotation {
    public boolean isRotation(String s1, String s2) {
        String s1s2 = s2 + s2;
        if (s1s2.indexOf(s1) != -1) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        boolean isRotated = new StringRotation().isRotation("waterbottle", "erbottlewat");
        System.out.println(isRotated);
        isRotated = new StringRotation().isRotation("abc", "bda");
        System.out.println(isRotated);
    }
}
