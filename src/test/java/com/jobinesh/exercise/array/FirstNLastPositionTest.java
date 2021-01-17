package com.jobinesh.exercise.array;

import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class FirstNLastPositionTest extends TestCase {

    @Test
    public void testSearchRange() {
        int[] region = {5, 7, 7,7, 8, 8, 10};
        int[] indices = new FirstNLastPosition().searchRange(region, 7);
        assertArrayEquals(indices,new int[] {1,3} );
    }
}