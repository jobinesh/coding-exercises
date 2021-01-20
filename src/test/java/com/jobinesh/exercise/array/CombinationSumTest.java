package com.jobinesh.exercise.array;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumTest extends TestCase {

    public void testCombinationSum() {
        List<List<Integer>> expected = new ArrayList<>();
        List<Integer> item1 = Arrays.asList(new Integer[]{2, 2, 3});
        List<Integer> item2 = Arrays.asList(new Integer[]{7});
        expected.add(item1);
        expected.add(item2);
        List<List<Integer>> result = new CombinationSum().combinationSum(new int[]{2, 3, 6, 7}, 7);
        assertTrue(expected.size() == result.size() );
        assertTrue(expected.containsAll(result) );
        assertTrue( result.containsAll(expected));
    }
}