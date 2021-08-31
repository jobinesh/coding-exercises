package com.jobinesh.exercise.dp;

/**
 * There are n houses built in a line. A thief wants to steal the maximum possible money from these houses.
 * The only restriction the thief has is that he can’t steal from two consecutive houses,
 * as that would alert the security system. How should the thief maximize his stealing?
 */
public class HouseThief {
    public int findMaxSteal(int[] wealth) {
        // TODO: Write your code here
        Integer[][] dp = new Integer[wealth.length][wealth.length + 1];
        return findMaxStealRecursively(dp, wealth, 0);
    }

    public int findMaxStealRecursively(Integer[][] dp, int[] wealth, int index) {

        if (index >= wealth.length) {
            return 0;
        }
        if (dp[index][index] == null) {
            int sum1 = wealth[index] + findMaxStealRecursively(dp, wealth, index + 2);
            int sum2 = findMaxStealRecursively(dp, wealth, index + 1);

            dp[index][index] = Math.max(sum1, sum2);
        }
        return dp[index][index];

    }

    public int findMaxStealBottomup(int[] wealth) {
        int[] houses = new int[wealth.length + 1];
        houses[0] = 0;
        houses[1] = wealth[0];
        for (int i = 1; i < wealth.length; i++) {
            houses[i + 1] = Math.max(wealth[i] + houses[i - 1], houses[i]);
        }
        return houses[wealth.length];
    }

    public static void main(String[] args) {
        HouseThief ht = new HouseThief();
        int[] wealth = {2, 5, 1, 3, 6, 2, 4};
        System.out.println(ht.findMaxStealBottomup(wealth));
        wealth = new int[]{2, 10, 14, 8, 1};
        System.out.println(ht.findMaxStealBottomup(wealth));
    }
}
