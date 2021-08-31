package com.jobinesh.exercise.string;

import java.util.HashMap;

/**
 * Given a string, find the length of the longest substring
 * in it with no more than K distinct characters.
 */
public class LongestSubstringKDistinct {
    public static int findLength(String str, int k) {
        // TODO: Write your code here

        HashMap<Character, Integer> charCountMap = new HashMap<>();
        int subStrLen=0;
        int beg=0;
        int end=0;
       for(int i=0;i<str.length();i++){
           Character currentChar= str.charAt(i);
           charCountMap.put( currentChar, charCountMap.getOrDefault(currentChar,0)+1);
           end=i;
           while(charCountMap.size()>k){
               Character begChar= str.charAt(beg);
               beg=beg+1;
               if(charCountMap.get(begChar)==1){
                   charCountMap.remove(begChar);
               }else{
                   charCountMap.put(begChar, charCountMap.get(begChar)-1);
               }
           }
           subStrLen=Math.max(subStrLen, end-beg+1);
       }
        return subStrLen;
    }


    public static void main(String[] args) {
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("araaci", 2));
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("araaci", 1));
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("cbbebi", 3));
    }
}
