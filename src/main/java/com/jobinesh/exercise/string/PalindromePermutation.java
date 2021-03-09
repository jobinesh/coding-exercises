package com.jobinesh.exercise.string;

/**
 * Given a string, write a function to check if it is a permutation of a palindrome. A palindrome is a word or phrase
 * that is the same forwards and backwards. A permutation is a rearrangement of letters.
 * The palindrome does not need to be limited to just dictionary words.
 */
public class PalindromePermutation {
    public boolean isPermutationPalindrome(String input) {
        char[] inputChars = input.toCharArray();
        int[] charTbl = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
        int oddCnt = 0;
        for (int i = 0; i < inputChars.length; i++) {
            int val = Character.getNumericValue(inputChars[i]);
            if (Character.getNumericValue('a') <= val && Character.getNumericValue('z') >= val) {
                val = val - Character.getNumericValue('a');
                charTbl[val] = charTbl[val] + 1;
                if (charTbl[val] % 2 == 0) {
                    oddCnt--;
                } else {
                    oddCnt++;
                }
            }

        }
        return oddCnt > 1 ? false : true;
    }

    public static void main(String[] args) {
        PalindromePermutation palindromePermutation = new PalindromePermutation();
        boolean result = palindromePermutation.isPermutationPalindrome("geeksogeeks");
        System.out.println("geeksogeeks :" + result);
        result = palindromePermutation.isPermutationPalindrome("geeksforgeeks");
        System.out.println("geeksforgeeks :" + result);
    }
}
