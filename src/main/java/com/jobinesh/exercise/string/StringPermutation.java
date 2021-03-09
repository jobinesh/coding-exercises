package com.jobinesh.exercise.string;

/**
 * Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1.
 * In other words, one of the first string's permutations is the substring of the second string.
 */
public class StringPermutation {
    public boolean checkInclusion(String s1, String s2) {
        if (s1 == s2) {
            return true;
        }
        if (s1 == null | s2 == null) {
            return false;
        }
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] index1 = new int[128];
        for (int i = 0; i < s1.length(); i++) {
            index1[s1.charAt(i)] = index1[s1.charAt(i)] + 1;
        }

        int indices[] = new int[s1.length()];
        for (int i = 0; i <= s2.length()-s1.length(); i++) {
            int[] index2 = new int[128];
            int beg=i;
            int end=i+s1.length();
            int index=0;
            for(int j=beg;j<end ;j++){
                indices[index] = s2.charAt(j);
                index2[s2.charAt(j)] = index2[s2.charAt(j)] + 1;
                index++;
            }

            if(isMatch(index1, index2, indices)){
                return true;
            }
        }

        return false;
    }
    private boolean isMatch(int[] index1, int[] index2, int indices[]){
        for(int i=0;i<indices.length;i++){
            if( index1[indices[i]] != 0 &&  index1[indices[i]] >= index2[indices[i]]){
               continue;
            }else{
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args){
        String s1, s2;
        s1 = "adc" ;
        s2 = "dcda";
        System.out.println(new StringPermutation().checkInclusion(s1, s2));
        s1 = "ab" ;
        s2 = "eidboaoo";
        System.out.println(new StringPermutation().checkInclusion(s1, s2));
        s1="ab";
        s2="eidbaooo";
        System.out.println(new StringPermutation().checkInclusion(s1, s2));
    }
}
