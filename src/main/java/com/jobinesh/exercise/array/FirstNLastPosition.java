package com.jobinesh.exercise.array;

import java.util.Arrays;

/**
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 * <p>
 * If target is not found in the array, return [-1, -1].
 * <p>
 * Follow up: Could you write an algorithm with O(log n) runtime complexity?
 */
public class FirstNLastPosition {
    public int[] searchRange(int[] nums, int target) {
        int[] indices = {-1, -1};
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                if (indices[0] == -1) {
                    indices[0] = i;
                } else if (indices[1] == -1 || nums[indices[1]] == target) {
                    indices[1] = i;
                }
            }
        }
        if (indices[1] == -1) {
            indices[1] = indices[0];
        }
        return indices;
    }

    public static void main(String[] args) {
        int[] region = {5, 7, 7,7, 8, 8, 10};
        int[] indices = new FirstNLastPosition().searchRange(region, 7);
        System.out.println(Arrays.toString(indices));
    }
}
