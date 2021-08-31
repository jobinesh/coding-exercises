package com.jobinesh.exercise.dp;

/*
Given an infinite supply of ‘n’ coin denominations and a total money amount, we are asked to find the
 minimum number of coins needed to make up that amount.
 */
public class MinCoinChange {
    public int countChange(int[] denominations, int total) {
        // TODO: Write your code here
        Integer[][] dp = new Integer[denominations.length][total + 1];
        int result = findMinCoinCount(dp, denominations, 0, total);
        if (result == Integer.MAX_VALUE) {
            return -1;
        } else {
            return result;
        }
    }

    public int findMinCoinCount(Integer[][] dp, int[] denominations, int index, int total) {

        if (total == 0) {
            return 0;
        }
        if (index >= denominations.length) {
            return Integer.MAX_VALUE;
        }
        int cnt1 = Integer.MAX_VALUE;
        if (dp[index][total] == null) {
            if (denominations[index] <= total) {
                int res = findMinCoinCount(dp, denominations, index, total - denominations[index]);
                if (res != Integer.MAX_VALUE) {
                    cnt1 = res + 1;
                }
            }
            int cnt2 = findMinCoinCount(dp, denominations, index + 1, total);

            dp[index][total] = Math.min(cnt1, cnt2);
        }
        return dp[index][total];

    }

    public static void main(String[] args) {
        MinCoinChange cc = new MinCoinChange();
        int[] denominations = {1, 2, 3};
        System.out.println(cc.countChange(denominations, 5));
        System.out.println(cc.countChange(denominations, 11));
        System.out.println(cc.countChange(denominations, 7));
        denominations = new int[]{3, 5};
        System.out.println(cc.countChange(denominations, 7));
    }
}
