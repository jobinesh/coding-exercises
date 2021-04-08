package com.jobinesh.exercise.array;

import java.util.ArrayDeque;
import java.util.Map;
import java.util.Stack;

/**
 * Given a string containing just the characters '(' and ')',
 * find the length of the longest valid (well-formed) parentheses substring.
 */
public class ValidParentheses {

    public int longestValidParentheses(String s) {

        return 0;
    }
    public boolean isValid(String s) {
        if(s==null || s.isBlank()){
            return false;
        }
        Map<Character,Character> map = Map.of('{','}','[',']','(',')');
        ArrayDeque<Character> stack = new ArrayDeque();
        for (int i = 0; i < s.length(); i++) {
            Character token = map.get(s.charAt(i));
            if(token == null){
                if(!stack.isEmpty() && stack.pop() == s.charAt(i) ){
                    continue;
                }
                return false;
            }else {
                stack.push(token);
            }

        }
        if(stack.isEmpty())
            return true;
        else
            return false;
    }
    public static void main(String[] args){
        System.out.println( new ValidParentheses().isValid( "{((()))[({[]})]{}}"));
        System.out.println( new ValidParentheses().isValid( "([)]"));
    }
}
