package com.jobinesh.exercise.string;

import java.util.Arrays;

public class StringCompression {
    /**
     * Given an array of characters chars, compress it using the following algorithm:
     * <p>
     * Begin with an empty string s. For each group of consecutive repeating characters in chars:
     * <p>
     * If the group's length is 1, append the character to s.
     * Otherwise, append the character followed by the group's length.
     * The compressed string s should not be returned separately, but instead be stored in the input character array chars. Note that group lengths that are 10 or longer will be split into multiple characters in chars.
     * <p>
     * After you are done modifying the input array, return the new length of the array.
     * <p>
     * <p>
     * Follow up:
     * Could you solve it using only O(1) extra space?
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: chars = ["a","a","b","b","c","c","c"]
     * Output: Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]
     * Explanation: The groups are "aa", "bb", and "ccc". This compresses to "a2b2c3".
     *
     * @param chars
     * @return
     */

    public int compress(char[] chars) {
        int resultIndex=0;
        int index=0;
        int cnt=0;
        while(index<chars.length){
            char currentChar = chars[index];
            while(index<chars.length && chars[index] == currentChar ){
                cnt++;
                index++;
            }
            chars[resultIndex]=currentChar;
            if(cnt>1) {
                char[] cntArray = Integer.toString(cnt).toCharArray();
                for(char ch:cntArray){
                    chars[++resultIndex]=ch;
                }
            }
            resultIndex++;
            cnt=0;
        }
        return resultIndex;
    }
    public static void main(String[] args) {
        char[] chars = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        int cnt = new StringCompression().compress(chars);
        System.out.println("chars :" + Arrays.toString(chars));
        System.out.println("cnt :" + cnt);
        chars="aaabbbbbaaaaaddddd".toCharArray();
         cnt = new StringCompression().compress(chars);
        System.out.println("chars :" + Arrays.toString(chars));
        System.out.println("cnt :" + cnt);

    }
}
