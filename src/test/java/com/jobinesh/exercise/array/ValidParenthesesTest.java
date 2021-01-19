package com.jobinesh.exercise.array;

import junit.framework.TestCase;
import org.junit.Test;

public class ValidParenthesesTest extends TestCase {

    public void testLongestValidParentheses() {
    }
    @Test
    public void testIsValid() {
        ValidParentheses validParentheses = new ValidParentheses();
        boolean isValid = validParentheses.isValid( "{((()))[({[]})]{}}");
        assertTrue(isValid);
    }
}