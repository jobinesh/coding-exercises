package com.jobinesh.exercise.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of distinct integers candidates and a target integer target,
 * return a list of all unique combinations of candidates where the chosen numbers sum to target.
 * You may return the combinations in any order.
 * <p>
 * The same number may be chosen from candidates an unlimited number of times.
 * Two combinations are unique if the frequency of at least one of the chosen numbers is different.
 * <p>
 * It is guaranteed that the number of unique combinations that sum up to target
 * is less than 150 combinations for the given input.
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> combinations = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        sum(candidates, 0, 0, target, combination, combinations);
        return combinations;
    }

    private void sum(int[] candidates, int beg, int sum, int target, List<Integer> combination, List<List<Integer>> combinations) {
        if (sum == target) {
            combinations.add(new ArrayList<>(combination));
            return;
        } else if (sum > target) {
            return;
        }
        for (int i = beg; i < candidates.length; i++) {
            combination.add(candidates[i]);
            sum(candidates, i, sum + candidates[i], target, combination, combinations);
            combination.remove(combination.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> combinations = new CombinationSum().combinationSum(new int[]{2, 3, 6, 7}, 7);
        System.out.println(combinations);
    }
}
