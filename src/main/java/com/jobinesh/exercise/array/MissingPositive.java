package com.jobinesh.exercise.array;

import java.util.Arrays;

/**
 * Given an unsorted integer array nums, find the smallest missing positive integer.
 * <p>
 * Follow up: Could you implement an algorithm that runs in O(n) time and uses constant extra space.?
 */
public class MissingPositive {
    public int firstMissingPositive(int[] nums) {
        int negArrayIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0) {
                int tmp = nums[negArrayIndex];
                nums[negArrayIndex] = nums[i];
                nums[i] = tmp;
                negArrayIndex++;
            }
        }
        for (int i = negArrayIndex; i < nums.length; i++) {
            int value = Math.abs(nums[i]) - 1;
            if ((value + negArrayIndex) < nums.length && (value + negArrayIndex) > -1) {
                if (nums[value + negArrayIndex] > 0)
                    nums[value + negArrayIndex] = -nums[value + negArrayIndex];
            }
        }

        for (int i = negArrayIndex; i < nums.length; i++) {
            if (nums[i] > 0) {
                int ans = i + 1 - negArrayIndex;
                return ans;
            }
        }
        return nums.length + 1 - negArrayIndex;
    }

    public int firstMissingPositiveSimple(int[] nums) {

        boolean found[] = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0 && nums[i] < nums.length)
                found[nums[i]] = true;
        }
        for (int i = 1; i < found.length; i++) {
            if (found[i] == false) {
                return i;
            }
        }
        return nums.length;
    }

    public static void main(String[] args) {
        System.out.println("Ans: " + new MissingPositive().firstMissingPositive(new int[]{2147483647, 2147483646, 2147483645, 3, 2, 1, -1, 0, -2147483648}));
        System.out.println("Ans: " + new MissingPositive().firstMissingPositive(new int[]{2, 2}));
        System.out.println("Ans: " + new MissingPositive().firstMissingPositive(new int[]{1, 2, 2, 3}));

        System.out.println("Ans: " + new MissingPositive().firstMissingPositive(new int[]{2, 3, 1}));
        // System.out.println("Ans: " +new MissingPositive().firstMissingPositive(new int[]{5, 2, 3, 1, 0, -3, -5, -10}));
    }
}
