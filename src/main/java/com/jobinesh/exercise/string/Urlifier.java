package com.jobinesh.exercise.string;

import java.util.Arrays;

/**
 * Write a method to replace all the spaces in a string with ‘%20’. You may assume that the string has sufficient space
 * at the end to hold the additional characters and that you are given the “true” length of the string.
 */
public class Urlifier {
    public void replaceSpace(char[] chars, int length) {
        int index = chars.length - 1;
        for (int i = length - 1; i >= 0; i--) {
            if (chars[i] == ' ') {
                chars[index--] = '0';
                chars[index--] = '2';
                chars[index--] = '%';
            } else {
                chars[index] = chars[i];
                index--;
            }
        }
    }

    public static void main(String[] args) {
        Urlifier urlifier = new Urlifier();
        char[] srcUrl = null;
        char[] trgetUrl = null;
        srcUrl = "Mr John Smith".toCharArray();
        trgetUrl = Arrays.copyOf(srcUrl,  srcUrl.length + 4);
        urlifier.replaceSpace(trgetUrl, 13);
        System.out.println(Arrays.toString(trgetUrl));
        srcUrl = " Mr John ".toCharArray();
        trgetUrl = Arrays.copyOf(srcUrl, srcUrl.length + 6);
        urlifier.replaceSpace(trgetUrl, srcUrl.length);
        System.out.println(Arrays.toString(trgetUrl));
    }
}
