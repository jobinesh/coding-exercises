package com.jobinesh.exercise.array;

import junit.framework.TestCase;
import org.junit.Test;

public class MissingPositiveTest extends TestCase {
    @Test
    public void testFirstMissingPositive() {
        int result = new MissingPositive().firstMissingPositive(new int[]{2147483647, 2147483646, 2147483645, 3, 2, 1, -1, 0, -2147483648});
        assertEquals(4, result);
    }
}